package Util;


import sleep.error.YourCodeSucksException;
import sleep.runtime.*;

import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.lang.Math.log;

public class Language_moddeling {


    private List<String> sentences;

    //from here https://blog.afterthedeadline.com/2010/03/04/all-about-language-models/
    // "tutorial" here http://sleep.dashnine.org/manual/index.html
    private Scalar bigram_model;

     public Language_moddeling (){
         //String delimiters = "?!.";
         //sentences = text.split("\\?|!|.");
         load_bigram_model();
         //exp();
     }

    private void load_bigram_model() {
        ScriptLoader loader=new ScriptLoader();
        ScriptInstance script=null;

        try {
            script = loader.loadScript("C:\\Users\\Pedro\\Desktop\\final_proj\\dl4j-examples-master\\Anansi\\load_bigram_model.ls");
        }catch (Exception syntaxErrors){
            syntaxErrors.printStackTrace();

        }
        script.runScript();
        ScriptVariables variables = script.getScriptVariables();
        bigram_model = variables.getScalar("$model");
    }


    public float bigram_model_value(String text) {
        sentences=new ArrayList<String>();
        sentence_spliter(text);
        ScriptLoader loader=new ScriptLoader();
        ScriptInstance script=null;
        float res=0;
        try {
            script = loader.loadScript("C:\\Users\\Pedro\\Desktop\\final_proj\\dl4j-examples-master\\Anansi\\bigram_model_script.ls");
        }catch (YourCodeSucksException syntaxErrors){
            System.out.println(syntaxErrors.formatErrors());

        }catch (IOException ioError){
            System.out.println("io exception");
        }
        ScriptVariables variables = script.getScriptVariables();
        for(String s:sentences) {
            s=remove_punctuation(s);
            String[] words = s.split("\\s");
            for (int i = 0; i < words.length - 1; i++) {
                String first = words[i];
                String second = words[i + 1];
                variables.putScalar("$model", SleepUtils.getScalar(bigram_model));
                variables.putScalar("$word1", SleepUtils.getScalar(first));
                variables.putScalar("$word2", SleepUtils.getScalar(second));
                script.runScript();
                Scalar value = variables.getScalar("$res");
                res += value.doubleValue();
            }

        }
    return res;
     }

    public float bigram_model_value_reverse(String text) {
        sentences=new ArrayList<String>();
        sentence_spliter(text);
        ScriptLoader loader=new ScriptLoader();
        ScriptInstance script=null;
        float res=0;
        try {
            script = loader.loadScript("C:\\Users\\Pedro\\Desktop\\final_proj\\dl4j-examples-master\\Anansi\\bigram_model_script_reverse.ls");
        }catch (YourCodeSucksException syntaxErrors){
            System.out.println(syntaxErrors.formatErrors());

        }catch (IOException ioError){
            System.out.println("io exception");
        }
        ScriptVariables variables = script.getScriptVariables();
        for(String s:sentences) {
            s=remove_punctuation(s);
            String[] words = s.split("\\s");
            for (int i = 0; i < words.length - 1; i++) {
                String first = words[i];
                String second = words[i + 1];
                variables.putScalar("$model", SleepUtils.getScalar(bigram_model));
                variables.putScalar("$word1", SleepUtils.getScalar(first));
                variables.putScalar("$word2", SleepUtils.getScalar(second));
                script.runScript();
                Scalar value = variables.getScalar("$res");
                    res += value.doubleValue();

            }
        }
        return res;
    }

    public float exp() {
      /*  sentences=new ArrayList<>();
        sentence_spliter();*/
        load_bigram_model();
        ScriptLoader loader = new ScriptLoader();
        ScriptInstance script = null;
        String s = "Yesterday Tom had his breakfast. He then went for a walk with his dog and some friends. After the walk they had a picnic. Everybody had a good day. In the evening Tom was tired and went to bed.\n";

        float res = 0;
        try {
            script = loader.loadScript("exp.ls");
            //script.runScript();
        } catch (YourCodeSucksException syntaxErrors) {
            System.out.println(syntaxErrors.formatErrors());

        } catch (IOException ioError) {
            System.out.println("io exception");
        }
        ScriptVariables variables = script.getScriptVariables();
        //for(String s:sentences) {
        s = remove_punctuation(s);
        String[] words = s.split("\\s");
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            variables.putScalar("$model", SleepUtils.getScalar(bigram_model));
            variables.putScalar("$word1", SleepUtils.getScalar(first));
            variables.putScalar("$word2", SleepUtils.getScalar(second));
            script.runScript();
            Scalar value = variables.getScalar("$res");
            Scalar value2 = variables.getScalar("$res2");
            res += value.doubleValue();
            }
            //}
            return res;
        }


    private void sentence_spliter(String source) {
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        //String source = "This is a test. This is a T.L.A. test. Now with a Dr. in it.";
        iterator.setText(source);
        int start = iterator.first();
        for (int end = iterator.next();
             end != BreakIterator.DONE;
             start = end, end = iterator.next()) {
            sentences.add(source.substring(start, end));
        }
    }

    private String remove_punctuation(String documentText) {
        String result = documentText.replaceAll("[^a-zA-Z ]", "");
        return result;
    }



}
