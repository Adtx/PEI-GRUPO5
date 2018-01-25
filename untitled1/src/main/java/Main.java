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
        //update_train_dataset();


        //train_all_classifiers();
        Auto_tester t=new Auto_tester();
        t.how_many_texts_per_level();


    }

    private static void update_train_dataset(){
        Auto_tester t=new Auto_tester();
        try {
            t.train_texts();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void update_test_dataset(){
        Auto_tester t=new Auto_tester();
        try {
            t.test_texts();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void train_all_classifiers(){
        //SVM_Classifier svm= new SVM_Classifier();
        //svm.train_classifier();
        NeuralNet nn=new NeuralNet();
        nn.train_neural_net();
        //KNN knn_classifier=new KNN();
        //knn_classifier.test_model();

    }



}
