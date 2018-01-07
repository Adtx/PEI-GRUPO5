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
        frame.pack();*/

        /*frame.setVisible(true);
        /*String texto = "Exeter has a comprehensive selection of sports and leisure facilities . These include sports centres , running tracks , indoor bowling greens , a golf course and a driving range as well as swimming pools , sports pitches and an artificial turf pitch . Tennis courts are available in many of the public  parks , and are free to use . \n" +
                "The main swimming pool in Exeter has recently been renovated and is now very attractive . A fitness centre and sauna are also available . There is an open-air swimming pool for use in the summer months . \n" +
                "The local countryside provides the perfect opportunity for horse-riding , which needs to be booked in advance . There are many lovely walks on the nearby hills .\n" +
                "Cycling in Exeter is popular both as a recreational activity and as a convenient way of getting to work or the shops .\n";
        */
        //String texto2="to be";

        //Language_moddeling l= new Language_moddeling(texto);

        //l.bigram_model_value();

        //sentence_spliter(texto);
        /*System.out.println("comecei");
        Auto_tester t=new Auto_tester();
        t.text_all_texts();*/
        //Mistakes_Stats ms=new Mistakes_Stats();
        //ms.give_mistakes("");

        SVM_Classifier svm= new SVM_Classifier();
        svm.train_classifier();

    }

}
