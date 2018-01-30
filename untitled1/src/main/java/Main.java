import javax.swing.*;
//import de.spieleck.app.cngram.
import org.languagetool.language.SouthAfricanEnglish;
import sleep.error.SyntaxError;
import sleep.runtime.Scalar;
import sleep.runtime.ScriptLoader;
import sleep.runtime.ScriptInstance;
import sleep.error.YourCodeSucksException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.BreakIterator;
import java.util.Locale;

import org.dashnine.preditor.LanguageModel;
import org.dashnine.sleep.SleepScriptEngine;
import sleep.runtime.ScriptVariables;

/**
 * Created by andrepinto on 29/11/17.
 */
public class Main {


    public static void main(String[] args) throws IOException {
        /*JFrame frame = new JFrame("Corrector");
        frame.setContentPane(new Corrector().Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);*/
        CSV_Tester csv=new CSV_Tester();
        csv.test_csv_file("csv_test_doc.csv","csv_result_document.csv");
        //update_train_dataset();
        //update_test_dataset();
        //train_all_classifiers();
        /*Normalize n= new Normalize();

        double[] test= {1,2,3,4,5};
        double[] means={3,3,3,3,3};
        double deviation=n.deviation(test,3);
        System.out.println(deviation);
        double[] deviations={deviation,deviation,deviation,deviation,deviation};


        n.normalize(test,means,deviations);*/
        //update_normalized_datasets();
        /*Auto_tester t=new Auto_tester();
        t.how_many_texts_per_level();*/


    }

    private static void update_train_dataset(){
        System.out.println("A imprimir dataset de treino");
        Auto_tester t=new Auto_tester();
        try {
            t.train_texts();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void update_test_dataset(){
        System.out.println("A imprimir dataset de teste");
        Auto_tester t=new Auto_tester();
        try {
            t.test_texts();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void update_normalized_datasets(){
        System.out.println("A imprimir datasets normalizados");
        Auto_tester t=new Auto_tester();
        try {
            t.create_normalized_datasets();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void train_all_classifiers(){
        System.out.println("A treinar os classificadores");
        SVM_Classifier svm= new SVM_Classifier();
        svm.train_classifier();
        NeuralNet nn=new NeuralNet();
        nn.train_neural_net();
        KNN knn_classifier=new KNN();
        knn_classifier.train_model();
        knn_classifier.test_model();

    }



}
