import static java.lang.Math.log;
import static java.lang.Math.sqrt;

public class Lexical_Richness {

    //from the article on the email sent by Silvia
    public float beyond_2000(int total_words,int common_words){
        float beyond2000= (float) common_words/ (float) total_words;
        return beyond2000;
    }

    public float advanced_guiraud(int different_advanced_words,int total_words){
        return (float) (different_advanced_words/sqrt(total_words));
    }

    public float advanced_ttr(int different_advanced_words, int total_words){
        return (float) ((float) different_advanced_words/ (float) total_words);

    }

    //from here https://ac.els-cdn.com/S1877042813041888/1-s2.0-S1877042813041888-main.pdf?_tid=b9676088-ee23-11e7-946b-00000aab0f01&acdnat=1514722466_aec041166cbb7901ec8e6f37ce752b19

    public float ttr(int different_words,int total_words){
        return (float) ( (float) different_words/ (float)total_words);
    }

    public float rttr(int different_words,int total_words){
        return (float) (different_words/sqrt(total_words));
    }

    public float cttr(int different_words,int total_words){
        return (float) (different_words/sqrt(2*total_words));
    }

    //according to the work this one is the most stable with changes in text length
    public float m(int different_words,int total_words){
        return (float) ((log(total_words)-log(different_words))/(log(total_words)*log(total_words)));
    }

    public float h(int different_words,int total_words){
        return (float) (log(different_words)/log(total_words));
    }



    public float s(int different_words,int total_words){
        return (float) (log(log(different_words))/log(log(total_words)));
    }

    public float u(int different_words,int total_words){
        return (float) ((log(total_words)*log(total_words))/(log(total_words)-log(different_words)));
    }

    //from here http://www.tufs.ac.jp/ts/personal/corpuskun/pdf/2014/LexMeasureHandOut.pdf
    public float mwf(int different_words,int total_words){
        return (float) ( (float) total_words/ (float) different_words);
    }

    public float r(int different_words,int total_words){
        return (float) (different_words/sqrt(total_words));
    }

}
