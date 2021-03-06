package Util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.*;

public class KNN {

    int j=0;
    List<List<Double>> data;
    String[] attributes_names;
    FastVector fvWekaAttributes;
    Classifier knn;
    Instance one_test;
    Instances isTrainingSet;
    Instances isTestingSet;

    public KNN() {

    }



    public KNN(String knn_arf){
        BufferedReader datafile = null;
            datafile = readDataFile(knn_arf);


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
        data = new ArrayList<List<Double>>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            line=br.readLine(); // this will read the first line

            //this part is specific for the KNN because we don't print our files like weka
            String[] attributes= line.split(cvsSplitBy);
            attributes_names=attributes;
            Normalize n = new Normalize();




            line = null;
            while ((line = br.readLine()) != null) {

                // use ; as separator
                String[] values = line.split(cvsSplitBy);

                ArrayList<Double> temp = new ArrayList<Double>();
                for (String s : values){
                    temp.add( Double.parseDouble(s));
                }
                data.add(temp);
              /*  double[] doubleValues= new double[10000000];
                int i=0;
                for (String s : values){
                    double temp = Double.parseDouble(s);
                    doubleValues[i] = temp;
                    i++;
                }


*/


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
        data = new ArrayList<List<Double>>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            line=br.readLine(); // this will read the first line
            //System.outprintln(line);
            //this part is specific for the KNN because we don't print our files like weka
            String[] attributes= line.split(cvsSplitBy);
            attributes_names=attributes;
            Normalize n = new Normalize();
            ////System.outprintln(attributes.length);



            line = null;
            while ((line = br.readLine()) != null) {
                //System.outprintln(line);

                // use ; as separator
                String[] values = line.split(cvsSplitBy);


                ArrayList<Double> temp = new ArrayList<Double>();
                for(String s : values)
                    temp.add(Double.parseDouble(s));
                data.add(temp);
                /*double[] doubleValues ={1.2,2.0};
                int i=0;
                for (String s : values){
                    double temp = Double.parseDouble(s);
                    doubleValues[i] = temp;
                    i++;
                }

                data.add(doubleValues);
*/


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
        //load and prepare training
        load_data("C:\\Users\\Pedro\\Desktop\\final_proj\\dl4j-examples-master\\Anansi\\train_results.csv",";");


        fvWekaAttributes= new FastVector(attributes_names.length);
        for(String s:attributes_names) {
            Attribute Attribute1 = new Attribute(s);
            fvWekaAttributes.addElement(Attribute1);
        }

        // Create an empty training set
        isTrainingSet = new Instances("Rel", fvWekaAttributes,data.size());
        // Set class index
        isTrainingSet.setClassIndex(attributes_names.length-1);


        int i =0;
        for(List<Double> d:data){
            i=0;
            Instance iExample = new DenseInstance(attributes_names.length);
            for (Double e : d) {
                iExample.setValue((Attribute) fvWekaAttributes.elementAt(i), e);
                i++;
            }
            isTrainingSet.add(iExample);
            // add the instance

        }


        //load and prepare test dataset
        load_data("C:\\Users\\Pedro\\Desktop\\final_proj\\dl4j-examples-master\\Anansi\\test_results.csv",";");


        /*fvWekaAttributes= new FastVector(attributes_names.length);
        for(String s:attributes_names) {
            Attribute Attribute1 = new Attribute(s);
            fvWekaAttributes.addElement(Attribute1);
        }*/

        // Create an empty test set
        isTestingSet = new Instances("Rel", fvWekaAttributes,data.size());
        // Set class index
        isTestingSet.setClassIndex(attributes_names.length-1);


        for(List<Double> d:data){
            Instance iExample = new DenseInstance(attributes_names.length);
            i=0;
            for(Double e : d) {
                iExample.setValue((Attribute) fvWekaAttributes.elementAt(i), e);
                i++;
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
                new FileWriter("C:\\Users\\Pedro\\Desktop\\final_proj\\dl4j-examples-master\\Anansi\\knn_arf"));
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
    int i =0;
        for(List<Double> d:data){
            i=0;
            for(Double e :d) {
                iExample.setValue((Attribute) fvWekaAttributes.elementAt(i), e);
                i++;
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

        int i =0;
        for(List<Double> d:data) {

            Instance i1 = new DenseInstance(isTrainingSet.numAttributes());
            i = 0;
            for (Double e : d){
                i1.setValue((Attribute) fvWekaAttributes.elementAt(i), e);
                i++;
            }
            //Add the instance to the dataset (Instances) (first element 0)
            dataset.add(i1);

        }

        //Define class attribute position
        dataset.setClassIndex(dataset.numAttributes()-1);

        //Will print 0 if it's a "yes", and 1 if it's a "no"
        try {
            //System.outprintln(knn.classifyInstance(dataset.instance(0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Here I call dataset.instance(0) since there is only one instance added in the dat

        return 0;
    }

    private void load_for_prediction(String teste_results, String separator) {
        String cvsSplitBy = separator;
        data=new ArrayList<List<Double>>();

        // use ; as separator
        String[] values = teste_results.split(cvsSplitBy);
        Normalize n = new Normalize();

        ArrayList<Double> temp =  new ArrayList<Double>();
        for (String s : values)
            temp.add(Double.parseDouble(s));

        data.add(n.normalize(temp));
        /*double[] doubleValues= new double[1000000000];
        int i=0;
        for (String s : values){
            double temp = Double.parseDouble(s);
            doubleValues[i] = temp;
            i++;
        }

        data.add(doubleValues);*/
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
        //System.outprintln(strSummary);

        // Get the confusion matrix
        double[][] cmMatrix = eTest.confusionMatrix();
    }*/
}

