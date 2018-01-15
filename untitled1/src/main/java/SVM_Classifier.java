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
        load_data("test_results.csv",";");

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
        //System.out.println("Y = "+level+ "\t\t\t The predicton = " + d);
        return  d;
    }

    private void load_for_prediction(String teste_results,String separator){
        //String line = "";
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



    private void test_model(){
        //currently it is testing with training data, when we have more data adapt in order to train with other type of data
        int total_features=data.get(0).length-1;
        for(int i = 0; i <= prob.l; i++){
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
        }
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

        try {
            br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // this will read the first line
            line=null;
            while ((line = br.readLine()) != null) {
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

    public void test(){
        svm_parameter param = new svm_parameter();

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

        svm_problem prob = new svm_problem();
        prob.l = 4;
        prob.y = new double[prob.l];
        prob.x = new svm_node[prob.l][2];
        for(int i = 0; i < prob.l; i++)
        {
            prob.x[i][0] = new svm_node();
            prob.x[i][1] = new svm_node();
            prob.x[i][0].index = 1;
            prob.x[i][1].index = 2;
            prob.x[i][0].value = (i%2!=0)?-1:1;
            prob.x[i][1].value = (i/2%2==0)?-1:1;
            prob.y[i] = (prob.x[i][0].value == 1 && prob.x[i][1].value == 1)?1:-1;
            System.out.println("X = [ " + prob.x[i][0].value + ", " + prob.x[i][1].value + " ] \t ->  " + prob.y[i] );
        }
        svm_model model = svm.svm_train(prob, param);

        int test_length = 4;
        for( int i = 0; i < test_length; i++)
        {
            svm_node[] x_test = new svm_node[2];
            x_test[0] = new svm_node();
            x_test[1] = new svm_node();
            x_test[0].index = 1;
            x_test[0].value = (i%2!=0)?-1:1;
            x_test[1].index = 2;
            x_test[1].value = (i/2%2==0)?-1:1;
            double d = svm.svm_predict(model, x_test);
            System.out.println("X[0] = " + x_test[0].value + "  X[1] = " + x_test[1].value + "\t\t\t Y = "
                    + ((x_test[0].value == 1 && x_test[1].value == 1)?1:-1) + "\t\t\t The predicton = " + d);
        }
    }

    public void tutorial_test(){
        svm_parameter param = new svm_parameter();

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

        svm_problem prob = new svm_problem();
        prob.l = 4;
        prob.y = new double[prob.l];
        prob.x = new svm_node[prob.l][2];
        for(int i = 0; i < prob.l; i++)
        {
            prob.x[i][0] = new svm_node();
            prob.x[i][1] = new svm_node();
            prob.x[i][0].index = 1;
            prob.x[i][1].index = 2;
            prob.x[i][0].value = (i%2!=0)?-1:1;
            prob.x[i][1].value = (i/2%2==0)?-1:1;
            prob.y[i] = (prob.x[i][0].value == 1 && prob.x[i][1].value == 1)?1:-1;
            System.out.println("X = [ " + prob.x[i][0].value + ", " + prob.x[i][1].value + " ] \t ->  " + prob.y[i] );
        }
        svm_model model = svm.svm_train(prob, param);

        int test_length = 4;
        for( int i = 0; i < test_length; i++)
        {
            svm_node[] x_test = new svm_node[2];
            x_test[0] = new svm_node();
            x_test[1] = new svm_node();
            x_test[0].index = 1;
            x_test[0].value = (i%2!=0)?-1:1;
            x_test[1].index = 2;
            x_test[1].value = (i/2%2==0)?-1:1;
            double d = svm.svm_predict(model, x_test);
            System.out.println("X[0] = " + x_test[0].value + "  X[1] = " + x_test[1].value + "\t\t\t Y = "
                    + ((x_test[0].value == 1 && x_test[1].value == 1)?1:-1) + "\t\t\t The predicton = " + d);
        }
    }

}
