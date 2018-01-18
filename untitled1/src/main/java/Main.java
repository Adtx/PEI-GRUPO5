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
        JFrame frame = new JFrame("Corrector");
        frame.setContentPane(new Corrector().Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //run_all_tests();

        //train_all_classifiers();



    }

    private static void run_all_tests(){
        Auto_tester t=new Auto_tester();
        try {
            t.text_all_texts();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void train_all_classifiers(){
        SVM_Classifier svm= new SVM_Classifier();
        svm.train_classifier();
        NeuralNet nn=new NeuralNet();
        nn.train_neural_net();
    }



}
