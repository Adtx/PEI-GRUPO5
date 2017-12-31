import static java.lang.Math.sqrt;

public class Lexical_Richness {

    public float beyond_2000(int total_words,int common_words){
        return (float) (common_words/total_words);
    }

    public float advanced_guiraud(int different_basic_words,int total_words){
        return (float) (different_basic_words/sqrt(total_words));
    }

    public float advanced_ttr(int different_basic_words, int total_words){
        return (float) (different_basic_words/total_words);

    }

}
