import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public Corrector() {
        button1.addActionListener(new OperationBtnClicked());


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