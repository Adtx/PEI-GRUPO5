import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.datavec.api.util.ClassPathResource;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.lossfunctions.LossFunctions.LossFunction;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NeuralNet {

    List<double[]> data;
    MultiLayerNetwork model;

    public NeuralNet(){
    }

    public NeuralNet(String model_file){
        try {
            model = ModelSerializer.restoreMultiLayerNetwork(model_file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void train_neural_net(){
        int seed = 123;
        double learningRate = 0.00001;
        int batchSize = 5;
        int nEpochs = 200;

        //need to be changed manually in case of change to the train/test file
        int numInputs = 27;
        int numOutputs = 6;
        int numHiddenNodes = 120;

        String filenameTrain="train_results_neural_net.csv";
        String filenameTest="test_results_neural_net.csv";
        /*
        try {
            filenameTrain = new ClassPathResource("test_results_neural_net.csv").getFile().getPath();
            filenameTest  = new ClassPathResource("test_results_neural_net.csv").getFile().getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */

        //Load the training data:
        RecordReader rr = new CSVRecordReader(1,";");
        //rr.initialize(new FileSplit(new File(filenameTrain)));
        try {
            rr.initialize(new FileSplit(new File(filenameTrain)));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DataSetIterator trainIter = new RecordReaderDataSetIterator(rr,batchSize,0,6);

        //Load the test/evaluation data:
        RecordReader rrTest = new CSVRecordReader(1,";");
        try {
            rrTest.initialize(new FileSplit(new File(filenameTest)));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DataSetIterator testIter = new RecordReaderDataSetIterator(rrTest,batchSize,0,6);

        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                .seed(seed)
                .iterations(1)
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                .learningRate(learningRate)
                .updater(Updater.NESTEROVS)     //To configure: .updater(new Nesterovs(0.9))
                .list()
                .layer(0, new DenseLayer.Builder().nIn(numInputs).nOut(numHiddenNodes)
                        .weightInit(WeightInit.XAVIER)
                        .activation(Activation.RELU)
                        .build())
                .layer(1, new DenseLayer.Builder().nIn(numHiddenNodes).nOut(60)
                        .weightInit(WeightInit.XAVIER)
                        .activation(Activation.RELU)
                        .build())
                .layer(2, new OutputLayer.Builder(LossFunction.NEGATIVELOGLIKELIHOOD)
                        .weightInit(WeightInit.XAVIER)
                        .activation(Activation.SOFTMAX).weightInit(WeightInit.XAVIER)
                        .nIn(60).nOut(numOutputs).build())
                .pretrain(false).backprop(true).build();


        model = new MultiLayerNetwork(conf);
        model.init();
        model.setListeners(new ScoreIterationListener(1));  //Print score every 10 parameter updates


        for ( int n = 0; n < nEpochs; n++) {
            model.fit( trainIter );
        }

        System.out.println("Evaluate model....");
        Evaluation eval = new Evaluation(numOutputs);
        while(testIter.hasNext()){
            DataSet t = testIter.next();
            INDArray features = t.getFeatureMatrix();
            INDArray lables = t.getLabels();
            INDArray predicted = model.output(features,false);

            eval.eval(lables, predicted);

        }

        //Print the evaluation statistics
        System.out.println(eval.stats());

        //Save the model
        File locationToSave = new File("MyMultiLayerNetwork.zip");      //Where to save the network. Note: the file is in .zip format - can be opened externally
        boolean saveUpdater = true;                                             //Updater: i.e., the state for Momentum, RMSProp, Adagrad etc. Save this if you want to train your network more in the future
        try {
            ModelSerializer.writeModel(model, locationToSave, saveUpdater);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //------------------------------------------------------------------------------------
    //Training is complete. Code that follows is for plotting the data & predictions only


    public double predict(String teste_results,String separator){
        load_for_prediction(teste_results,separator);

        double res=predict();

        return res;
    }

    private double predict(){
        double res=100;

        double[] d=data.get(0);
        double[][] evalPoints = new double[1][d.length];
        for( int i=0; i<d.length; i++ ){
            evalPoints[0][i] = d[i];
        }

        INDArray allXYPoints = Nd4j.create(evalPoints);
        //System.out.println(allXYPoints.getFeatureMatrix());
        //INDArray lables = t.getLabels();
        //INDArray predicted = model.output(features,false););
        //if(allXYPoints==null){

        //}
        INDArray predictionsAtXYPoints = model.output(allXYPoints);
        int[] predictions=model.predict(allXYPoints);
        //int[] predict = model.predict(convert);

        res=predictions[0];

        //System.out.println(predictionsAtXYPoints);

        //res=predictionsAtXYPoints.getDouble(0,0);

        //System.out.println(res);

//get the value from INDArray

        return res;
    }

    private void load_for_prediction(String teste_results, String separator) {
        String cvsSplitBy = separator;
        data=new ArrayList<>();
        //System.out.println(line);
        // use ; as separator
        String[] values = teste_results.split(cvsSplitBy);

        double[] doubleValues = Arrays.stream(values)
                .mapToDouble(Double::parseDouble)
                .toArray();

        data.add(doubleValues);
    }
}
