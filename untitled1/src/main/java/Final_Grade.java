import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class Final_Grade {

    private Test tester;
    private SVM_Classifier svm_classifier;
    private KNN knn_classifier;
    private NeuralNet nn_classifier;

    public Final_Grade(){
        svm_classifier = new SVM_Classifier("svm_classifier");
        //svm_classifier.train_classifier();
        //knn_classifier=new KNN("knn_arf");
        knn_classifier = new KNN();
        knn_classifier.train_model();
        nn_classifier = new NeuralNet("MyMultiLayerNetwork.zip");
    }

    public void test(){
        String csvFile = "test_results_denorm.csv";
        String csvfile_nn="test_results_neural_net_denorm.csv";
        BufferedReader br = null;
        BufferedReader br_nn=null;
        String line = "";
        String cvsSplitBy = ";";
        double total=0;
        double right=0;
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
        System.out.println("\n\n\n");
        int counter=0;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            while ((line = br.readLine()) != null) {


                // use comma as separator
                int test_grade=Integer.parseInt(line.substring(line.length() - 1));
                //System.out.println("TG "+test_grade);
                String test_info=line.substring(0,line.length()-2);
                double svm_grade=svm_classifier.predict(test_info,";");
                if(counter==0) {
                    System.out.println(test_info);
                    System.out.println("SVM " + svm_grade);
                    counter=counter+1;
                }
                double knn_grade=knn_classifier.predict(test_info,";");
                //ystem.out.println("KNN "+knn_grade);
                double nn_grade=nn_classifier.predict(test_info,";")+1;
                //System.out.println("NN "+ nn_grade);
                double level=Math.round((svm_grade+knn_grade+nn_grade)/3);
                total=total+1;

                //System.out.println("Final Grade: "+level+"   True Grade: "+test_grade);
                if(level==test_grade){
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
                if(level==1){
                    total_one=total_one+1;
                }
                if(level==2){
                    total_two=total_two+1;
                }
                if(level==3){
                    total_three=total_three+1;
                }
                if(level==4){
                    total_four=total_four+1;
                }
                if(level==5){
                    total_five=total_five+1;
                }
                if(level==6){
                    total_six=total_six+1;
                }

            }

            System.out.println();
            System.out.println("Final Grade Acuracy: "+(right/total)*100+" %");
            /*
            System.out.println("Final Grade A1 accuracy: "+ (correct_one/total_one)*100+" %");
            System.out.println("Final Grade A2 accuracy: "+ (correct_two/total_two)*100+" %");
            System.out.println("Final Grade B1 accuracy: "+ (correct_three/total_three)*100+" %");
            System.out.println("Final Grade B2 accuracy: "+ (correct_four/total_four)*100+" %");
            System.out.println("Final Grade C1 accuracy: "+ (correct_five/total_five)*100+" %");
            System.out.println("Final Grade C2 accuracy: "+ (correct_six/total_six)*100+" %");
            */


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

