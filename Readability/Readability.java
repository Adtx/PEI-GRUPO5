/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bass
 */
public class Readability {

    
    public static float felsch(String text) throws IOException{
        float sentences = sentences(text);
        float wordcount = countWords(text);
        String[] words = text.split("\\s");
        float syllables = 0;
        for(String str:words){
            syllables += countSyllables(str);
        }
        float rtr=(float) (206.835-1.015*(wordcount/sentences)-84.6*(syllables/wordcount));
        return rtr;
    }
    
    public static int sentences(String text) throws IOException{
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
    
    public static int countWords(String s){

        int wordCount = 0;

        boolean word = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
        // if the char is a letter, word = true.
            if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
                word = true;
            // if char isn't a letter and there have been letters before,
            // counter goes up.
            } else if (!Character.isLetter(s.charAt(i)) && word) {
                wordCount++;
                word = false;
            // last word of String; if it doesn't end with a non letter, it
            // wouldn't count without this.
            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }
    
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

}

