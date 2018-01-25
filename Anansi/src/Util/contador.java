package Util;
import java.io.BufferedInputStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class contador {


    public static void main(String[] args) {

        String texto="As autoridades foram alertadas para este naufrágio durante a madrugada. Começaram por encontraram dois corpos";
        String texto2 = "Isn't it Scanner in? Can keyboard and in be used interchangeably on't? ";
        int res = countWords(texto2);

        System.out.println("No texto existe :" + res + " palavras.");
        //System.out.println(contaPalavras("dia"));
    }

   // Recebe um texto, e retorna um inteiro com o número de palavras.

    public static int countWords(String s){

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

}



