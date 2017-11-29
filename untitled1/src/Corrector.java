import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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


    private class OperationBtnClicked implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {


            try {
                String s = textArea1.getText();
                String teste = "ERROS ====> ";
                JLanguageTool langTool;
                if (comboBox1.getSelectedItem().equals("Português")) {
                    System.out.println(comboBox1.getSelectedItem().toString());
                    langTool = new JLanguageTool(new PortugalPortuguese());
                    System.out.println("!!!!!");
                }
                else{
                    langTool= new JLanguageTool(new BritishEnglish());
                }
                //for (Rule rule : langTool.getAllRules()) {
                //    if (!rule.isDictionaryBasedSpellingRule()) {
                //        langTool.disableRule(rule.getId());
                //    }
                //}
                List<RuleMatch> matches = langTool.check(s);
                textPane1.setText("");
                for (String s2 : langTool.sentenceTokenize(s)) {
                    Pattern p = Pattern.compile("([aeiouyã])+?\\w*?[^e]");
                    textPane1.setText(textPane1.getText() + s2 + "  ----   ");
                    for (String s1 : p.split(s2.toLowerCase())) {
                        textPane1.setText(textPane1.getText() + s1 + " ");
                    }
                    textPane1.setText(textPane1.getText() + "\n");
                }


                for (RuleMatch match : matches) {
                    textPane1.setText(textPane1.getText() + "\nPotential typo at line " +
                            match.getLine() + ", column " +
                            match.getColumn() + ": " + match.getMessage());
                    textPane1.setText(textPane1.getText() + "Suggested correction(s): " +
                            match.getSuggestedReplacements());


                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}