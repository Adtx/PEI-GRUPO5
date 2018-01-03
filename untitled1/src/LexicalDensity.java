/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

/**
 *
 * @author adt
 */
public class LexicalDensity {

    public double calculate(String text,int totalWords) throws IOException{

        InputStream modelIn = new FileInputStream("C:\\Users\\Utilizador\\Downloads\\en-pos-maxent.bin");
        POSModel model = new POSModel(modelIn);
        POSTaggerME tagger = new POSTaggerME(model);
        ArrayList<String> tokenized = new ArrayList<>();

        String[] lexicalTags = new String[] {
                "JJ","JJR","JJS","NN","NNS","NP","NPS","RB","RBR","RBS","VB","VBD",
                "VBG","VBN","VBP","VBZ","VH","VHD","VHG","VHN","VHP","VHZ","VV","VVD",
                "VVG","VVN","VVP","VVZ"
        };

        StringTokenizer st = new StringTokenizer(text);
        while (st.hasMoreTokens()) {
            tokenized.add(st.nextToken());
        }

        String[] textArray = tokenized.toArray(new String[0]);

        String[] tags = tagger.tag(textArray);

        double tokens = 0.0;

        for(String tag : tags)
            if(Arrays.asList(lexicalTags).contains(tag)) tokens++;
        //System.out.println(tag);

        //double totalWords = text.split(" ").length;

        double density = tokens/totalWords*100;

        return density;
    }
}
