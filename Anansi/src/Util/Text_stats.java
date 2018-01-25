package Util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text_stats {

    public Map<String,Integer> palavras_repetidas(String texto) {
        Map<String,Integer> Hashpalavras =new HashMap<String,Integer>();

        //Usando uma string como exemplo
        //String texto = "Para contar quantas isn't palavras existem no texto, primeiro temos que definir o que são palavras,";

        //Usando um ficheiro .txt, criar um ficheiro e indicar caminho
            /* final String FILENAME = "C:\\Users\\Stéphane\\Desktop\\teste.txt";
            String texto = null;
            try { texto = readFile(FILENAME); }
            catch (IOException e) { e.printStackTrace(); }
            */

        //Por tudo em  minusculo sem pontos e virgulas ou espaços no começo e fim
        texto = texto.replaceAll("[,.]", "");
        texto = texto.toLowerCase();
        texto = texto.trim();

        //separar as palavras
        String[] palavras = texto.split(" ");

        for (String palavra : palavras) {
            if(Hashpalavras.containsKey(palavra)){
                int temp = Hashpalavras.get(palavra)+1;
                Hashpalavras.remove(palavra);
                Hashpalavras.put(palavra,temp);
            }
            else Hashpalavras.put(palavra,1);
        }
        //imprimir palavras e numero de ocorrencias
        /*
        for (String key : Hashpalavras.keySet()) {
            System.out.println(key + " " + Hashpalavras.get(key));
        }*/
        return Hashpalavras;
    }

    //função auxiliar para o caso de querer usar um ficheiro .txt
    static String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader (file));
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();
        String         ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }

    // Recebe um texto, e retorna um inteiro com o número de palavras.

    public int countWords(String s){

        int wordCount = 0;

        boolean word = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
                word = true;

            } else if (!Character.isLetter(s.charAt(i)) && word) {
                wordCount++;
                word = false;
            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }

    public int sentences(String text) throws IOException{
        BufferedReader reader = new BufferedReader(new StringReader(text));
        int sentenceCount = 0;
        String line;
        String delimiters = "?!.";

        while ((line = reader.readLine()) != null) { // Continue reading until end of file is reached
            for (int i = 0; i < line.length(); i++) {
                if (delimiters.indexOf(line.charAt(i)) != -1) { // If the delimiters string contains the character
                    sentenceCount++;
                }
            }
        }

        reader.close();
        return sentenceCount;
    }

    public int count_complex_words(String text){
        String[] words = text.split("\\s");
        int complex_words = 0;
        for(String str:words){
            if(countSyllables(str)>=3){
                complex_words++;
            }
        }
        return complex_words;
    }

    public int count_all_syllables(String text){
        String[] words = text.split("\\s");
        int syllables = 0;
        for(String str:words){
            //System.out.println(str);
            if(str.length()>0) {
                syllables += countSyllables(str);
            }
        }
        return syllables;
    }

    private int countSyllables(String word){
        // TODO: Implement this method so that you can call it from the
        // getNumSyllables method in BasicDocument (module 1) and
        // EfficientDocument (module 2).
        int count = 0;
        word = word.toLowerCase();
        //System.out.println(word);
        if(word.length()>0) {
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

    private int countit(String word) {
        int count = 0;
        Pattern splitter = Pattern.compile("[^aeiouy]*[aeiouy]+");
        Matcher m = splitter.matcher(word);

        while (m.find()) {
            count++;
        }
        return count;
    }

    private boolean silente(String word) {
        word = word.substring(0, word.length()-1);

        Pattern yup = Pattern.compile("[aeiouy]");
        Matcher m = yup.matcher(word);

        if (m.find()) {
            return true;
        } else
            return false;
    }


    public int letter_count(String sentence){

        int letterCount = 0;
        int length = sentence.length();
        for (int i = 0; i < length; i++) {
            char c = sentence.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                letterCount++;
            }
        }

        return letterCount;
    }

    public int common_words(String texto) {
        StanfordLemmatizer lemma= new StanfordLemmatizer();
        return lemma.common_words();
    }

    public int count_paragraphs(String texto){
        String[] lines = texto.split("\r\n|\r|\n");
        return  lines.length;
    }
}


