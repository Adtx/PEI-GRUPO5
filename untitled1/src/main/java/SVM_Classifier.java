import libsvm.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SVM_Classifier {

    svm_parameter param;
    List<double[]> data;
    svm_problem prob;
    svm_model model;

    public SVM_Classifier(){
        train_classifier();
        save_model("svm_classifier");
    }

    public SVM_Classifier(String model_name){
        try {
            model=svm.svm_load_model(model_name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save_model(String name){
        try {
            svm.svm_save_model(name, model);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //svm.svm_save_model();
    }

    public void train_classifier(){
        //start model with desired parameters
        setup_model();

        //load data
        load_data("train_results.csv",";");

        //prepare data
        prepare_data();

        //train the model
        model = svm.svm_train(prob, param);

        //test the model
        test_model();
    }

    public double predict(String teste_results,String separator){

        load_for_prediction(teste_results,separator);

        double result=predict();

        return result;

    }

    private double predict(){
        int total_features=data.get(0).length;
        svm_node[] x_test = new svm_node[total_features];
        double[] current_case=data.get(0);
        int f=1;
        for(f=0;f<total_features;f++){
            x_test[f]= new svm_node();
            x_test[f].index = f+1;
            x_test[f].value = current_case[f];
        }
        //int level= (int) current_case[f];
        double d = svm.svm_predict(model, x_test);

        return  d;
    }



    private void load_for_prediction(String teste_results,String separator){
        //String line = "";
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



    private void test_model(){
        //currently it is testing with training data, when we have more data adapt in order to train with other type of data
        load_data("test_results.csv",";");
        double accuracy=0;
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
        int total_features=data.get(0).length-1;
        for(int i = 0; i <= data.size()-1; i++){
            svm_node[] x_test = new svm_node[total_features];
            double[] current_case=data.get(i);
            int f=1;
            for(f=0;f<total_features;f++){
                x_test[f]= new svm_node();
                x_test[f].index = f+1;
                x_test[f].value = current_case[f];
            }
            int level= (int) current_case[f];
            double d = svm.svm_predict(model, x_test);
            System.out.println("Y = "+level+ "\t\t\t The predicton = " + d);
            total=total+1;
            if(level==d){
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
            if(d==1){
                total_one=total_one+1;
            }
            if(d==2){
                total_two=total_two+1;
            }
            if(d==3){
                total_three=total_three+1;
            }
            if(d==4){
                total_four=total_four+1;
            }
            if(d==5){
                total_five=total_five+1;
            }
            if(d==6){
                total_six=total_six+1;
            }
        }
        System.out.println("\n\n SVM Acuracy: "+(right/total)*100+" %");
        System.out.println("SVM A1 accuracy: "+ (correct_one/total_one)*100+" %");
        System.out.println("SVM A2 accuracy: "+ (correct_two/total_two)*100+" %");
        System.out.println("SVM B1 accuracy: "+ (correct_three/total_three)*100+" %");
        System.out.println("SVM B2 accuracy: "+ (correct_four/total_four)*100+" %");
        System.out.println("SVM C1 accuracy: "+ (correct_five/total_five)*100+" %");
        System.out.println("SVM C2 accuracy: "+ (correct_six/total_six)*100+" %");
    }

    private void prepare_data(){
        int total_features=data.get(0).length-1;
        prob = new svm_problem();
        prob.l = data.size()-1;
        prob.y = new double[prob.l];
        prob.x = new svm_node[prob.l][total_features];
        for(int i = 0; i < prob.l; i++){
            double[] current_case=data.get(i);
            int f=0;
            for(f=0;f<total_features;f++){
                prob.x[i][f] = new svm_node();
                prob.x[i][f].index = f+1;
                prob.x[i][f].value = current_case[f];
            }
            prob.y[i] = current_case[f];
        }
    }

    private void setup_model(){
        //choose model parameters
        param = new svm_parameter();

        // default values
        param.svm_type = svm_parameter.C_SVC;
        param.kernel_type = svm_parameter.RBF;
        param.degree = 3;
        param.gamma = 1;
        param.coef0 = 0;
        param.nu = 0.5;
        param.cache_size = 40;
        param.C = 1;
        param.eps = 1e-3;
        param.p = 0.1;
        param.shrinking = 1;
        param.probability = 0;
        param.nr_weight = 0;
        param.weight_label = new int[0];
        param.weight = new double[0];
    }

    private void load_data(String data_file,String separator) {

        String csvFile = data_file;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = separator;
        data=new ArrayList<>();
        int counter=0;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // this will read the first line
            line=null;
            while ((line = br.readLine()) != null) {
                if(counter==0){
                    System.out.println(line);
                    counter=counter+1;
                }
                //
                //System.out.println(line);
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

}
