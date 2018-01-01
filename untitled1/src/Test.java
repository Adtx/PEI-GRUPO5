import java.io.IOException;
import java.util.Map;

public class Test {

    //text_stats
    private Map<String,Integer> repeated_words;
    private int total_words;
    private int total_sentences;
    private int total_syllables;
    private int complex_words;
    private int letter_count;
    private int common_words;
    private int total_different_words;
    private int different_advanced_words;
    private int total_paragraphs;

    //readibility scores
    private float flesch_reading_ease;
    private float flesch_kinkaid;
    private float gunning_fog;
    private float coleman_liau;
    private float smog_grade;
    private float automated_readibility_index;

    //lexical density
    private double lexical_density;

    //lexical richness
    private float beyond_2000;
    private float advanced_ttr;
    private float advanced_guiraud;
    private float ttr;
    private float rttr;
    private float cttr;
    private float m;
    private float h;
    private float s;
    private float u;
    private float mwf;
    private float r;

    //language modeling
    private float bigram_model;


    public Test_Result run_test(String texto) throws IOException {
        // Remove stats from text (can be optimized to minimize the number of times the text is read)
        Text_stats ts=new Text_stats();
        StanfordLemmatizer lsem= new StanfordLemmatizer();
        lsem.lemmatize(texto);
        repeated_words=ts.palavras_repetidas(texto);
        total_sentences=ts.sentences(texto);
        total_syllables=ts.count_all_syllables(texto);
        complex_words=ts.count_complex_words(texto);
        letter_count=ts.letter_count(texto);
        total_different_words=repeated_words.size();
        common_words=lsem.common_words();
        different_advanced_words=lsem.different_advanced_words(repeated_words);
        total_paragraphs=ts.count_paragraphs(texto);

        //Calculate all readibility scores
        Readability rs=new Readability();
        flesch_kinkaid=rs.flesch_kincaid_grade_level(total_words,total_sentences,total_syllables);
        flesch_reading_ease=rs.flesch_reading_ease(total_words,total_sentences,total_syllables);
        gunning_fog=rs.gunning_fog_score(total_words,total_sentences,complex_words);
        coleman_liau=rs.coleman_liau_index(letter_count,total_words,total_sentences);
        smog_grade=rs.smog_grade(complex_words,total_sentences);
        automated_readibility_index=rs.automated_readibility_index(letter_count,total_words,total_sentences);

        //Calculate lexical density
        LexicalDensity ld=new LexicalDensity();
        lexical_density=ld.calculate(texto,total_words);

        //Calculate lexical richness
        Lexical_Richness lr=new Lexical_Richness();
        beyond_2000=lr.beyond_2000(total_words,common_words);
        advanced_ttr=lr.advanced_ttr(different_advanced_words,total_words);
        advanced_guiraud=lr.advanced_guiraud(different_advanced_words,total_words);
        ttr=lr.ttr(total_different_words,total_words);
        rttr=lr.rttr(total_different_words,total_words);
        cttr=lr.cttr(total_different_words,total_words);
        m=lr.m(total_different_words,total_words);
        h=lr.h(total_different_words,total_words);
        s=lr.s(total_different_words,total_words);
        u=lr.u(total_different_words,total_words);
        mwf=lr.mwf(total_different_words,total_words);
        r=lr.r(total_different_words,total_words);

        //language modelling
        Language_moddeling lm=new Language_moddeling(texto);
        bigram_model=lm.bigram_model_value();


        return new Test_Result();
    }
}
