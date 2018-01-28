import static java.lang.Math.log;
import static java.lang.Math.sqrt;

public class Lexical_Richness {

    //from the article on the email sent by Silvia
    public double beyond_2000(int total_words,int common_words){
        double beyond2000= (double) common_words/ (double) total_words;
        return beyond2000;
    }

    public double advanced_guiraud(int different_advanced_words,int total_words){
        return (double) (different_advanced_words/sqrt(total_words));
    }

    public double advanced_ttr(int different_advanced_words, int total_words){
        return (double) ((double) different_advanced_words/ (double) total_words);

    }

    //from here https://ac.els-cdn.com/S1877042813041888/1-s2.0-S1877042813041888-main.pdf?_tid=b9676088-ee23-11e7-946b-00000aab0f01&acdnat=1514722466_aec041166cbb7901ec8e6f37ce752b19

    public double ttr(int different_words,int total_words){
        return (double) ( (double) different_words/ (double)total_words);
    }

    public double rttr(int different_words,int total_words){
        return (double) (different_words/sqrt(total_words));
    }

    public double cttr(int different_words,int total_words){
        return (double) (different_words/sqrt(2*total_words));
    }

    //according to the work this one is the most stable with changes in text length
    public double m(int different_words,int total_words){
        return (double) ((log(total_words)-log(different_words))/(log(total_words)*log(total_words)));
    }

    public double h(int different_words,int total_words){
        return (double) (log(different_words)/log(total_words));
    }



    public double s(int different_words,int total_words){
        return (double) (log(log(different_words))/log(log(total_words)));
    }

    public double u(int different_words,int total_words){
        return (double) ((log(total_words)*log(total_words))/(log(total_words)-log(different_words)));
    }

    //from here http://www.tufs.ac.jp/ts/personal/corpuskun/pdf/2014/LexMeasureHandOut.pdf
    public double mwf(int different_words,int total_words){
        return (double) ( (double) total_words/ (double) different_words);
    }

    public double r(int different_words,int total_words){
        return (double) (different_words/sqrt(total_words));
    }

}
