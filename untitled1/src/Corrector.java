import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.language.BritishEnglish;
import org.languagetool.language.English;
import org.languagetool.language.PortugalPortuguese;
import org.languagetool.rules.Rule;
import org.languagetool.rules.RuleMatch;



/**
 * Created by andrepinto on 29/11/17.
 */
public class Corrector {
    private JTextArea textArea1;
    private JButton button1;
    public JPanel Panel1;
    private JLabel Label1;
    private JTextPane textPane1;
    private JComboBox comboBox1;
    private Test tester;
    private SVM_Classifier classifier;

    public Corrector() {
        button1.addActionListener(new OperationBtnClicked());
        tester=new Test();
        classifier=new SVM_Classifier();
    }
    private static final String PARAGRAPH_SPLIT_REGEX = "\\n";




    protected static int countSyllables(String word){
        // TODO: Implement this method so that you can call it from the
        // getNumSyllables method in BasicDocument (module 1) and
        // EfficientDocument (module 2).
        int count = 0;
        word = word.toLowerCase();

        if (word.charAt(word.length()-1) == 'e') {
            if (silente(word)){
                String newword = word.substring(0, word.length()-1);
                count = count + countit(newword);
            } else {
                count++;
            }
        } else {
            count = count + countit(word);
        }
        return count;
    }

    private static int countit(String word) {
        int count = 0;
        Pattern splitter = Pattern.compile("[^aeiouy]*[aeiouy]+");
        Matcher m = splitter.matcher(word);

        while (m.find()) {
            count++;
        }
        return count;
    }

    private static boolean silente(String word) {
        word = word.substring(0, word.length()-1);

        Pattern yup = Pattern.compile("[aeiouy]");
        Matcher m = yup.matcher(word);

        if (m.find()) {
            return true;
        } else
            return false;
    }



    private class OperationBtnClicked implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e){
            String s = textArea1.getText();
            try {
                tester.run_test(s);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            String test_result=tester.print_test();
            System.out.println(test_result);
            double test_grade=classifier.predict(test_result,";");
            if(test_grade==1){
                System.out.println("CEFR level: A1");
            }
            if(test_grade==2){
                System.out.println("CEFR level: A2");
            }
            if(test_grade==3){
                System.out.println("CEFR level: B1");
            }
            if(test_grade==4){
                System.out.println("CEFR level: B2");
            }
            if(test_grade==5){
                System.out.println("CEFR level: C1");
            }
            if(test_grade==6){
                System.out.println("CEFR level: C2");
            }
            System.out.println("Number of words: "+tester.get_total_words());
            System.out.println("Number of sentences: "+ tester.get_total_sentences());
            System.out.println("Number of syllables: "+tester.get_total_syllables());
            System.out.println("Number of complex words: "+tester.get_complex_words());
            System.out.println("Number of letters: "+ tester.get_letter_count());
            System.out.println("Number of common words: "+ tester.get_common_words());
            System.out.println("Number of different words: "+tester.get_total_different_words());
            System.out.println("Number of different advanced words:"+ tester.get_different_advanced_words());
            System.out.println("Number of paragraphs:"+ tester.get_total_paragraphs());
            System.out.println("Average words per sentence:"+ tester.get_words_per_sentence());
            System.out.println("Average sentences per paragraph:"+tester.get_sentences_per_paragraph());
            System.out.println("Flesch Reading Ease Level: "+tester.get_flesh_reading_ease());
            System.out.println("Flesch-Kinkaid Grade Level: "+tester.get_flesch_kinkaid());
            System.out.println("Gunning Fog Index: "+tester.get_gunning_fog());
            System.out.println("Coleman-Liau Index: "+tester.get_coleman_liau());
            System.out.println("SMOG Grade: "+tester.get_smog_grade());
            System.out.println("Automated Readibility Index: "+ tester.get_automated_readibility_index());
            System.out.println("Lexical Density: "+tester.get_lexical_density());
            System.out.println("Beyond 2000: "+ tester.get_beyond_2000());
            System.out.println("Advanced TTR: "+ tester.get_advanced_ttr());
            System.out.println("Advanced Guiraud: "+ tester.get_advanced_guiraud());
            System.out.println("TTR: "+tester.get_ttr());
            System.out.println("RTTR: "+ tester.get_rttr());
            System.out.println("CTTR: "+tester.get_cttr());
            System.out.println("M: "+tester.get_m());
            System.out.println("H: "+tester.get_h());
            System.out.println("S: "+tester.get_s());
            System.out.println("U: "+tester.get_u());
            System.out.println("Mean Word Frequency: "+tester.get_mwf());
            System.out.println("R: "+tester.get_r());
            System.out.println("Bigram Entropy: "+tester.get_bigram_model());
            System.out.println("Bigram Perplexety: "+tester.get_bigram_perplexity());
            System.out.println("Bigram Entropy in reverse: "+tester.get_bigram_model_reverse());
            System.out.println("Bigram Perplexety in reverse: "+tester.get_bigram_perplexity_reverse());
            System.out.println("A1: "+tester.get_a1_words()*tester.get_total_words());
            System.out.println("A2: "+tester.get_a2_words()*tester.get_total_words());
            System.out.println("B1: "+tester.get_b1_words()*tester.get_total_words());
            System.out.println("B2: "+tester.get_b2_words()*tester.get_total_words());
            System.out.println("C1: "+tester.get_c1_words()*tester.get_total_words());
            System.out.println("C2: "+tester.get_c2_words()*tester.get_total_words());
            System.out.println("Number of simple errors: "+tester.get_simple_errors());
            System.out.println("Number of complex errors: "+tester.get_complex_errors());
            System.out.println("Simple errors per word: "+tester.get_simple_errors_per_word());
            System.out.println("Comple errors per word: "+tester.get_complex_errors_per_word());


        }
        /*public void actionPerformed(ActionEvent e) {
            try {
                String s = textArea1.getText();
                String teste = "";
                JLanguageTool langTool;
                if (comboBox1.getSelectedItem().equals("Português")) {
                    langTool = new JLanguageTool(new PortugalPortuguese());
                }
                else{
                    langTool= new JLanguageTool(new BritishEnglish());
                }
                int err_dif=0;
                int err_fac=0;
                int paragrafo_nr = 1;
                List<RuleMatch> matches = langTool.check(s);
                String str = s;
                String[] parag = str.split(PARAGRAPH_SPLIT_REGEX);
                System.out.println(str);
                for (String s1 : parag){
                    ArrayList<String> frases = new ArrayList<String>();
                    for ( String a : langTool.sentenceTokenize(s1)){
                        frases.add(a);
                    }
                    teste = teste + "O paragrafo "+paragrafo_nr+ " tem "+ frases.size() + " frases, cada uma com ";
                    for(String a : frases){
                        if(a.equals(frases.get(frases.size()-1))){
                            teste = teste + a.split(" ").length;
                        }
                        else{
                            teste = teste + a.split(" ").length +", ";
                        }
                    }
                    teste = teste + " palavras.\n";
                    paragrafo_nr++;
                }
                teste= teste + "\n\n\n";
                ArrayList<String> parags  = new ArrayList<String>();
                for(String b : parag)
                    parags.add(b);
                for (RuleMatch match : matches) {
                    int lin = match.getLine();
                    int col = match.getColumn();
                    String[] words = parag[lin].split(" ");
                    int curpos = 1;
                    String error = "";
                    for (String a : words) {
                        if (col == curpos) {
                            error = a;
                            break;
                        } else {
                            curpos += a.length() + 1;
                        }
                    }
                    System.out.println("Potential typo at line " +
                            match.getLine() + ", column " +
                            match.getColumn() + ": " + match.getMessage() +
                            " at word " + error);
                    if (countSyllables(error) >= 3) {
                        System.out.println("Erro dificil!");
                        err_dif++;
                    } else {
                        System.out.println("Erro facil!");
                        err_fac++;
                    }
                    System.out.println("Suggested correction(s): " +
                            match.getSuggestedReplacements());
                    for (String s2 : match.getSuggestedReplacements()) {
                        teste = teste + match.getShortMessage() + "\n";
                    }
                }
                } catch (Exception ex) {
                ex.printStackTrace();
            }
        }*/
    }
}
