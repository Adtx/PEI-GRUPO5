package Util;
import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.language.PortugalPortuguese;
import org.languagetool.rules.RuleMatch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mistakes_Stats {

    private static final String PARAGRAPH_SPLIT_REGEX = "\\n";




    public int get_complex_errors(String texto) {
        JLanguageTool langTool = null;
        int err_dif=0;
        try {
            err_dif = 0;
            langTool= new JLanguageTool(new BritishEnglish());
            List<RuleMatch> matches = langTool.check(texto);
            String str = texto;
            String[] parag = str.split(PARAGRAPH_SPLIT_REGEX);
            ArrayList<String> parags = new ArrayList<String>();
            for (String b : parag)
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
                if (countSyllables(error) >= 3) {

                    err_dif++;
                }
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return err_dif;
    }

    public int get_simple_errors(String texto) {
        int err_fac=0;
        JLanguageTool langTool = null;
        try {
            err_fac = 0;

            langTool= new JLanguageTool(new BritishEnglish());
            List<RuleMatch> matches = langTool.check(texto);
            String str = texto;
            String[] parag = str.split(PARAGRAPH_SPLIT_REGEX);
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
                if (countSyllables(error) < 3) {
                    err_fac++;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return err_fac;
    }


    private int countSyllables(String word) {
        // TODO: Implement this method so that you can call it from the
        // getNumSyllables method in BasicDocument (module 1) and
        // EfficientDocument (module 2).
        int count = 0;
        word = word.toLowerCase();
        if (word.length() > 1) {
            if (word.charAt(word.length() - 1) == 'e') {
                if (silente(word)) {
                    String newword = word.substring(0, word.length() - 1);
                    count = count + countit(newword);
                } else {
                    count++;
                }
            } else {
                count = count + countit(word);
            }
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
        word = word.substring(0, word.length() - 1);

        Pattern yup = Pattern.compile("[aeiouy]");
        Matcher m = yup.matcher(word);

        if (m.find()) {
            return true;
        } else
            return false;
    }




}

