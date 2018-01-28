/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.StrictMath.sqrt;

/**
 *
 * @author bass
 */
public class Readability {




    public double flesch_reading_ease(int total_words,int total_sentences, int total_syllables){
        /*double sentences = sentences(text);
        double wordcount = countWords(text);*/
        double sentences = total_sentences;
        double wordcount = total_words;
        /*String[] words = text.split("\\s");
        double syllables = 0;
        for(String str:words){
            syllables += countSyllables(str);
        }*/
        double syllables=total_syllables;
        double rtr=(double) (206.835-1.015*(wordcount/sentences)-84.6*(syllables/wordcount));
        return rtr;
    }

    public double flesch_kincaid_grade_level(int total_words,int total_sentences, int total_syllables){
        //TODO: currently hot fix needs to be checked if this assumption makes sense
        if(total_sentences==0){
            total_sentences=1;
        }
        double result= (double) (0.39*(total_words/total_sentences)+11.8*(total_syllables/total_words)-15.59);
        return result;
    }

    public double gunning_fog_score(int total_words,int total_sentences, int complex_words){

        double result=(double)  0.4*((total_words/total_sentences)+100*(complex_words/total_words));
        return result;
    }

    public double coleman_liau_index(int letterCount,int wordCount,int sentenceCount){

            double l = (double) letterCount / (double) wordCount * 100;
            double s = (double) sentenceCount / (double) wordCount * 100;

            return (double) (0.0588 * l - 0.296 * s - 15.8);
    }

    public double smog_grade(int complex_words,int total_sentences){
        //This is just an aproximation of the smog grade in order to work with all of our texts,
        //according to the wiki page the text needed to have more then 30 sentences in order for this formula to be used
        //our smaller texts probably wont have 30 sentences
        double result= (double) (1.0430*sqrt(complex_words*(30/total_sentences))+3.1291);
        return result;
    }

    public double automated_readibility_index(int total_letter,int total_words, int total_sentences){
        double result= (double) (4.71*(total_letter/total_words)+0.5*(total_words/total_sentences)-21.43);
        return result;
    }




}

