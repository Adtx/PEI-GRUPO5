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
    Instances isTestingSet;

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

            //this part is specific for the KNN because we don't print our files like weka
            String[] attributes= line.split(cvsSplitBy);
            attributes_names=attributes;




            line = null;
            while ((line = br.readLine()) != null) {

                // use ; as separator
                String[] values = line.split(cvsSplitBy);

                double[] doubleValues = Arrays.stream(values)
                        .mapToDouble(Double::parseDouble)
                        .toArray();

                data.add(doubleValues);



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

    private void load_test_data(String data_file, String separator) {
        //Instances data=new Instances();

        String csvFile = data_file;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = separator;
        data = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            line=br.readLine(); // this will read the first line

            //this part is specific for the KNN because we don't print our files like weka
            String[] attributes= line.split(cvsSplitBy);
            attributes_names=attributes;
            //System.out.println(attributes.length);



            line = null;
            while ((line = br.readLine()) != null) {

                // use ; as separator
                String[] values = line.split(cvsSplitBy);

                double[] doubleValues = Arrays.stream(values)
                        .mapToDouble(Double::parseDouble)
                        .toArray();

                data.add(doubleValues);



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
        //load and prepare trainin
        load_data("train_results.csv",";");


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


        //load and prepare test dataset
        load_data("test_results.csv",";");


        /*fvWekaAttributes= new FastVector(attributes_names.length);
        for(String s:attributes_names) {
            Attribute Attribute1 = new Attribute(s);
            fvWekaAttributes.addElement(Attribute1);
        }*/

        // Create an empty test set
        isTestingSet = new Instances("Rel", fvWekaAttributes,data.size());
        // Set class index
        isTestingSet.setClassIndex(attributes_names.length-1);


        for(double[] d:data){
            Instance iExample = new DenseInstance(attributes_names.length);
            for(int i=0;i<d.length;i++){
                iExample.setValue((Attribute)fvWekaAttributes.elementAt(i), d[i]);
            }
            // add the instance
            isTestingSet.add(iExample);
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

        for(double[] d:data){

            for(int i=0;i<d.length;i++) {
                iExample.setValue((Attribute) fvWekaAttributes.elementAt(i), d[i]);
            }
        }

        try {
            result= knn.classifyInstance(iExample);
            //knn.classifyInstance(iExample).
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

        Normalize n= new Normalize();
        // use ; as separator
        String[] values = teste_results.split(cvsSplitBy);

        double[] doubleValues = Arrays.stream(values)
                .mapToDouble(Double::parseDouble)
                .toArray();

        double[] normalized_values=n.normalize(doubleValues);

        data.add(normalized_values);
        //data.add(doubleValues);
    }

    public void test_model(){
        //currently it is testing with training data, when we have more data adapt in order to train with other type of data
        //load_data("test_results.csv",";");
        //String csvFile = data_file;
        BufferedReader br = null;
        String line = "";
        //String cvsSplitBy = separator;
        double acuracy=0;
        double right=0;
        double total=0;
        double correct_one=0;
        double correct_two=0;
        double correct_three=0;
        double correct_four=0;
        double correct_five=0;
        double correct_six=0;
        double total_one=0;
        double total_two=0;
        double total_three=0;
        double total_four=0;
        double total_five=0;
        double total_six=0;

        try {
            br = new BufferedReader(new FileReader("test_results.csv"));
            line=br.readLine(); // this will read the first line

            line = null;
            while ((line = br.readLine()) != null) {
                data = new ArrayList<>();
                // use ; as separator
                String[] values = line.split(";");

                double[] doubleValues = Arrays.stream(values)
                        .mapToDouble(Double::parseDouble)
                        .toArray();

                int level= (int) doubleValues[doubleValues.length-1];

                doubleValues=Arrays.copyOf(doubleValues, doubleValues.length-1);

                data.add(doubleValues);

                double prediction= predict();

                System.out.println("KNN Prediction: "+prediction+"   Actual level;  "+level );
                total=total+1;
                if(prediction==level){
                    right=right+1;
                    if(level==1){
                        correct_one=correct_one+1;
                    }
                    if(level==2){
                        correct_two=correct_two+1;
                    }
                    if(level==3){
                        correct_three=correct_three+1;
                    }
                    if(level==4){
                        correct_four=correct_four+1;
                    }
                    if(level==5){
                        correct_five=correct_five+1;
                    }
                    if(level==6){
                        correct_six=correct_six+1;
                    }
                }
                if(prediction==1){
                    total_one=total_one+1;
                }
                if(prediction==2){
                    total_two=total_two+1;
                }
                if(prediction==3){
                    total_three=total_three+1;
                }
                if(prediction==4){
                    total_four=total_four+1;
                }
                if(prediction==5){
                    total_five=total_five+1;
                }
                if(prediction==6){
                    total_six=total_six+1;
                }

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

        System.out.println("\n\n KNN Acuracy: "+(right/total)*100+" %");
        System.out.println("KNN A1 accuracy: "+ (correct_one/total_one)*100+" %");
        System.out.println("KNN A2 accuracy: "+ (correct_two/total_two)*100+" %");
        System.out.println("KNN B1 accuracy: "+ (correct_three/total_three)*100+" %");
        System.out.println("KNN B2 accuracy: "+ (correct_four/total_four)*100+" %");
        System.out.println("KNN C1 accuracy: "+ (correct_five/total_five)*100+" %");
        System.out.println("KNN C2 accuracy: "+ (correct_six/total_six)*100+" %");
    }

    /*public void test_model(){
        // Test the model need to be implemented when i have a testing set
        // tutorial here https://weka.wikispaces.com/Programmatic+Use
        /*Evaluation eTest = null;
        try {
            eTest = new Evaluation(isTrainingSet);
            eTest.evaluateModel(knn, isTestingSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Print the result à la Weka explorer:
        String strSummary = eTest.toSummaryString();
        System.out.println(strSummary);
        // Get the confusion matrix
        double[][] cmMatrix = eTest.confusionMatrix();
    }*/
}
