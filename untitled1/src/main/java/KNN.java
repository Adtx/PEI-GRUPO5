import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.*;

public class KNN {

    List<double[]> data;
    String[] attributes_names;
    FastVector fvWekaAttributes;
    Classifier knn;
    Instance one_test;
    Instances isTrainingSet;

    public KNN() {

    }



    public KNN(String knn_arf){
        BufferedReader datafile = readDataFile(knn_arf);

        try {
            isTrainingSet= new Instances(datafile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        isTrainingSet.setClassIndex(isTrainingSet.numAttributes() - 1);

        //do not use first and second
        //Instance first = data.instance(0);
        //Instance second = data.instance(1);
        //data.delete(0);
        //data.delete(1);

        Classifier ibk = new IBk();
        try {
            ibk.buildClassifier(isTrainingSet);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //double class1 = ibk.classifyInstance(first);
        //double class2 = ibk.classifyInstance(second);

        //System.out.println("first: " + class1 + "\nsecond: " + class2);
    }


    public static BufferedReader readDataFile(String filename) {
        BufferedReader inputReader = null;

        try {
            inputReader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + filename);
        }

        return inputReader;
    }



    private void load_data(String data_file, String separator) {
        //Instances data=new Instances();

        String csvFile = data_file;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = separator;
        data = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            line=br.readLine(); // this will read the first line
            //System.out.println(line);
            //this part is specific for the KNN because we don't print our files like weka
            String[] attributes= line.split(cvsSplitBy);
            attributes_names=attributes;
            //System.out.println(attributes.length);



            line = null;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                //System.out.println(line);
                // use ; as separator
                String[] values = line.split(cvsSplitBy);

                double[] doubleValues = Arrays.stream(values)
                        .mapToDouble(Double::parseDouble)
                        .toArray();

                data.add(doubleValues);
                //System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void train_model(){
        load_data("test_results.csv",";");
        //System.out.println("Attr names: "+attributes_names.length);
        fvWekaAttributes= new FastVector(attributes_names.length);
        for(String s:attributes_names) {
            Attribute Attribute1 = new Attribute(s);
            fvWekaAttributes.addElement(Attribute1);
        }

        // Create an empty training set
        isTrainingSet = new Instances("Rel", fvWekaAttributes,data.size());
        // Set class index
        isTrainingSet.setClassIndex(attributes_names.length-1);


        for(double[] d:data){
            Instance iExample = new DenseInstance(attributes_names.length);
            for(int i=0;i<d.length;i++){
                iExample.setValue((Attribute)fvWekaAttributes.elementAt(i), d[i]);
            }
            // add the instance
            isTrainingSet.add(iExample);
        }

        knn = new IBk();
        try {
            knn.buildClassifier(isTrainingSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
        BufferedWriter writer = new BufferedWriter(
                new FileWriter("knn_arf"));
        writer.write(isTrainingSet.toString());
        writer.newLine();
        writer.flush();
        writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public double predict(String teste_results,String separator){

        load_for_prediction(teste_results,separator);

        double result=predict();

        return result;

    }

    private double predict(){
        double result=100;
        //Instance iExample.setDataset(isTrainingSet);
        Instance iExample = new DenseInstance(attributes_names.length);
        iExample.setDataset(isTrainingSet);
        System.out.println(attributes_names.length);
        System.out.println(fvWekaAttributes.size());
        for(double[] d:data){
            System.out.println(d.length);
            for(int i=0;i<d.length;i++) {
                iExample.setValue((Attribute) fvWekaAttributes.elementAt(i), d[i]);
            }
        }

        try {
            result= knn.classifyInstance(iExample);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private double predict2(){

        // Declare the feature vector
        fvWekaAttributes = new FastVector(isTrainingSet.numAttributes());
        //isTrainingSet.setClassIndex(isTrainingSet.numAttributes()-1);

        //Declaring attributes
        for(int i=0;i<isTrainingSet.numAttributes();i++){
            String name=isTrainingSet.attribute(i).name();
            Attribute a = new Attribute(name);
            fvWekaAttributes.addElement(a);
        }

        // Declare Instances which is required since I want to use classification/Prediction
        Instances dataset = new Instances("whatever", fvWekaAttributes, 0);
        //Create the new instance i1
        Instance i1 = new DenseInstance(isTrainingSet.numAttributes());
        for(double[] d:data){
            System.out.println(d.length);
            for(int i=0;i<d.length;i++) {
                i1.setValue((Attribute) fvWekaAttributes.elementAt(i), d[i]);
            }
        }
        //Add the instance to the dataset (Instances) (first element 0)
        dataset.add(i1);
        //Define class attribute position
        dataset.setClassIndex(dataset.numAttributes()-1);

        //Will print 0 if it's a "yes", and 1 if it's a "no"
        try {
            System.out.println(knn.classifyInstance(dataset.instance(0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Here I call dataset.instance(0) since there is only one instance added in the dat

        return 0;
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

    public void test_model(){
        // Test the model need to be implemented when i have a testing set
        // tutorial here https://weka.wikispaces.com/Programmatic+Use
        /*
        Evaluation eTest = new Evaluation(isTrainingSet);
        eTest.evaluateModel(cModel, isTestingSet);

        // Print the result à la Weka explorer:
        String strSummary = eTest.toSummaryString();
        System.out.println(strSummary);

        // Get the confusion matrix
        double[][] cmMatrix = eTest.confusionMatrix();*/
    }
}

