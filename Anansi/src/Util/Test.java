package Util;

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
    private float words_per_sentence;
    private float sentences_per_paragraph;

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
    private float bigram_perplexety;
    private float bigram_model_reverse;
    private float bigram_perplexety_reverse;


    //for better optimization
    private Language_moddeling lm;
    private Text_stats ts;
    private StanfordLemmatizer lsem;
    private Readability rs;
    private LexicalDensity ld;
    private Lexical_Richness lr;

    //level of words
    private float a1_words;
    private float a2_words;
    private float b1_words;
    private float b2_words;
    private float c1_words;
    private float c2_words;


    //mistake stats
    private int simple_errors;
    private int complex_errors;
    private float simple_errors_per_word;
    private float complex_errors_per_word;

    public Test(){
        lm=new Language_moddeling();
        ts=new Text_stats();
        lsem= new StanfordLemmatizer();
        rs=new Readability();
        ld=new LexicalDensity();
        lr=new Lexical_Richness();
        //run_test(texto);
        //return new Test_Result();
    }

    public void run_test(String texto) throws IOException {
        // Remove stats from text (can be optimized to minimize the number of times the text is read)

        lsem.lemmatize(texto);
        repeated_words=ts.palavras_repetidas(texto);
        total_words=ts.countWords(texto);
        total_sentences=ts.sentences(texto);

        total_syllables=ts.count_all_syllables(texto);
        complex_words=ts.count_complex_words(texto);
        letter_count=ts.letter_count(texto);
        total_different_words=repeated_words.size();
        common_words=lsem.common_words();
        different_advanced_words=lsem.different_advanced_words(repeated_words);
        total_paragraphs=ts.count_paragraphs(texto);
        words_per_sentence=total_words/(float)total_sentences;
        sentences_per_paragraph=total_sentences/(float)total_paragraphs;

        //Calculate all readibility scores
        flesch_kinkaid=rs.flesch_kincaid_grade_level(total_words,total_sentences,total_syllables);
        flesch_reading_ease=rs.flesch_reading_ease(total_words,total_sentences,total_syllables);
        gunning_fog=rs.gunning_fog_score(total_words,total_sentences,complex_words);
        coleman_liau=rs.coleman_liau_index(letter_count,total_words,total_sentences);
        smog_grade=rs.smog_grade(complex_words,total_sentences);
        automated_readibility_index=rs.automated_readibility_index(letter_count,total_words,total_sentences);

        //Calculate lexical density
        lexical_density=ld.calculate(texto,total_words);

        //Calculate lexical richness
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
        bigram_model=lm.bigram_model_value(texto);
        bigram_model_reverse=lm.bigram_model_value_reverse(texto);
        //bigram_perplexety=(float) Math.pow(2,(-bigram_model/total_words));
        //bigram_perplexety=(float)  nthroot(total_words,bigram_model);
        //bigram_perplexety_reverse=(float)  nthroot(total_words,bigram_model_reverse);
        bigram_perplexety=(float)  bigram_model;
        bigram_perplexety_reverse=(float)  bigram_model_reverse;

        //words per level

        a1_words=lsem.a1_words();
        a2_words=lsem.a2_words();
        b1_words=lsem.b1_words();
        b2_words=lsem.b2_words();
        c1_words=lsem.c1_words();
        c2_words=lsem.c2_words();

        //mistake stats;

        Mistakes_Stats ms= new Mistakes_Stats();
        simple_errors=ms.get_simple_errors(texto);
        complex_errors=ms.get_complex_errors(texto);
        simple_errors_per_word=simple_errors;
        complex_errors_per_word=complex_errors;
        //return new Test_Result();
    }


    public String print_test() {
        StringBuilder sb = new StringBuilder();
        sb.append(total_words);
        sb.append(';');
        sb.append(total_sentences);
        sb.append(';');
        sb.append(total_syllables);
        sb.append(';');
        sb.append(complex_words);
        sb.append(';');
        sb.append(letter_count);
        sb.append(';');
        sb.append(common_words);
        sb.append(';');
        sb.append(total_different_words);
        sb.append(';');
        sb.append(different_advanced_words);
        sb.append(';');
        sb.append(flesch_reading_ease);
        sb.append(';');
        sb.append(flesch_kinkaid);
        sb.append(';');
        sb.append(gunning_fog);
        sb.append(';');
        sb.append(coleman_liau);
        sb.append(';');
        sb.append(smog_grade);
        sb.append(';');
        sb.append(automated_readibility_index);
        sb.append(';');
        sb.append(lexical_density);
        sb.append(';');
        sb.append(beyond_2000);
        sb.append(';');
        sb.append(advanced_ttr);
        sb.append(';');
        sb.append(advanced_guiraud);
        sb.append(';');
        sb.append(ttr);
        sb.append(';');
        sb.append(rttr);
        sb.append(';');
        sb.append(cttr);
        sb.append(';');
        sb.append(m);
        sb.append(';');
        sb.append(h);
        sb.append(';');
        sb.append(s);
        sb.append(';');
        sb.append(u);
        sb.append(';');
        sb.append(mwf);
        sb.append(';');
        sb.append(r);
        sb.append(';');
        sb.append(bigram_model);
        sb.append(';');
        sb.append(bigram_perplexety);
        sb.append(';');
        sb.append(a1_words);
        sb.append(';');
        sb.append(a2_words);
        sb.append(';');
        sb.append(b1_words);
        sb.append(';');
        sb.append(b2_words);
        sb.append(';');
        sb.append(c1_words);
        sb.append(';');
        sb.append(c2_words);
        sb.append(';');
        sb.append(bigram_model_reverse);
        sb.append(';');
        sb.append(bigram_perplexety_reverse);
        sb.append(';');
        sb.append(words_per_sentence);
        sb.append(';');
        sb.append(sentences_per_paragraph);
        sb.append(';');
        sb.append(simple_errors_per_word);
        sb.append(';');
        sb.append(complex_errors_per_word);
        return sb.toString();
    }

    public static double nthroot(int n, double A) {
        return nthroot(n, A, .001);
    }
    public static double nthroot(int n, double A, double p) {
        if(A < 0) {
            System.err.println("A < 0");// we handle only real positive numbers
            return -1;
        } else if(A == 0) {
            return 0;
        }
        double x_prev = A;
        double x = A / n;  // starting "guessed" value...
        while(Math.abs(x - x_prev) > p) {
            x_prev = x;
            x = ((n - 1.0) * x + A / Math.pow(x, n - 1.0)) / n;
        }
        return x;
    }

    public Map<String,Integer> get_repeated_words(){
        return repeated_words;
    }

    public int get_total_words(){
        return total_words;
    }

    public int get_total_sentences(){
        return total_sentences;
    }

    public int get_total_syllables(){
        return total_syllables;
    }

    public int get_complex_words(){
        return complex_words;
    }

    public int get_letter_count(){
        return letter_count;
    }

    public int get_common_words(){
        return common_words;
    }

    public int get_total_different_words(){
        return total_different_words;
    }

    public int get_different_advanced_words(){
        return different_advanced_words;
    }

    public int get_total_paragraphs(){
        return total_paragraphs;
    }

    public float get_words_per_sentence(){
        return words_per_sentence;
    }

    public float get_sentences_per_paragraph(){
        return sentences_per_paragraph;
    }

    public float get_flesh_reading_ease(){
        return flesch_reading_ease;
    }

    public float get_flesch_kinkaid(){
        return flesch_kinkaid;
    }

    public float get_gunning_fog(){
        return gunning_fog;
    }

    public float get_coleman_liau(){
        return coleman_liau;
    }

    public float get_smog_grade(){
        return smog_grade;
    }

    public float get_automated_readibility_index(){
        return automated_readibility_index;
    }

    public double get_lexical_density(){
        return lexical_density;
    }

    public float get_beyond_2000(){
        return beyond_2000;
    }

    public float get_advanced_ttr(){
        return advanced_ttr;
    }

    public float get_advanced_guiraud(){
        return advanced_guiraud;
    }

    public float get_ttr(){
        return ttr;
    }

    public float get_rttr(){
        return rttr;
    }

    public float get_cttr(){
        return cttr;
    }

    public float get_m(){
        return m;
    }

    public float get_h(){
        return h;
    }

    public float get_s(){
        return s;
    }

    public float get_u(){
        return u;
    }

    public float get_mwf(){
        return mwf;
    }

    public float get_r(){
        return r;
    }

    public float get_bigram_model(){
        return bigram_model;
    }

    public float get_bigram_perplexity(){
        return bigram_perplexety;
    }

    public float get_bigram_model_reverse(){
        return bigram_model_reverse;
    }

    public float get_bigram_perplexity_reverse(){
        return bigram_perplexety_reverse;
    }

    public float get_a1_words(){
        return a1_words;
    }

    public float get_a2_words(){
        return a2_words;
    }

    public float get_b1_words(){
        return b1_words;
    }

    public float get_b2_words(){
        return b2_words;
    }

    public float get_c1_words(){
        return c1_words;
    }

    public float get_c2_words(){
        return c2_words;
    }

    public int get_simple_errors(){
        return simple_errors;
    }

    public int get_complex_errors(){
        return complex_errors;
    }

    public float get_simple_errors_per_word(){
        return simple_errors_per_word;
    }

    public float get_complex_errors_per_word(){
        return complex_errors_per_word;
    }
}
