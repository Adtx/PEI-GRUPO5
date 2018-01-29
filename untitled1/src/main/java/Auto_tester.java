import org.apache.commons.lang.ArrayUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;


public class Auto_tester {

    private ArrayList<Double> total_words;
    private ArrayList<Double> total_sentences;
    private ArrayList<Double> total_sylables;
    private ArrayList<Double> complex_words;
    private ArrayList<Double> letter_count;
    private ArrayList<Double> common_words;
    private ArrayList<Double> total_different_words;
    private ArrayList<Double> different_advanced_words;
    private ArrayList<Double> advanced_ttr;
    private ArrayList<Double> advanced_guiraud;
    private ArrayList<Double> ttr;
    private ArrayList<Double> rttr;
    private ArrayList<Double> cttr;
    private ArrayList<Double> h;
    private ArrayList<Double> s;
    private ArrayList<Double> mwf;
    private ArrayList<Double> r;
    private ArrayList<Double> bigram_perplexity;
    private ArrayList<Double> a1_words;
    private ArrayList<Double> a2_words;
    private ArrayList<Double> b1_words;
    private ArrayList<Double> b2_words;
    private ArrayList<Double> c1_words;
    private ArrayList<Double> c2_words;
    private ArrayList<Double> bigram_perplexity_reverse;
    private ArrayList<Double> simple_errors_per_word;
    private ArrayList<Double> comples_errors_per_word;
    private ArrayList<Integer> lvl;

    private ArrayList<Double> means;
    private ArrayList<Double> deviations;

    public Auto_tester(){
        total_words= new ArrayList<>();
        total_sentences= new ArrayList<>();
        total_sylables= new ArrayList<>();
        complex_words= new ArrayList<>();
        letter_count= new ArrayList<>();
        common_words= new ArrayList<>();
        total_different_words= new ArrayList<>();
        different_advanced_words= new ArrayList<>();
        advanced_ttr= new ArrayList<>();
        advanced_guiraud= new ArrayList<>();
        ttr= new ArrayList<>();
        rttr= new ArrayList<>();
        cttr= new ArrayList<>();
        h= new ArrayList<>();
        s= new ArrayList<>();
        mwf= new ArrayList<>();
        r= new ArrayList<>();
        bigram_perplexity= new ArrayList<>();
        a1_words= new ArrayList<>();
        a2_words= new ArrayList<>();
        b1_words= new ArrayList<>();
        b2_words= new ArrayList<>();
        c1_words= new ArrayList<>();
        c2_words= new ArrayList<>();
        bigram_perplexity_reverse= new ArrayList<>();
        simple_errors_per_word= new ArrayList<>();
        comples_errors_per_word= new ArrayList<>();
        lvl= new ArrayList<>();;

        means= new ArrayList<>();
        deviations= new ArrayList<>();
    }

    public void create_normalized_datasets() throws IOException {
        print_normalized_train_set();
        print_normalized_test_set();
    }

    private void print_normalized_train_set() throws IOException {
        train_texts_normalized();
        PrintWriter pw = new PrintWriter(new File("train_results.csv"));
        PrintWriter pw2 = new PrintWriter(new File("train_results_neural_net.csv"));
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Normalize n=new Normalize();
        //Double[] l_means=new Double[means.size()];
        //l_means=means.toArray(l_means);
        Double[] l_means=means.toArray(new Double[means.size()]);
        Double[] l_deviations=deviations.toArray(new Double[deviations.size()]);

        //FILE FOR EVERYONE
        sb.append("total_words");
        sb.append(';');
        sb.append("total_sentences");
        sb.append(';');
        sb.append("total_syllables");
        sb.append(';');
        sb.append("complex_words");
        sb.append(';');
        sb.append("letter_count");
        sb.append(';');
        sb.append("common_words");
        sb.append(';');
        sb.append("total_different_words");
        sb.append(';');
        sb.append("different_advanced_words");
        sb.append(';');
      /*
      sb.append("flesch_reading_ease");
      sb.append(';');
      sb.append("flesch_kinkaid");
      sb.append(';');
      sb.append("gunning_fog");
      sb.append(';');
      sb.append("coleman_liau");
      sb.append(';');
      sb.append("smog_grade");
      sb.append(';');
      sb.append("automated_readibility_index");
      sb.append(';');
      sb.append("lexical_density");
      sb.append(';');
      sb.append("beyond_2000");
      sb.append(';');
      */
        sb.append("advanced_ttr");
        sb.append(';');
        sb.append("advanced_guiraud");
        sb.append(';');
        sb.append("ttr");
        sb.append(';');
        sb.append("rttr");
        sb.append(';');
        sb.append("cttr");
        sb.append(';');
      /*
      sb.append("m");
      sb.append(';');
      */
        sb.append("h");
        sb.append(';');
        sb.append("s");
        sb.append(';');
      /*
      sb.append("u");
      sb.append(';');
      */
        sb.append("mwf");
        sb.append(';');
        sb.append("r");
        sb.append(';');
      /*
      sb.append("bigram_model");
      sb.append(';');
      */
        sb.append("bigram_perplexety");
        sb.append(';');
        sb.append("a1_words");
        sb.append(';');
        sb.append("a2_words");
        sb.append(';');
        sb.append("b1_words");
        sb.append(';');
        sb.append("b2_words");
        sb.append(';');
        sb.append("c1_words");
        sb.append(';');
        sb.append("c2_words");
        sb.append(';');
      /*
      sb.append("bigram_model_reverse");
      sb.append(';');
      */
        sb.append("bigram_perplexety_reverse");
        sb.append(';');
      /*
      sb.append("words_per_sentence");
      sb.append(';');
      sb.append("sentences_per_paragraph");
      sb.append(';');
      */
        sb.append("simple_errors_per_word");
        sb.append(';');
        sb.append("complex_errors_per_word");
        sb.append(';');
        sb.append("level");
        sb.append('\n');

        //FILE FOR NEURAL NET
        sb2.append("level");
        sb2.append(';');
        sb2.append("total_words");
        sb2.append(';');
        sb2.append("total_sentences");
        sb2.append(';');
        sb2.append("total_syllables");
        sb2.append(';');
        sb2.append("complex_words");
        sb2.append(';');
        sb2.append("letter_count");
        sb2.append(';');
        sb2.append("common_words");
        sb2.append(';');
        sb2.append("total_different_words");
        sb2.append(';');
        sb2.append("different_advanced_words");
        sb2.append(';');
      /*
      sb2.append("flesch_reading_ease");
      sb2.append(';');
      sb2.append("flesch_kinkaid");
      sb2.append(';');
      sb2.append("gunning_fog");
      sb2.append(';');
      sb2.append("coleman_liau");
      sb2.append(';');
      sb2.append("smog_grade");
      sb2.append(';');
      sb2.append("automated_readibility_index");
      sb2.append(';');
      sb2.append("lexical_density");
      sb2.append(';');
      sb2.append("beyond_2000");
      sb2.append(';');
      */
        sb2.append("advanced_ttr");
        sb2.append(';');
        sb2.append("advanced_guiraud");
        sb2.append(';');
        sb2.append("ttr");
        sb2.append(';');
        sb2.append("rttr");
        sb2.append(';');
        sb2.append("cttr");
        sb2.append(';');
      /*
      sb2.append("m");
      sb2.append(';');
      */
        sb2.append("h");
        sb2.append(';');
        sb2.append("s");
        sb2.append(';');
      /*
      sb2.append("u");
      sb2.append(';');
      */
        sb2.append("mwf");
        sb2.append(';');
        sb2.append("r");
        sb2.append(';');
      /*
      sb2.append("bigram_model");
      sb2.append(';');
      */
        sb2.append("bigram_perplexety");
        sb2.append(';');
        sb2.append("a1_words");
        sb2.append(';');
        sb2.append("a2_words");
        sb2.append(';');
        sb2.append("b1_words");
        sb2.append(';');
        sb2.append("b2_words");
        sb2.append(';');
        sb2.append("c1_words");
        sb2.append(';');
        sb2.append("c2_words");
        sb2.append(';');
      /*
      sb2.append("bigram_model_reverse");
      sb2.append(';');
      */
        sb2.append("bigram_perplexety_reverse");
        sb2.append(';');
      /*
      sb2.append("words_per_sentence");
      sb2.append(';');
      sb2.append("sentences_per_paragraph");
      sb2.append(';');
      */
        sb2.append("simple_errors_per_word");
        sb2.append(';');
        sb2.append("complex_errors_per_word");
        sb2.append('\n');

        for(int i=0;i<lvl.size();i++){
            ArrayList<Double> to_normalize= new ArrayList<>();
            to_normalize.add(total_words.get(i));
            to_normalize.add(total_sentences.get(i));
            to_normalize.add(total_sylables.get(i));
            to_normalize.add(complex_words.get(i));
            to_normalize.add(letter_count.get(i));
            to_normalize.add(common_words.get(i));
            to_normalize.add(total_different_words.get(i));
            to_normalize.add(different_advanced_words.get(i));
            to_normalize.add(advanced_ttr.get(i));
            to_normalize.add(advanced_guiraud.get(i));
            to_normalize.add(ttr.get(i));
            to_normalize.add(rttr.get(i));
            to_normalize.add(cttr.get(i));
            to_normalize.add(h.get(i));
            to_normalize.add(s.get(i));
            to_normalize.add(mwf.get(i));
            to_normalize.add(r.get(i));
            to_normalize.add(bigram_perplexity.get(i));
            to_normalize.add(a1_words.get(i));
            to_normalize.add(a2_words.get(i));
            to_normalize.add(b1_words.get(i));
            to_normalize.add(b2_words.get(i));
            to_normalize.add(c1_words.get(i));
            to_normalize.add(c2_words.get(i));
            to_normalize.add(bigram_perplexity_reverse.get(i));
            to_normalize.add(simple_errors_per_word.get(i));
            to_normalize.add(comples_errors_per_word.get(i));
            to_normalize=n.normalize(to_normalize,l_means,l_deviations);
            sb2.append((lvl.get(i)-1)+";");
            sb2.append(normalized_values_to_string(to_normalize)+"\n");
            sb.append(normalized_values_to_string(to_normalize));
            sb.append(";"+lvl.get(i)+"\n");
        }

        pw.write(sb.toString());
        pw.close();
        pw2.write(sb2.toString());
        pw2.close();
        System.out.println("done!");

    }

    private void print_normalized_test_set() throws IOException{
        Test t=new Test();
        PrintWriter pw = new PrintWriter(new File("test_results.csv"));
        PrintWriter pw2 = new PrintWriter(new File("test_results_neural_net.csv"));
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Normalize n=new Normalize();
        Double[] l_means=means.toArray(new Double[means.size()]);
        Double[] l_deviations=deviations.toArray(new Double[deviations.size()]);


        //FILE FOR EVERYONE
        sb.append("total_words");
        sb.append(';');
        sb.append("total_sentences");
        sb.append(';');
        sb.append("total_syllables");
        sb.append(';');
        sb.append("complex_words");
        sb.append(';');
        sb.append("letter_count");
        sb.append(';');
        sb.append("common_words");
        sb.append(';');
        sb.append("total_different_words");
        sb.append(';');
        sb.append("different_advanced_words");
        sb.append(';');
      /*
      sb.append("flesch_reading_ease");
      sb.append(';');
      sb.append("flesch_kinkaid");
      sb.append(';');
      sb.append("gunning_fog");
      sb.append(';');
      sb.append("coleman_liau");
      sb.append(';');
      sb.append("smog_grade");
      sb.append(';');
      sb.append("automated_readibility_index");
      sb.append(';');
      sb.append("lexical_density");
      sb.append(';');
      sb.append("beyond_2000");
      sb.append(';');
      */
        sb.append("advanced_ttr");
        sb.append(';');
        sb.append("advanced_guiraud");
        sb.append(';');
        sb.append("ttr");
        sb.append(';');
        sb.append("rttr");
        sb.append(';');
        sb.append("cttr");
        sb.append(';');
      /*
      sb.append("m");
      sb.append(';');
      */
        sb.append("h");
        sb.append(';');
        sb.append("s");
        sb.append(';');
      /*
      sb.append("u");
      sb.append(';');
      */
        sb.append("mwf");
        sb.append(';');
        sb.append("r");
        sb.append(';');
      /*
      sb.append("bigram_model");
      sb.append(';');
      */
        sb.append("bigram_perplexety");
        sb.append(';');
        sb.append("a1_words");
        sb.append(';');
        sb.append("a2_words");
        sb.append(';');
        sb.append("b1_words");
        sb.append(';');
        sb.append("b2_words");
        sb.append(';');
        sb.append("c1_words");
        sb.append(';');
        sb.append("c2_words");
        sb.append(';');
      /*
      sb.append("bigram_model_reverse");
      sb.append(';');
      */
        sb.append("bigram_perplexety_reverse");
        sb.append(';');
      /*
      sb.append("words_per_sentence");
      sb.append(';');
      sb.append("sentences_per_paragraph");
      sb.append(';');
      */
        sb.append("simple_errors_per_word");
        sb.append(';');
        sb.append("complex_errors_per_word");
        sb.append(';');
        sb.append("level");
        sb.append('\n');

        //FILE FOR NEURAL NET
        sb2.append("level");
        sb2.append(';');
        sb2.append("total_words");
        sb2.append(';');
        sb2.append("total_sentences");
        sb2.append(';');
        sb2.append("total_syllables");
        sb2.append(';');
        sb2.append("complex_words");
        sb2.append(';');
        sb2.append("letter_count");
        sb2.append(';');
        sb2.append("common_words");
        sb2.append(';');
        sb2.append("total_different_words");
        sb2.append(';');
        sb2.append("different_advanced_words");
        sb2.append(';');
      /*
      sb2.append("flesch_reading_ease");
      sb2.append(';');
      sb2.append("flesch_kinkaid");
      sb2.append(';');
      sb2.append("gunning_fog");
      sb2.append(';');
      sb2.append("coleman_liau");
      sb2.append(';');
      sb2.append("smog_grade");
      sb2.append(';');
      sb2.append("automated_readibility_index");
      sb2.append(';');
      sb2.append("lexical_density");
      sb2.append(';');
      sb2.append("beyond_2000");
      sb2.append(';');
      */
        sb2.append("advanced_ttr");
        sb2.append(';');
        sb2.append("advanced_guiraud");
        sb2.append(';');
        sb2.append("ttr");
        sb2.append(';');
        sb2.append("rttr");
        sb2.append(';');
        sb2.append("cttr");
        sb2.append(';');
      /*
      sb2.append("m");
      sb2.append(';');
      */
        sb2.append("h");
        sb2.append(';');
        sb2.append("s");
        sb2.append(';');
      /*
      sb2.append("u");
      sb2.append(';');
      */
        sb2.append("mwf");
        sb2.append(';');
        sb2.append("r");
        sb2.append(';');
      /*
      sb2.append("bigram_model");
      sb2.append(';');
      */
        sb2.append("bigram_perplexety");
        sb2.append(';');
        sb2.append("a1_words");
        sb2.append(';');
        sb2.append("a2_words");
        sb2.append(';');
        sb2.append("b1_words");
        sb2.append(';');
        sb2.append("b2_words");
        sb2.append(';');
        sb2.append("c1_words");
        sb2.append(';');
        sb2.append("c2_words");
        sb2.append(';');
      /*
      sb2.append("bigram_model_reverse");
      sb2.append(';');
      */
        sb2.append("bigram_perplexety_reverse");
        sb2.append(';');
      /*
      sb2.append("words_per_sentence");
      sb2.append(';');
      sb2.append("sentences_per_paragraph");
      sb2.append(';');
      */
        sb2.append("simple_errors_per_word");
        sb2.append(';');
        sb2.append("complex_errors_per_word");
        sb2.append('\n');

        String[] values;
        double[] doubleValues;
        ArrayList<Double> to_normalize= new ArrayList<>();
        String teste_results="";
        for(String s:a1){
            to_normalize= new ArrayList<>();
            t.run_test(s);
            sb2.append("0;");
            teste_results=t.print_test();
            values = teste_results.split(";");

            doubleValues = Arrays.stream(values)
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            Double[] doubleArray = ArrayUtils.toObject(doubleValues);
            to_normalize.addAll(Arrays.asList(doubleArray));

            to_normalize=n.normalize(to_normalize,l_means,l_deviations);
            sb2.append(normalized_values_to_string(to_normalize)+"\n");
            sb.append(normalized_values_to_string(to_normalize));
            sb.append(";1\n");
        }
        for(String s:a2){
            to_normalize= new ArrayList<>();
            t.run_test(s);
            sb2.append("1;");
            teste_results=t.print_test();
            values = teste_results.split(";");

            doubleValues = Arrays.stream(values)
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            Double[] doubleArray = ArrayUtils.toObject(doubleValues);
            to_normalize.addAll(Arrays.asList(doubleArray));

            to_normalize=n.normalize(to_normalize,l_means,l_deviations);
            sb2.append(normalized_values_to_string(to_normalize)+"\n");
            sb.append(normalized_values_to_string(to_normalize));
            sb.append(";2\n");
        }
        for(String s:b1){
            to_normalize= new ArrayList<>();
            t.run_test(s);
            sb2.append("2;");
            teste_results=t.print_test();
            values = teste_results.split(";");

            doubleValues = Arrays.stream(values)
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            Double[] doubleArray = ArrayUtils.toObject(doubleValues);
            to_normalize.addAll(Arrays.asList(doubleArray));

            to_normalize=n.normalize(to_normalize,l_means,l_deviations);
            sb2.append(normalized_values_to_string(to_normalize)+"\n");
            sb.append(normalized_values_to_string(to_normalize));
            sb.append(";3\n");
        }
        for(String s:b2){
            to_normalize= new ArrayList<>();
            t.run_test(s);
            sb2.append("3;");
            teste_results=t.print_test();
            values = teste_results.split(";");

            doubleValues = Arrays.stream(values)
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            Double[] doubleArray = ArrayUtils.toObject(doubleValues);
            to_normalize.addAll(Arrays.asList(doubleArray));

            to_normalize=n.normalize(to_normalize,l_means,l_deviations);
            sb2.append(normalized_values_to_string(to_normalize)+"\n");
            sb.append(normalized_values_to_string(to_normalize));
            sb.append(";4\n");
        }
        for(String s:c1){
            to_normalize= new ArrayList<>();
            t.run_test(s);
            sb2.append("4;");
            teste_results=t.print_test();
            values = teste_results.split(";");

            doubleValues = Arrays.stream(values)
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            Double[] doubleArray = ArrayUtils.toObject(doubleValues);
            to_normalize.addAll(Arrays.asList(doubleArray));

            to_normalize=n.normalize(to_normalize,l_means,l_deviations);
            sb2.append(normalized_values_to_string(to_normalize)+"\n");
            sb.append(normalized_values_to_string(to_normalize));
            sb.append(";5\n");
        }
        for(String s:c2){
            to_normalize= new ArrayList<>();
            t.run_test(s);
            sb2.append("5;");
            teste_results=t.print_test();
            values = teste_results.split(";");

            doubleValues = Arrays.stream(values)
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            Double[] doubleArray = ArrayUtils.toObject(doubleValues);
            to_normalize.addAll(Arrays.asList(doubleArray));

            to_normalize=n.normalize(to_normalize,l_means,l_deviations);
            sb2.append(normalized_values_to_string(to_normalize)+"\n");
            sb.append(normalized_values_to_string(to_normalize));
            sb.append(";6\n");
        }

        pw.write(sb.toString());
        pw.close();
        pw2.write(sb2.toString());
        pw2.close();
        System.out.println("done!");
    }

    private String normalized_values_to_string(ArrayList<Double> values){
        StringBuilder sb = new StringBuilder();
        for(double d:values){
            sb.append(d+";");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private void add_train_case(String ss,int nivel){
        //System.out.println(ss);
        String[] values = ss.split(";");
        //System.out.println(values.length);
        total_words.add(Double.parseDouble(values[0]));
        total_sentences.add(Double.parseDouble(values[1]));
        total_sylables.add(Double.parseDouble(values[2]));
        complex_words.add(Double.parseDouble(values[3]));
        letter_count.add(Double.parseDouble(values[4]));
        common_words.add(Double.parseDouble(values[5]));
        total_different_words.add(Double.parseDouble(values[6]));
        different_advanced_words.add(Double.parseDouble(values[7]));
        advanced_ttr.add(Double.parseDouble(values[8]));
        advanced_guiraud.add(Double.parseDouble(values[9]));
        ttr.add(Double.parseDouble(values[10]));
        rttr.add(Double.parseDouble(values[11]));
        cttr.add(Double.parseDouble(values[12]));
        h.add(Double.parseDouble(values[13]));
        s.add(Double.parseDouble(values[14]));
        mwf.add(Double.parseDouble(values[15]));
        r.add(Double.parseDouble(values[16]));
        bigram_perplexity.add(Double.parseDouble(values[17]));
        a1_words.add(Double.parseDouble(values[18]));
        a2_words.add(Double.parseDouble(values[19]));
        b1_words.add(Double.parseDouble(values[20]));
        b2_words.add(Double.parseDouble(values[21]));
        c1_words.add(Double.parseDouble(values[22]));
        c2_words.add(Double.parseDouble(values[23]));
        bigram_perplexity_reverse.add(Double.parseDouble(values[24]));
        simple_errors_per_word.add(Double.parseDouble(values[25]));
        comples_errors_per_word.add(Double.parseDouble(values[26]));
        lvl.add(nivel);
    }


    private void train_texts_normalized() throws IOException {
        Test t=new Test();
        List<String> texts=Arrays.asList();
        A1_Texts a1=new A1_Texts();
        texts=a1.get_texts();
        System.out.println("Total de textos de treino nível A1: "+texts.size());
        for(String s:texts){
            t.run_test(s);
            add_train_case(t.print_test(),1);
        }

        A2_Texts a2=new A2_Texts();
        texts=a2.get_texts();
        System.out.println("Total de textos de treino nível A2: "+texts.size());
        for(String s:texts){
            t.run_test(s);
            add_train_case(t.print_test(),2);

        }

        B1_Texts b1=new B1_Texts();
        texts=b1.get_texts();
        System.out.println("Total de textos de treino nível B1: "+texts.size());
        for(String s:texts){
            t.run_test(s);
            add_train_case(t.print_test(),3);

        }

        B2_Texts b2=new B2_Texts();
        texts=b2.get_texts();
        System.out.println("Total de textos de treino nível B2: "+texts.size());
        for(String s:texts){
            t.run_test(s);
            add_train_case(t.print_test(),4);
        }

        C1_Texts c1=new C1_Texts();
        texts=c1.get_texts();
        System.out.println("Total de textos de treino nível C1: "+texts.size());
        for(String s:texts){
            t.run_test(s);
            add_train_case(t.print_test(),5);
        }

        C2_Texts c2=new C2_Texts();
        texts=c2.get_texts();
        System.out.println("Total de textos de treino nível C2: "+texts.size());
        for(String s:texts){
            t.run_test(s);
            add_train_case(t.print_test(),6);
        }

        normalize_everything();

    }

    private void normalize_everything() {
        Normalize n= new Normalize();
        double mean=0;
        double deviation=0;
        //calculate the means and deviations
        mean=n.mean(total_words);
        deviation=n.deviation(total_words,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(total_sentences);
        deviation=n.deviation(total_sentences,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(total_sylables);
        deviation=n.deviation(total_sylables,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(complex_words);
        deviation=n.deviation(complex_words,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(letter_count);
        deviation=n.deviation(letter_count,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(common_words);
        deviation=n.deviation(common_words,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(total_different_words);
        deviation=n.deviation(total_different_words,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(different_advanced_words);
        deviation=n.deviation(different_advanced_words,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(advanced_ttr);
        deviation=n.deviation(advanced_ttr,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(advanced_guiraud);
        deviation=n.deviation(advanced_guiraud,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(ttr);
        deviation=n.deviation(ttr,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(rttr);
        deviation=n.deviation(rttr,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(cttr);
        deviation=n.deviation(cttr,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(h);
        deviation=n.deviation(h,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(s);
        deviation=n.deviation(s,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(mwf);
        deviation=n.deviation(mwf,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(r);
        deviation=n.deviation(r,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(bigram_perplexity);
        deviation=n.deviation(bigram_perplexity,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(a1_words);
        deviation=n.deviation(a1_words,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(a2_words);
        deviation=n.deviation(a2_words,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(b1_words);
        deviation=n.deviation(b1_words,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(b2_words);
        deviation=n.deviation(b2_words,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(c1_words);
        deviation=n.deviation(c1_words,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(c2_words);
        deviation=n.deviation(c2_words,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(bigram_perplexity_reverse);
        deviation=n.deviation(bigram_perplexity_reverse,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(simple_errors_per_word);
        deviation=n.deviation(simple_errors_per_word,mean);
        means.add(mean);
        deviations.add(deviation);

        mean=n.mean(comples_errors_per_word);
        deviation=n.deviation(comples_errors_per_word,mean);
        means.add(mean);
        deviations.add(deviation);

        System.out.println("MEANS");
        for(double d:means){
            System.out.println(d);
        }

        System.out.println("DEVIATIONS");
        for(double d:deviations){
            System.out.println(d);
        }
        System.out.println("ADD IN NORMALIZE CLASS");
    }


    public void how_many_texts_per_level(){
        List<String> texts=Arrays.asList();
        A1_Texts a1=new A1_Texts();
        texts=a1.get_texts();
        System.out.println("Total de textos de treino nível A1: "+texts.size());

        A2_Texts a2=new A2_Texts();
        texts=a2.get_texts();
        System.out.println("Total de textos de treino nível A2: "+texts.size());

        B1_Texts b1=new B1_Texts();
        texts=b1.get_texts();
        System.out.println("Total de textos de treino nível B1: "+texts.size());

        B2_Texts b2=new B2_Texts();
        texts=b2.get_texts();
        System.out.println("Total de textos de treino nível B2: "+texts.size());

        C1_Texts c1=new C1_Texts();
        texts=c1.get_texts();
        System.out.println("Total de textos de treino nível C1: "+texts.size());

        C2_Texts c2=new C2_Texts();
        texts=c2.get_texts();
        System.out.println("Total de textos de treino nível C2: "+texts.size());
    }

    public void test_texts() throws IOException {
        System.out.println("entrei aqui");
        Test t=new Test();
        System.out.println("iniciei test");
        PrintWriter pw = new PrintWriter(new File("test_results.csv"));
        PrintWriter pw2 = new PrintWriter(new File("test_results_neural_net.csv"));
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        //FILE FOR EVERYONE
        sb.append("total_words");
        sb.append(';');
        sb.append("total_sentences");
        sb.append(';');
        sb.append("total_syllables");
        sb.append(';');
        sb.append("complex_words");
        sb.append(';');
        sb.append("letter_count");
        sb.append(';');
        sb.append("common_words");
        sb.append(';');
        sb.append("total_different_words");
        sb.append(';');
        sb.append("different_advanced_words");
        sb.append(';');
        /*
        sb.append("flesch_reading_ease");
        sb.append(';');
        sb.append("flesch_kinkaid");
        sb.append(';');
        sb.append("gunning_fog");
        sb.append(';');
        sb.append("coleman_liau");
        sb.append(';');
        sb.append("smog_grade");
        sb.append(';');
        sb.append("automated_readibility_index");
        sb.append(';');
        sb.append("lexical_density");
        sb.append(';');
        sb.append("beyond_2000");
        sb.append(';');
        */
        sb.append("advanced_ttr");
        sb.append(';');
        sb.append("advanced_guiraud");
        sb.append(';');
        sb.append("ttr");
        sb.append(';');
        sb.append("rttr");
        sb.append(';');
        sb.append("cttr");
        sb.append(';');
        /*
        sb.append("m");
        sb.append(';');
        */
        sb.append("h");
        sb.append(';');
        sb.append("s");
        sb.append(';');
        /*
        sb.append("u");
        sb.append(';');
        */
        sb.append("mwf");
        sb.append(';');
        sb.append("r");
        sb.append(';');
        /*
        sb.append("bigram_model");
        sb.append(';');
        */
        sb.append("bigram_perplexety");
        sb.append(';');
        sb.append("a1_words");
        sb.append(';');
        sb.append("a2_words");
        sb.append(';');
        sb.append("b1_words");
        sb.append(';');
        sb.append("b2_words");
        sb.append(';');
        sb.append("c1_words");
        sb.append(';');
        sb.append("c2_words");
        sb.append(';');
        /*
        sb.append("bigram_model_reverse");
        sb.append(';');
        */
        sb.append("bigram_perplexety_reverse");
        sb.append(';');
        /*
        sb.append("words_per_sentence");
        sb.append(';');
        sb.append("sentences_per_paragraph");
        sb.append(';');
        */
        sb.append("simple_errors_per_word");
        sb.append(';');
        sb.append("complex_errors_per_word");
        sb.append(';');
        sb.append("level");
        sb.append('\n');

        //FILE FOR NEURAL NET
        sb2.append("level");
        sb2.append(';');
        sb2.append("total_words");
        sb2.append(';');
        sb2.append("total_sentences");
        sb2.append(';');
        sb2.append("total_syllables");
        sb2.append(';');
        sb2.append("complex_words");
        sb2.append(';');
        sb2.append("letter_count");
        sb2.append(';');
        sb2.append("common_words");
        sb2.append(';');
        sb2.append("total_different_words");
        sb2.append(';');
        sb2.append("different_advanced_words");
        sb2.append(';');
        /*
        sb2.append("flesch_reading_ease");
        sb2.append(';');
        sb2.append("flesch_kinkaid");
        sb2.append(';');
        sb2.append("gunning_fog");
        sb2.append(';');
        sb2.append("coleman_liau");
        sb2.append(';');
        sb2.append("smog_grade");
        sb2.append(';');
        sb2.append("automated_readibility_index");
        sb2.append(';');
        sb2.append("lexical_density");
        sb2.append(';');
        sb2.append("beyond_2000");
        sb2.append(';');
        */
        sb2.append("advanced_ttr");
        sb2.append(';');
        sb2.append("advanced_guiraud");
        sb2.append(';');
        sb2.append("ttr");
        sb2.append(';');
        sb2.append("rttr");
        sb2.append(';');
        sb2.append("cttr");
        sb2.append(';');
        /*
        sb2.append("m");
        sb2.append(';');
        */
        sb2.append("h");
        sb2.append(';');
        sb2.append("s");
        sb2.append(';');
        /*
        sb2.append("u");
        sb2.append(';');
        */
        sb2.append("mwf");
        sb2.append(';');
        sb2.append("r");
        sb2.append(';');
        /*
        sb2.append("bigram_model");
        sb2.append(';');
        */
        sb2.append("bigram_perplexety");
        sb2.append(';');
        sb2.append("a1_words");
        sb2.append(';');
        sb2.append("a2_words");
        sb2.append(';');
        sb2.append("b1_words");
        sb2.append(';');
        sb2.append("b2_words");
        sb2.append(';');
        sb2.append("c1_words");
        sb2.append(';');
        sb2.append("c2_words");
        sb2.append(';');
        /*
        sb2.append("bigram_model_reverse");
        sb2.append(';');
        */
        sb2.append("bigram_perplexety_reverse");
        sb2.append(';');
        /*
        sb2.append("words_per_sentence");
        sb2.append(';');
        sb2.append("sentences_per_paragraph");
        sb2.append(';');
        */
        sb2.append("simple_errors_per_word");
        sb2.append(';');
        sb2.append("complex_errors_per_word");
        sb2.append('\n');

        for(String s:a1){
            t.run_test(s);
            sb2.append("0;");
            sb2.append(t.print_test()+"\n");
            sb.append(t.print_test());
            sb.append(";1\n");
        }
        for(String s:a2){
            //System.out.println("New test");
            t.run_test(s);
            sb2.append("1;");
            sb2.append(t.print_test()+"\n");
            sb.append(t.print_test());
            sb.append(";2\n");
        }
        for(String s:b1){
            t.run_test(s);
            sb2.append("2;");
            sb2.append(t.print_test()+"\n");
            sb.append(t.print_test());
            sb.append(";3\n");
        }
        for(String s:b2){
            t.run_test(s);
            sb2.append("3;");
            sb2.append(t.print_test()+"\n");
            sb.append(t.print_test());
            sb.append(";4\n");
        }
        for(String s:c1){
            t.run_test(s);
            sb2.append("4;");
            sb2.append(t.print_test()+"\n");
            sb.append(t.print_test());
            sb.append(";5\n");
        }
        for(String s:c2){
            t.run_test(s);
            sb2.append("5;");
            sb2.append(t.print_test()+"\n");
            sb.append(t.print_test());
            sb.append(";6\n");
        }

        pw.write(sb.toString());
        pw.close();
        pw2.write(sb2.toString());
        pw2.close();
        System.out.println("done!");
    }

    public void train_texts() throws IOException {
        //System.out.println("entrei aqui");
        Test t=new Test();
        //System.out.println("iniciei test");
        PrintWriter pw = new PrintWriter(new File("train_results.csv"));
        PrintWriter pw2 = new PrintWriter(new File("train_results_neural_net.csv"));
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        //FILE FOR EVERYONE
        sb.append("total_words");
        sb.append(';');
        sb.append("total_sentences");
        sb.append(';');
        sb.append("total_syllables");
        sb.append(';');
        sb.append("complex_words");
        sb.append(';');
        sb.append("letter_count");
        sb.append(';');
        sb.append("common_words");
        sb.append(';');
        sb.append("total_different_words");
        sb.append(';');
        sb.append("different_advanced_words");
        sb.append(';');
        /*
        sb.append("flesch_reading_ease");
        sb.append(';');
        sb.append("flesch_kinkaid");
        sb.append(';');
        sb.append("gunning_fog");
        sb.append(';');
        sb.append("coleman_liau");
        sb.append(';');
        sb.append("smog_grade");
        sb.append(';');
        sb.append("automated_readibility_index");
        sb.append(';');
        sb.append("lexical_density");
        sb.append(';');
        sb.append("beyond_2000");
        sb.append(';');
        */
        sb.append("advanced_ttr");
        sb.append(';');
        sb.append("advanced_guiraud");
        sb.append(';');
        sb.append("ttr");
        sb.append(';');
        sb.append("rttr");
        sb.append(';');
        sb.append("cttr");
        sb.append(';');
        /*
        sb.append("m");
        sb.append(';');
        */
        sb.append("h");
        sb.append(';');
        sb.append("s");
        sb.append(';');
        /*
        sb.append("u");
        sb.append(';');
        */
        sb.append("mwf");
        sb.append(';');
        sb.append("r");
        sb.append(';');
        /*
        sb.append("bigram_model");
        sb.append(';');
        */
        sb.append("bigram_perplexety");
        sb.append(';');
        sb.append("a1_words");
        sb.append(';');
        sb.append("a2_words");
        sb.append(';');
        sb.append("b1_words");
        sb.append(';');
        sb.append("b2_words");
        sb.append(';');
        sb.append("c1_words");
        sb.append(';');
        sb.append("c2_words");
        sb.append(';');
        /*
        sb.append("bigram_model_reverse");
        sb.append(';');
        */
        sb.append("bigram_perplexety_reverse");
        sb.append(';');
        /*
        sb.append("words_per_sentence");
        sb.append(';');
        sb.append("sentences_per_paragraph");
        sb.append(';');
        */
        sb.append("simple_errors_per_word");
        sb.append(';');
        sb.append("complex_errors_per_word");
        sb.append(';');
        sb.append("level");
        sb.append('\n');

        //FILE FOR NEURAL NET
        sb2.append("level");
        sb2.append(';');
        sb2.append("total_words");
        sb2.append(';');
        sb2.append("total_sentences");
        sb2.append(';');
        sb2.append("total_syllables");
        sb2.append(';');
        sb2.append("complex_words");
        sb2.append(';');
        sb2.append("letter_count");
        sb2.append(';');
        sb2.append("common_words");
        sb2.append(';');
        sb2.append("total_different_words");
        sb2.append(';');
        sb2.append("different_advanced_words");
        sb2.append(';');
        /*
        sb2.append("flesch_reading_ease");
        sb2.append(';');
        sb2.append("flesch_kinkaid");
        sb2.append(';');
        sb2.append("gunning_fog");
        sb2.append(';');
        sb2.append("coleman_liau");
        sb2.append(';');
        sb2.append("smog_grade");
        sb2.append(';');
        sb2.append("automated_readibility_index");
        sb2.append(';');
        sb2.append("lexical_density");
        sb2.append(';');
        sb2.append("beyond_2000");
        sb2.append(';');
        */
        sb2.append("advanced_ttr");
        sb2.append(';');
        sb2.append("advanced_guiraud");
        sb2.append(';');
        sb2.append("ttr");
        sb2.append(';');
        sb2.append("rttr");
        sb2.append(';');
        sb2.append("cttr");
        sb2.append(';');
        /*
        sb2.append("m");
        sb2.append(';');
        */
        sb2.append("h");
        sb2.append(';');
        sb2.append("s");
        sb2.append(';');
        /*
        sb2.append("u");
        sb2.append(';');
        */
        sb2.append("mwf");
        sb2.append(';');
        sb2.append("r");
        sb2.append(';');
        /*
        sb2.append("bigram_model");
        sb2.append(';');
        */
        sb2.append("bigram_perplexety");
        sb2.append(';');
        sb2.append("a1_words");
        sb2.append(';');
        sb2.append("a2_words");
        sb2.append(';');
        sb2.append("b1_words");
        sb2.append(';');
        sb2.append("b2_words");
        sb2.append(';');
        sb2.append("c1_words");
        sb2.append(';');
        sb2.append("c2_words");
        sb2.append(';');
        /*
        sb2.append("bigram_model_reverse");
        sb2.append(';');
        */
        sb2.append("bigram_perplexety_reverse");
        sb2.append(';');
        /*
        sb2.append("words_per_sentence");
        sb2.append(';');
        sb2.append("sentences_per_paragraph");
        sb2.append(';');
        */
        sb2.append("simple_errors_per_word");
        sb2.append(';');
        sb2.append("complex_errors_per_word");
        sb2.append('\n');

        List<String> texts=Arrays.asList();
        A1_Texts a1=new A1_Texts();
        texts=a1.get_texts();
        System.out.println("Total de textos de treino nível A1: "+texts.size());
        for(String s:texts){
            t.run_test(s);
            sb2.append("0;");
            sb2.append(t.print_test()+"\n");
            sb.append(t.print_test());
            sb.append(";1\n");
        }

        A2_Texts a2=new A2_Texts();
        texts=a2.get_texts();
        System.out.println("Total de textos de treino nível A2: "+texts.size());
        for(String s:texts){
            //System.out.println("New test");
            t.run_test(s);
            sb2.append("1;");
            sb2.append(t.print_test()+"\n");
            sb.append(t.print_test());
            sb.append(";2\n");
        }

        B1_Texts b1=new B1_Texts();
        texts=b1.get_texts();
        System.out.println("Total de textos de treino nível B1: "+texts.size());
        for(String s:texts){
            t.run_test(s);
            sb2.append("2;");
            sb2.append(t.print_test()+"\n");
            sb.append(t.print_test());
            sb.append(";3\n");
        }

        B2_Texts b2=new B2_Texts();
        texts=b2.get_texts();
        System.out.println("Total de textos de treino nível B2: "+texts.size());
        for(String s:texts){
            t.run_test(s);
            sb2.append("3;");
            sb2.append(t.print_test()+"\n");
            sb.append(t.print_test());
            sb.append(";4\n");
        }

        C1_Texts c1=new C1_Texts();
        texts=c1.get_texts();
        System.out.println("Total de textos de treino nível C1: "+texts.size());
        for(String s:texts){
            t.run_test(s);
            sb2.append("4;");
            sb2.append(t.print_test()+"\n");
            sb.append(t.print_test());
            sb.append(";5\n");
        }

        C2_Texts c2=new C2_Texts();
        texts=c2.get_texts();
        System.out.println("Total de textos de treino nível C2: "+texts.size());
        for(String s:texts){
            t.run_test(s);
            sb2.append("5;");
            sb2.append(t.print_test()+"\n");
            sb.append(t.print_test());
            sb.append(";6\n");
        }

        pw.write(sb.toString());
        pw.close();
        pw2.write(sb2.toString());
        pw2.close();
        System.out.println("done!");
    }

    public void train_texts_removal(){
        A1_Texts a1=new A1_Texts();
        A2_Texts a2=new A2_Texts();
        B1_Texts b1=new B1_Texts();
        B2_Texts b2=new B2_Texts();
        C1_Texts c1=new C1_Texts();
        C2_Texts c2=new C2_Texts();
        List<String> texts=Arrays.asList();
        texts=a1.get_texts();
        /*System.out.println("A1 Texts");
        System.out.println(texts.get(97));
        System.out.println();
        System.out.println(texts.get(9));
        System.out.println();
        System.out.println(texts.get(6));
        System.out.println();
        System.out.println(texts.get(58));
        System.out.println();
        System.out.println(texts.get(109));
        System.out.println();
        System.out.println(texts.get(88));
        System.out.println();
        System.out.println(texts.get(70));
        System.out.println();
        System.out.println(texts.get(98));
        System.out.println();
        System.out.println(texts.get(101));
        System.out.println();
        System.out.println(texts.get(75));
        System.out.println("\n\n");*/
        texts=a2.get_texts();
        System.out.println("A2 Texts");
        System.out.println(texts.get(97));
        System.out.println();
        System.out.println(texts.get(9));
        System.out.println();
        System.out.println(texts.get(6));
        System.out.println();
        System.out.println(texts.get(58));
        System.out.println();
        System.out.println(texts.get(109));
        System.out.println();
        System.out.println(texts.get(88));
        System.out.println();
        System.out.println(texts.get(70));
        System.out.println();
        System.out.println(texts.get(98));
        System.out.println();
        System.out.println(texts.get(101));
        System.out.println();
        System.out.println(texts.get(75));
        System.out.println("\n\n");
        texts=b1.get_texts();
        System.out.println("B1 Texts");
        System.out.println(texts.get(97));
        System.out.println();
        System.out.println(texts.get(9));
        System.out.println();
        System.out.println(texts.get(6));
        System.out.println();
        System.out.println(texts.get(58));
        System.out.println();
        System.out.println(texts.get(109));
        System.out.println();
        System.out.println(texts.get(88));
        System.out.println();
        System.out.println(texts.get(70));
        System.out.println();
        System.out.println(texts.get(98));
        System.out.println();
        System.out.println(texts.get(101));
        System.out.println();
        System.out.println(texts.get(75));
        System.out.println("\n\n");
        texts=b2.get_texts();
        System.out.println("B2 Texts");
        System.out.println(texts.get(97));
        System.out.println();
        System.out.println(texts.get(9));
        System.out.println();
        System.out.println(texts.get(6));
        System.out.println();
        System.out.println(texts.get(58));
        System.out.println();
        System.out.println(texts.get(109));
        System.out.println();
        System.out.println(texts.get(88));
        System.out.println();
        System.out.println(texts.get(70));
        System.out.println();
        System.out.println(texts.get(98));
        System.out.println();
        System.out.println(texts.get(101));
        System.out.println();
        System.out.println(texts.get(75));
        System.out.println("\n\n");
        texts=c1.get_texts();
        System.out.println("C1 Texts");
        System.out.println(texts.get(97));
        System.out.println();
        System.out.println(texts.get(9));
        System.out.println();
        System.out.println(texts.get(6));
        System.out.println();
        System.out.println(texts.get(58));
        System.out.println();
        System.out.println(texts.get(109));
        System.out.println();
        System.out.println(texts.get(88));
        System.out.println();
        System.out.println(texts.get(70));
        System.out.println();
        System.out.println(texts.get(98));
        System.out.println();
        System.out.println(texts.get(101));
        System.out.println();
        System.out.println(texts.get(75));
        System.out.println("\n\n");
        texts=c2.get_texts();
        System.out.println("C2 Texts");
        System.out.println(texts.get(97));
        System.out.println();
        System.out.println(texts.get(9));
        System.out.println();
        System.out.println(texts.get(6));
        System.out.println();
        System.out.println(texts.get(58));
        System.out.println();
        System.out.println(texts.get(109));
        System.out.println();
        System.out.println(texts.get(88));
        System.out.println();
        System.out.println(texts.get(70));
        System.out.println();
        System.out.println(texts.get(98));
        System.out.println();
        System.out.println(texts.get(101));
        System.out.println();
        System.out.println(texts.get(75));
        System.out.println("\n\n");
    }



    private List<String> a1= Arrays.asList("Bob is still the strongest." +
            " The reason he had so much \"trouble\" stopping the train was to not stop it instantly and kill " +
            "everyone inside by sheer momentum. Him stopping it cold would be just as bad as allowing it to " +
            "fall off the edge.","Good answer. I don't invest in art but I have a friend (an aspiring artist) " +
            "who advises art investors. He knows the art scene, the trends and the local young artists so he " +
            "has educated guesses on where to invest.","My argument is that painting is a much smaller skill difference between a hobbyist and a mediocre professional.\n" +
            "Actually good software engineering is a much larger skill difference.","You can’t disparaging a communist " +
            "regime with a more than questionable human rights record if you throttle the video platform that" +
            " people use to voice their opinions.","Hmm, so you're saying that EA is delaying the game release date " +
            "and invest resources to make it better. Does that means that if it wasn't due to the backlash they received they would have give us an unfinished and buggy game?","also when stopping the train, there was lots of slippage, he couldnt stop it using all of his force because ultimately that force made him break through the ground, he didnt have a solid support to press against.","Oh wow Jessica Nigri is on the show, Ive had so many fantasis it would be a dream come tru if I ever actually got to touch Gus.","WTF Youtube, stop forcing me to watch this video, i dont know how many " +
            "times, even if im in incognito, whenever i listen to music, there's a time in where i end up in this " +
            "video. STOP it please.","The Invisible Woman is the most powerful member of the Fantastic Four so I expect Violet to get stronger. But Jack Jack has the potential to be the strongest.","Yeah YouTube will keep doing it's thing that's why " +
            "I started reloading my Twitch account. So if YouTube does something I can't accept I will leave " +
            "without hesitation.");

    private List<String> a2= Arrays.asList("my biggest pet peeve is the misconception of cheetah's being speed gods. I love cheetahs, but god damn people don't understand just how much they give up for their speed. They cant just sprint and sprint and sprint. They have to rest a good bit after a chase, and if they don't get anything after it then they're in trouble.","I'm completely deaf in my right ear and I " +
            "was so completely mortified with Shoko's treatment that I was sobbing and couldn't get past the " +
            "first half hour. I related so much to her struggles and to see people treat her like garbage was" +
            " just the worst feeling.","To the writers, Brian and Eddy: Goodness, you guys do a great job of hooking sympathy to those certain groups, then explaining how their view could be wrong in the friendliest way possible. Congrats on the writing.","Watched the video on the page demoing the falcon heavy concept. The real pictures don’t have the water tower at the launch site like the concept video. Is there some reason the water tower was in the demo design but not the real thing ... — maybe the water tower is mobile and only in place during an actual launch? Or is this closer to a case where somebody thought the water tower would look cool so they put it in the demo video ...?","I didn't think they would finish that backwash spit beer at the very end, but they took it all down like real champs! Well done.\n" +
            "New challenge: Make a straw chain long enough to extend from one building to the next and have a" +
            " camera follow it all the way from the beer to someone's mouth.","I'm 58 and my daughter is 26. And while I admire how fast she's making a career with IBM after finishing University, I'm concerned about her emotional skills that seem to have become a lot worse than they were.\n" +
            "I'd never dare to bash a generation.\n" +
            "Well, maybe except those that are around 40 now. That generation seems to have a lot more egoism" +
            " and use their elbows a lot more to succeed then those before and after.","I think that the state can do that, yes. It can't say \"you have to do this to do business in our state\", but it can say \"you have to do this to do business with us, the state government\".\n" +
            "The alternative is that the federal government can dictate which businesses the state " +
            "governments do business with, which is, to put it mildly, probably not a valid use of federal " +
            "power.","Bears go for the brood in bee hives, not honey.\n" +
            "Cats lose ability to digest milk through age.\n" +
            "Elephants can't drink through their trunks.\n" +
            "Rabbits struggle to digest carrots.\n" +
            "Birds shouldn't be fed bread.\n" +
            "Ostriches don't bury their head in the ground when scared.\n" +
            "Porcupines can't launch their quills.\n" +
            "Bats are not all that blind and some can even see better than humans.\n","The rabbit thing completely blew my mind! I figured that if that was a misconception it would have to be an incredibly old one, but no, Bugs Bunny and dated pop culture references! Makes you think twice about making that super-relevant Geostorm joke now, huh?","I actually felt that the violence was not nearly as bad as some live action tv shows. But for anime I do get what everyone is saying. I loved how raw and rough the style was and yet it was so beautiful animated. It seemed to only add to the story and air of the series. I didn't fined it sexually arousing in most if any of the \"sexy\" scenes. But  rather was taken in by the madness and amazement of it all. I loved the story and had gone in mostly blind to it all. And that made it so much fun to watch for me.");

    private List<String> b1= Arrays.asList("The true programmer-artisan (often called 10xer, guru, ninja, whatever) builds systems that cause money to flow into bank accounts to the tune of 6, 7, 8 figures. Yet if this person wants a raise, they will never be able to get one. They will have to change companies and abandon their code. What do you think a software industry looks like that's full of abandoned code? Much like it does now.\n" +
            "On top of that, there are well known cases of illegal wage suppression.\n" +
            "I was once told by a recruiter that \"industry standard\" was to only expect a 5% raise with a new job. " +
            "But I once tripled my salary in a single job offer, no lie.","The experience from a few months ago during a conference showed me that education won't fix echo chambers.\n" +
            "It was a conference that was organized by a organization that holds one of the major initiative against false news, and where one of the main tracks was about addressing the issue of false news. Last year they had a massive booth at the middle of the conference hall about false news. This year they brought in a key note speaker which brought several political slides while making misleading conclusions that was later proven to be false, but the whole thing echoed with the audience. It seemed to not matter a bit that it also just happened to be false.\n" +
            "When facts get in the way of a political message, even the most educated seems to let the facts go if " +
            "its align with their own views. I wish education would work, but I don't see it as a proven method to " +
            "solve echo chambers or political news.","I agree strongly with your first point, for the simple reason of “unknown unknowns.” Maximizing the optimization of your current situation, so to speak, can often result in missing out on opportunities which would bring you to a higher, better level than the one you are on currently.\n" +
            "Extreme focus and hours can be effective in short bursts, but need to be balanced with some time for " +
            "randomness, wandering, and other non-planned activities. One should always be trying to expand their current intellectual domain, but it’s nigh impossible to do so if you keep your head down 24/7.","Unfortunately it's a different ballgame with warehouse work like at AMZ. There is no customer facing service aspect, and very little quality difference between employees. What quality concerns there are can probably be traced back to an individual employee very easily; returns due to poor packaging or wrong item can easily be pinned on the culprit.\n" +
            "It's unfortunate, but not all manual/hard jobs are valued equally and often because they are simply not of equal value. Item pickers are going to eventually go the way of cotton pickers in developed countries. One of my best friends works for a startup developing AI controlled robotic pickers. There is a ways to go and it'll start with human augmented AI's but eventually AI's will be picking, sorting, and packing everything.","I don't know much about quantum computation, but David Deutsch does say something along those lines. In particular, that the superiority of quantum computation for certain problems is explained by computation taking place in multiple universes.\n" +
            "He also rejects the idea that there's something ineffable about quantum mechanics, or that the reason quantum computation works can't be explained using ordinary logic and reasoning that is accessible in principle to everybody (I don't know for sure that's what is meant here by \"somehow creates a “resource”\": but I'm triggered a bit by those words because people often do essentially mean that).\n" +
            "Of course he would (correctly) say that one shouldn't treat him as being an infallible source of truth " +
            "on the matter. But he does believe that the purpose of science is to explain the world, which puts him in a different class from apologists for quantum mysticism, strict empiricism and other believers in explanation-free knowledge.","I'm the editor (Stephen Cass). I really should have added \"independent\" to \"similar\" in my response there, but oh well ;). Anyhoo instead of emailing me, you can just let me know here if this thread has inspired you to want to see a longer version!\n" +
            "We're unlikely to just drop the raw footage (for the same reasons that journalists very rarely publish " +
            "scans of the notes they take during interview, or the raw audio of any recordings, because part of our " +
            "whole raison d'etre is editing things), but as I indicated, if there's enough interest to justify the resources, I could argue for a longer cut.","Egan’s Proustian meditation on time, fame and music" +
            " won the National Book Critics Circle and Pulitzer awards. Who’s the goon of the title? “Time is the " +
            "stealth goon, the one you ignore because you are so busy worrying about the goons right in front of you," +
            "” she says. Egan concocts her narrative around punk rocker-turned-music producer Bennie Salazar, his sticky-fingered assistant Sasha and a circle of wannabes, has-beens and hangers-on. Colette Bancroft, book editor of The Tampa Bay Times, named Egan’s novel her top pick “not just because it is a splendidly written experiment in form that succeeds resoundingly, but because the 21st Century is its essential subject matter. Egan juxtaposes timeless literary themes, most notably the inexorable journey from youth to age, with an exploration of the ways in which a rapidly changing world reshapes the human experience. It's a novel that is prescient, surprising, wise and simply a blast to read.”\n","House opens his espionage saga, a quartet of tightly linked novels, with a mysterious command: “Listen. There’s a problem and it can’t be solved. You need to disappear.” The order comes from a top executive for a US military contractor that runs ‘burn pits’ in Iraq to incinerate excess weapons of war. The man known as Sutler, a newly hired mid-level operative, is soon on the run, blamed for embezzling a vast sum. He leaves behind a team of civilian workers, lured with the promise of decent jobs and benefits, who are all sickened by the toxic smoke that surrounds them every day and who, plan to exact revenge. Meanwhile Sutler’s exit path, plays out across Iraq, Istanbul, Italy and Cyprus. House draws inspiration from Roberto Bolanoand and Émile Zola, but this chilling post-9/11 masterpiece is all his own.","Good documentarians get to know their subjects, of course, but it’s easy to imagine Ross on the other side of the lens, a subject in another inquisitive, empathetic mind’s documentary about the ebb and flow of life in Hale County, Alabama. He understands the area and its inhabitants because he’s one of them, which is to say he understands his subjects in ways most documentary filmmakers will envy. “Hale County This Morning, This Evening” pulses with that hyper-specific familiarity, capturing in just an hour and sixteen minutes the passage of years through both long static takes and fleeting, blink-and-you’ll-miss-it moments of profound mundanity. Sweat drips from a young man identifiable only by his feet, dribbling to the concrete in lockstep with the basketball in his hands; Ross then cuts to stone pavers as they’re splashed by a rainstorm.","Why do you feel that they are not being paid what they are worth?\n" +
            "Because they perceive that there are other people in their organizations making far more money, who don't contribute much value.. or at least certainly not 2x, 3x, 4x, 10x, whatever, more value.\n" +
            "Whether that is actually the case or not is tough to say, exactly because it's tough to directly measure" +
            " the value created by an individual developer (in most cases).","I'm in industry, but have similar leanings of wanting to work on this stuff. For a few years I was convinced academia was the way to do this; now I'm not certain. It's as if the collective capacity of dreaming about the possibilities of computing was lost when we realized we could make lots of money. Instead of building bicycles for the mind, we're obsessed with building TV 2.0, and getting lots of money doing it. Nowadays I see my meager, fledgling research as art pretty much.\n" +
            "I don't know where I'll end up long-term, but I doubt I'm the only person that feels this way. I've " +
            "occasionally thought of starting a Slack for this sort of thing.","Not fixing, making, currently there is nothing to fix as WE HAVEN'T PLAYED ANYTHING YET, stupid title, also delay is likely however take it with a pinch of salt. Maybe if they are putting all the human resources onto one game, they made a fake rumor about a delay just for safety measures so people don't get disappointed with an unexpected delay and give the studio extra breathing room so they don't have to be pressured for time and instead of looking for shortcuts they are focusing on a great game, so it could come in q3-q4 of 2018 as originally planned. EA might just be thinking of a way to buy extra time if its needed. Also you gotta remember that EA's fiscal year for earnings ends in March, which means they will have to release the game at least one month to two months early to get the full earning results to really make their investors happy, as we all know day 1 purchases can be huge flukes. So i would expect December or January which seem way more likely then March.");

    private List<String> b2= Arrays.asList("well, they are kinda brainwashed into thinking they are all so special (forgetting that's nice but so is fungi) and full of opinions (forgetting it's nice but if they have no clue what they are talking about it's not relevant) and the ones we are laughing about are the \"special s\" with big ego, no ethics and parroting slogans empty phrases from their echo chambers and trying to blame everything around for anything that goes wrong. There is percentage of guys and girls in that generation that are nice, rational and prefer to know rather jump on the belief wagon ... but they are bashed and abused into oblivion by the type which is called \"millennial\". All youngsters (primates and other mamals) are all over the show to certain degree (lot to prove and full of hormones). Laughing about it and making fun of behavior that is detrimental is a way how to send a message \"this behavior is not ok\" - it's far better than pretend it's ok and ignore it. If there will be sufficient pressure they will grow out of it and then they will help the next generation to straighten up and mature.","There's also something to the notion that we want our regulatory bodies and government agencies to be slightly 'conservative', to avoid waste and avoid short-term folly. Our public institutions should live for generations, and have transparency and ethical demands placed upon them by the citizenry.\n" +
            "We could collectively decide to eliminate a lot of red tape in government, no problem. It's just the " +
            "effect of unchecked, unsupervised, unaccountable governments that make us want that red tape in the first place. Todays Justification Paperwork is yesterdays front-page scandal...","There is also another effect, which I call recursive over-valuation.\n" +
            "The \"high-end\" art collectors tend to be extremely wealthy, and - with of course some exceptions - wealthy people are wealthy also because they care about money.\n" +
            "So, imagine that you are a wealthy art collector and you have just paid - let's say - 100,000 US$ for a painting by an \"emerging\" artist.\n" +
            "It is only human to show off your new painting, and the people you frequent are likely to be also wealthy and art collectors.\n" +
            "So, if you have a name as an art collector, that painting soon becomes in your elite a \"set point\" for the value of the new artist work.\n" +
            "The year later, a gallerist that is selling at 115,000 US$ another similar painting of the same artists can well say \"Last year TheOtherHobbes bought a similar one for US$ 100,000, and you know him, he wouldn't pay that kind of money if it hadn't this value\".\n" +
            "And this sets a second precedent, and it goes on.\n" +
            "BTW it is all in your interest to \"defend\" and \"promote\" the artist (because you defend your investment into it) even if the painting is awful.\n" +
            "In a couple of years this way you will be able to re-sell the painting for - still say - US$ 200,000 " +
            "while having - besides the profit - reinforced your fame as good investor and educated art expert, capable to see the potentiality of the artist ahead of all others...","Baumol predicted this 50 years ago; it's called the \"cost disease\".\n" +
            "The inflation rate for a computer with a fixed set of specs is massively negative -- it gets cheaper every year. So it is for many technological devices.\n" +
            "But our whole economy is a mixture of technological stuff (that drops in cost over time, i.e. negative inflation) and non-technological stuff (burritos and health care).\n" +
            "The overall inflation rate is an average across the entire economy. Even if you believe the reporting is not distorted (which is dubious), then the fact that there are so many goods whose prices drop quickly over time, implies that there have to be many goods and services whose prices go up much faster than \"inflation\" would predict. Because something has to balance that average!\n" +
            "Baumol calls the technological stuff the \"progressive sector\" and the non-technological stuff the \"stagnant sector\". As time goes on, prices in the stagnant sector continue to rise until they consume almost all spending.\n" +
            "Baumol made specific predictions based on this model in 1960 that have turned out to be consistently true for 50 years (\"the cost of healthcare will continue to rise to degrees that will seem scary\" and so forth).\n" +
            "Furthermore, it's not like it is some weird complicated or hard-to-substantiate theory. It is just math, not much more complicated than the definition of the average. Given how big the consequences are, and how hard to argue with, it surprises me that this idea occupies so little of the public conversation.","For sensor data analytics, you are frequently using many orthogonal sensor data sources to measure the same thing, precisely so that you can remove source bias. And most non-trivial sensor analytics are not statistical aggregates but graph reconstructions, the latter being greatly helped by having as much data as you can get your hands on.\n" +
            "The \"let's store everything\" isn't being done for fun; it is rather expensive. For sophisticated sensor analytics though, it is essentially table stakes. There are data models where it is difficult to get reliable insights with less than a 100 trillion records. (Tangent: you can start to see the limit of 64-bit integers on the far horizon, same way it was with 32-bit integers decades ago.)\n" +
            "I worked at a place that monitored power usage minute by minute across 1000s of locations. We just used MySQL with a time column. Maybe I'm not the target audience but I'm failing to see what this gets me.\n" +
            "The problem is they say the data is imuatable and stored sequentially, allthough our data was imutable with devices on the net the data comes in random order when these ineviatably have connection problems.\n" +
            "We always aggregated our data into larger time blocks. Storage was cheap and doing comparative analysis across locations and time zones was always our pain point.\n" +
            "I think using a Postgres database is wise.\n" +
            "The article recognizes that several time series databases already exist. They also say, \"we aren't trying to compete against kdb+.\" They explain how they can handle time series data better than NoSQL databases that aren't time series focused.\n" +
            "But what are they doing better than the existing time series databases? Surely they must have some " +
            "advantage or they wouldn't have raised 16.1 million dollars.","Along with a renewed appetite – he lays waste to the buffet each day, as the other guests look on in awe – Mike discovers a spiritual gift. He coaxes an anorexic girl into eating; cures the head injury of a coconut picker and enjoys the sexual opportunities that his new magnetism affords.\n" +
            "The octopus assures Mike that their destinies are now linked, but it seems that the hotel is equally tied to Mike’s well-being. A diabetic who has run out of medicine, as Mike’s condition starts to deteriorate so does that of the increasingly down-at-heel resort. A film of mould covers everything; the buffet is depleted and decaying, graffiti is daubed over the hotel shuttle bus.\n" +
            "The film’s meaning is deliberately opaque. The ‘change of management’ of which the hotel staff talk in hushed tones could refer to a military coup. Equally Mike, with his insatiable appetite and oblivious sense of entitlement, could represent the forces of consumerism which plunder poorer countries. Or it could just be about a plus-sized gentleman who is given magical powers by a cephalopod. While Lagarde’s message is elusive, his talent for crafting arresting and macabre visual imagery is undeniable.\n","In Amman, Jordan, last week, a class of students — half of them refugees — began a one-year course of study in computer science and entrepreneurship, designed by MIT. The program will earn them a certificate that, along with internships with local companies throughout the program, could help them advance to better-paying positions in the region.\n" +
            "The new program, launched during a Solve competition at MIT, is called the Refugee Action (ReACT) Certificate Program. Run by Executive Director Robert Fadel, who previously worked for the One Laptop Per Child project (also an MIT spinoff), the program begins with an intensive two-week session of in-person lectures in innovation, design, and entrepreneurship, led by MIT faculty members and students.\n" +
            "The 18 members of the initial class will then spend the remainder of the program taking a series of online classes through MITx and working about 20 hours per week as interns with companies in the region. The project, Fadel says, will “bring an MIT-caliber education to refugees and other displaced populations, where they live.”","Anyone know where to find the full length interview? This is just a clip.\n" +
            "\"We thought computing would be artisanal. We did not imagine great monopolies.\"\n" +
            "In a sense, it still is, and always will be. I feel that the core of programming, just making the " +
            "computer do things other people want it to for money, will always lead us back to a highly individualized workflow, where a single programmer has complete mastery over the system. It's just that the programmer-artisan must find work in the context of these great, monopolistic organizations, which inevitably apply pressure to reduce the amount of skilled labor required to perform a given business function, and thereby increase the organization's leverage in salary negotiations, leading to hyper-specialized assembly line processes that eventually just stop working because no one has the broad systems-level knowledge required to trace a bug to its source anymore. It would be great if these monopolies could just accept the artisanal nature of software development and pay people what they're worth.","Yes, they're idealised versions, but that still has value. The point at which the idealised model doesn't match up with reality is the point at which further investigation is required.\n" +
            "It's an effective way of filtering out the parts of the system that you already have a reasonable grasp on so that you can focus on parts that you don't.\n" +
            "On a more general point, almost all models are idealised approximations. The whole idea with modelling a system is to abstract away the rough edges by encapsulating complex behaviour in discrete groups. By working with these simplified models, the idea is that you gain a better intuition of the activity found within a system.\n" +
            "In short, the whole purpose of models is to guide intuition.","There was an economic downside. With the troops’ victorious return, many women found themselves surplus to requirements at work. The 1919 Restoration of Pre-War Practices Act forced most women to leave their wartime roles as men came home and factories switched to peacetime production.\n" +
            "For some, the clock was turned back, ushering in a time of economic hardship and low expectation at home, where women found themselves grieving or caring for injured male relatives or husbands.\n" +
            "Despite their pioneering contribution, thousands of women were dismissed from their jobs, particularly in engineering; those who objected to standing aside were met with public anger. And old ways reasserted themselves, as newly unemployed women war workers were pressured into becoming domestic servants.\n");

    private List<String> c1= Arrays.asList("I think that this kind of advice can be detrimental to people like me. It basically says force yourself to study 5 hours a day no exceptions. If you get a job or other extracurricular activities don't count it as work time.\n" +
            "Well, I lived that lifestyle in high school. I studied 4 hours a day, limited every extracurricular activities to not interfer with my study time. At the end I believe I have missed a great portion of my life and it was not worth it.\n" +
            "Studying everyday is a great goal to aspire for, but no way you need to study that much every day. Go to classes with the textbook, mark the areas the teacher lectures about. Take notes during class. Once in a while review the book and your notes. In the meantime make thought experiments, try to apply the information you learned on imagined cases you made up for fun.\n" +
            "There is only so much willpower you can tap into. Once that is over you basically drift not being able to do anything. It is much better to live a balanced life and never put yourself into impossible workloads for a prolonged time.\n" +
            "Another point is that these kind of study hacks work for people who can already study. If you are a procrastinator in soul (a deep procrastinator in Newport's terms), this advice won't help you. If you're procrastinating heavily your mind is trying to tell you that what you're doing is pointless.\n" +
            "One powerful weapon to fight it is to keep an agenda. Plan your day before (for example using org mode or a simple paper agenda). Set very small goals and always reschedule if you need to. For example 22 Jan Monday: place the notes taken during X class in a file. 23 Jan Monday: Buy the book required for Y class etc.\n" +
            "If you can keep your study material somewhat organized, you will find it much easier to begin studying. It is all about tooling like programming.\n" +
            "One last note: studying in a silent place does not always work. Especially when I'm bored, can't start " +
            "studying or mentally overwhelmed, it helps a lot to put on headphones and blast some talkshow in the background. The change in the tone and volume of the host and occasional jokes and laughter feed my stimuli seeking brain. After 30-40 minutes I can continue without listening anything.","I get the point you're trying to make, but to me this just reads like gatekeeping.\n" +
            "Cell phones are useful and they can make people safer. In a world with cell phones not having timely access to one is riskier. In a world without cell phones it's a moot point.\n" +
            "The more interesting issue -- which others in this thread are discussing -- is whether the benefits of having a cell phone outweigh the harms people can cause with them, and whether policy can help strike an appropriate balance.\n" +
            "I'd argue it's more comfort that you can be reached or reach someone than actual safety. But I don't really disagree with your broader point. This system doesn't seem very practical for a whole range of issues.\n" +
            "Plenty of other live events have policies against recording and cell phone use and don't seem to have any serious problems enforcing those policies (or, indeed, need to do much \"enforcement\" at all). Perhaps rock concerts are different because of the type of crowd.\n" +
            "I was being curmudgeonly.\n" +
            "Sure, cell phones can contribute to personal safety; whether it actually does in a standing-room-only rock concert given the distribution of risks one is likely to encounter in that context is another matter. I have a hard time imagining one, except a medical emergency, maybe? Except that having people find security might truly be more expedient.\n" +
            "Besides, I cam imagine real harm. Everyone simultaneously receiving a false alarm that a ballistic missile is headed there way might actually cause Widespread Panic to come out and play an encore.\n" +
            "Here in Japan, most concerts have a strict no-photos policy. In smaller venues, I've seen this enforced " +
            "by guards shining bright focused flashlights at you if you try to take a photo/video. Seems to work well. Some artists stop to do a \"ok let's all take a photo together now\" bit near the end for those who want a memory.","Dear Sir / Madam , \n" +
            "I read your advertisement in Students International and I would be very interested in volunteering in the sporting event you are organising . I am a French student and I have been studying English for eight years . I have taken part in several language exchange visits to the United Kingdom , so I can communicate confidently and quite fluently in English in social situations . I also speak a little Italian and German . \n" +
            "I believe that I have good personal qualities which make me an effective volunteer for your event . I am outgoing and enjoy meeting people from different cultures . I have played in the college volleyball and football teams for over four years , so I am used to working with other people and encouraging them in our shared endeavours . I also have work experience in working on the front line with customers . I work at weekends in our local supermarket , which requires me to deal with customers with a pleasant attitude and liaise with other staff . I have also worked as a receptionist in a hotel in the south of France as a summer job . Here , I had to welcome guests and deal with any problems which arose . I can send you references from these employers if you need them.\n" +
            "Thank you for your interest in my application . I look forward to hearing from you .\n","One of the main objectives of education is to prepare children for work . In order to help a country grow economically , schools are encouraging students to study science , economics , computer skills , business and maths . Creative subjects like art and music are considered less important . However , I believe that they should continue to be taught in schools.\n" +
            "Music courses often include several different strands . At my school , the music course includes performance , music theory and composition . Each of these areas teaches a child different skills . Performing teaches children confidence . Music theory teaches analytical and mathematical skills . Composition allows students to be creative . Although it is true that many students who are interested in music take classes outside school , many young people do not have this opportunity because their parents aren’t musical . That’s why we need to continue to provide music lessons at schools.\n" +
            "Another creative subject under scrutiny is art . But art is everywhere in our society . It is in the clothes we wear and in the design of the products we buy . School art students go on to become illustrators, designers and architects . Also , creative people are often successful in other fields such as teaching and business . We need to encourage young people to think creatively and school art lessons are important in this way.\n" +
            "To conclude , I think it is very important that schools continue to teach creative subjects such as art and music as well as those subjects that are considered more important for the country’s economy . Not all young people get the opportunity to explore their creative sides out of school , and confident , creative people are equally important to a country’s economy as economists and scientists .\n","These have been around forever, I grew up in NJ and a friend's father was a cop so he had one. Definitely a corrupt thing that should be eliminated. A few dynamics I remember:\n" +
            "- many cops saw PBA cards as corrupt and insulting. So the rule of thumb was you never offered these, you just let the card be visible when reaching for your license. If the cop was in on it they'd then ask you about where you got the card. It was a huge no-no to offer it not just because some cops didn't take it but because even those who would could probably be offended by you not deferring to their authority to decide to ask about it (ie offer to give you a pass) or for being entitled. The net dynamic you wanted was the cop to of his own volition see the card and decide if he wanted to cut you a break since he knew you were connected to the police somehow. (Ie, total corrupt dynamic)\n" +
            "- a big variable was if they took the card or let you keep it. If you were a son or daughter of a cop you probably never got it taken. Otherwise you'd get it taken if you would have otherwise gotten a ticket. If you were just being pulled over for no good reason they'd probably not take the card from you so you could \"use\" it again.\n" +
            "- these were not gonna get you out of trouble if you did something more than speeding, talking on a cell, etc. If you ran a light or stop sign it was borderline. If you committed a felony or were drunk etc then flashing your PBA card probably would have made your life worse.","Good. I do this at my personal parties, I have a phone bowl by the door. Few arguments are solved by Google, and creative things happen.\n" +
            "Social Media is definitely at the point where TV was in around 2012. There were the early 'adopters' who cast out their sets and proclaimed the virtues, but they weren't shunned and understanding was attempted... what's a DVR? what's streaming? Silly questions a few years later, right.\n" +
            "Cell phones are wonderful, apps are useful, don't get me wrong. So is self awareness and presence. It's a huge waste of effort to go to a party/concert just to use a device for non-urgent activity. I used to be on PagerDuty for 7on/7off and I forewent my normal life during those days to ensure I could respond. Sometimes I'd go to a bar with my backpack and sip with coworkers/acquaintances, but it obviously disturbed the vibe not keeping up so eventually I stopped.\n" +
            "I wouldn't go to a concert if I had urgent stuff that could happen. Family emergency? Shit, we'll we've " +
            "managed until now, life happens. The external cost to social skills and ambiance are so great, as we can all observe, that that one act of nature edge case isn't worth the external costs (we can agree to disagree).","Most neuromorphic chip designs attempt to emulate the synaptic connection between neurons using two conductive layers separated by a “switching medium,” or synapse-like space. When a voltage is applied, ions should move in the switching medium to create conductive filaments, similarly to how the “weight” of a synapse changes.\n" +
            "But it’s been difficult to control the flow of ions in existing designs. Kim says that’s because most switching mediums, made of amorphous materials, have unlimited possible paths through which ions can travel — a bit like Pachinko, a mechanical arcade game that funnels small steel balls down through a series of pins and levers, which act to either divert or direct the balls out of the machine.\n" +
            "Like Pachinko, existing switching mediums contain multiple paths that make it difficult to predict where ions will make it through. Kim says that can create unwanted nonuniformity in a synapse’s performance.\n" +
            "“Once you apply some voltage to represent some data with your artificial neuron, you have to erase and be able to write it again in the exact same way,” Kim says. “But in an amorphous solid, when you write again, the ions go in different directions because there are lots of defects. This stream is changing, and it’s hard to control. That’s the biggest problem — nonuniformity of the artificial synapse.”\n" +
            "Instead of using amorphous materials as an artificial synapse, Kim and his colleagues looked to single-crystalline silicon, a defect-free conducting material made from atoms arranged in a continuously ordered alignment. The team sought to create a precise, one-dimensional line defect, or dislocation, through the silicon, through which ions could predictably flow.\n" +
            "To do so, the researchers started with a wafer of silicon, resembling, at microscopic resolution, a chicken-wire pattern. They then grew a similar pattern of silicon germanium — a material also used commonly in transistors — on top of the silicon wafer. Silicon germanium’s lattice is slightly larger than that of silicon, and Kim found that together, the two perfectly mismatched materials can form a funnel-like dislocation, creating a single path through which ions can flow.\n","I've seen the code of conduct thing work even before smartphones were ubiquitous -- even the open mic night at Eddie's Attic in Georgia was an event where the manager made it very clear that the venue was a Listening Room, not a place for talking over the performance, and if you wanted to use your phone in any noticeable way, you needed to step outside. And I saw him dress down and kick out a customer that decided to ignore the rule.\n" +
            "It's harder with larger crowds, but I think a policy with clear expectations that can result in you losing your privilege of attending is a better choice than asking people to check valuable (and useful) property at the door.\n" +
            "Let's imagine that my child is at a party or other social engagement and they want deniable reason to escape. There may be excessive peer pressure, illegal activity, or any other pre-arranged reason they may need to bail on something without incurring the loss of face that could be socially devastating.\n" +
            "If I have my phone, they can text me with some pre-arranged message (\"x\"), and I will feign an emergency and get them out of the situation ASAP (or arrange for a friend to do similarly).\n" +
            "Sure, they could just leave (or get a taxi?), but having a GTFO script lets them exit a situation without the social losses of having been perceived as \"too scared\" to cave to peer pressure. They can say, \"My dad just called and said something major just came up, and he's on his way to get me. Yeah, I know, parents, right?\n" +
            "If their phone is locked up (or mine) there's a lot more friction to that interaction.","I actually tested this theory recently; when I went to Machu Picchu, I took several pictures with my wife in them, and absolutely zero pics of the scenery or the monument. When I got home, I inserted some random high-res professional pics from recognizable vantage points into an album and called it a day. I don't feel shortchanged.\n" +
            "Although I'm somewhat glad for the tourist \"gotta take my own shitty photo\" attitude, because I saw a really nifty research project once that took thousands of tourist photos (of the Trevi Fountain) and combined them to generate a high-res 3d image without any people in it. That was pretty cool.\n" +
            "If I could change anything about my Machu Picchu experience, though, it would have been to find some way to shut up that blathering loudmouth moron in front of me who barely paused for breath for the entire duration of the morning hike to the nearby summit. Jesus christ lady, I couldn't hear a single nature sound, and I did NOT need to know about what a slut your cousin is.\n" +
            "I've found that looking back at old photos that feature me, my friends, or some interesting unique person, bring back way more powerful memories of the event.\n" +
            "For example seeing a random picture of Tokyo Tower that I took with no one recognizable in it, invokes " +
            "about the same connection as a random Google Image search for Tokyo Tower. However the picture of me standing in front of it, seeing my clothes, my umbrella, and all the other details puts me right back into that day. I remember more vividly the details before the picture and after the picture as well. It took me quite a few trips to realize this, but its pretty apparent now when I find myself skipping over random scenery pictures in my albums. Sometimes it can't be helped that no one is included, but I make an effort to minimize these pictures.","Unlike Germany, where saunas are mixed, the Finnish tradition is that — outside the family circle — men and women visit the sauna separately. Even so, for non-Finnish newcomers, the first session in the log cabin with colleagues might not be quite as relaxing as it’s meant to be. “It was a bit of a stepping stone to get over,” says Kristof Minnaert, a Belgian who moved to Helsinki in 2013 to join the staff of game developer Remedy Entertainment. The company’s studio and offices in Espoo have a rooftop sauna. “You have to be naked to get in there. It’s kind of frowned upon if you do wear a towel or swimming shorts,” adds Minnaert, 30, a senior character technical artist.\n" +
            "After three years, however, he’s grown at ease with the Friday evening ritual of a sauna with colleagues, where it's also common to sip a beer and then step outside onto the open-air terrace sans clothing. He and his team spend between one and three hours in the sauna each week and while they don't formally conduct meetings, they do talk about work and, sometimes, end up with good ideas to pursue back at their desks.\n");

    private List<String> c2= Arrays.asList("Yep you're right, it's just as much the fault of the corporations that are there. Startups are a big part of it, moving to SV just to form a startup locks a ton of qualified people out and unnecessarily jacks up your burn rate. You'd be far better off moving to Madison and hiring from University of Wisconsin where you still have Whole Foods and Trader Joes and a bike-friendly city and great public transport but your employees can buy their own house for $100k.\n" +
            "But people are part of the problem too. People move to SV to work for Google and Apple and Facebook but these aren't the only tech employers in the country. Sticking with Madison, Epic is huge and very high-tech. Ann Arbor MI has Duo, Arbor Networks, and Trove among many. And these places pay pretty darn well for the area, which means you're going to be taking home a lot more disposable income than you would in SV. The only downside is you won't be working for Google/Apple/Facebook, and you'd have to live in the Midwest which means dealing with other people. You might even have to shop at shudder Walmart.\n" +
            "\"People\" move there for the jobs... because that's where people just like them work. But I'll bet there's somewhere closer to home where they can work with people just like them but also experience other people frequently, make more money, work on just as interesting of projects, and come out better because of the experience.\n" +
            "Rolling the dice as in founding a startup? For sure. But that's mainly because all the VCs are are in SV and some of them force you to be there too (looking at you YC...). Startups outside of SV need to be profitable from day ono because there aren't too many people out here willing to throw millions of dollars at unprofitable ideas.\n" +
            "The ones rolling the dice are the VCs. Everyone else, founders included, are just slot machines. Your odds of hitting a jackpot in SV are higher than anywhere else, but so are your odds of losing everything. Elsewhere, you might not hit a jackpot and become a unicorn, but is a focus on slow and profitable growth really a net negative?\n" +
            "San Fransisco never forgot their gold rush heritage, and just like back then, the miners come looking " +
            "for a fortune but the only ones reliably getting rich are the tavern owners.","Motorsport is very big in my country, and the highlight of the motorsport calendar is the Formula 1 grand-prix held here every year. Formula 1 travels the world visiting about 15-2O countries a season, each country holding one grand-prix race. The whole event takes three days to complete and always follows the same format: Friday — Practice, Saturday — Qualiﬁng, Sunday — Race. 1O teams compete with 2 cars per team in the grand-prix.\n" +
            "First, second and third place all receive a trophy at the end of the race. All three days are broadcast on TV, but the highlight is the race itself, which has the largest viewership. The TV coverage improves each year as technology gets updated quicker than ever before. Every year there are always new innotive ways to show the race. This year there were cameras mounted on cars, cameras on zip—lines above corners to create unique angles and Z2-D cameras to capture the race as its never been seen before. Each year the broadcasters also try to improve the graphics displayed on the W screens with more and more detailed ‘Heads Up Displays’ (which are similar to the HUD used in video games) of what the drivers are doing in the car, so the viewers can see where, when and how much a driver is breaking, changing gear or accelerating. Viewers can also hear conversations between drivers and their pit-crew. All of this makes the viewer feel closer to the action and like they are involved in the race.\n" +
            "As motorsport is very prominent in my country the grand-prix has been used to show off not only new " +
            "technology, but also the national pride within the country. Irrespective of whether any of the competitions are from here, we celebrate F1 as a nation, and are proud that the race is held here. This is greatly helped by TV coverage always pushing boundaries and the fact that many people in the country will be doing the same thing at the same time. lt gives you the sense of unity.\n","I have often asked myself whether it is different being a teenager nowadays than when I was that age. Are the problems still the same?\n" +
            "The years between 10 and 20 are certainly a difficult time in everybody's life because one’s personality is developing and this makes a teenager generally more vulnerable than an adult. I am convinced that when it comes to media it is demanding to deal with for young people today. Advertisements are very prominent in our modern world and teenagers normally spend a lot of hours watching television or surfing the internet, which makes them potential customers. Furthermore, many teenagers have more money to spend than maybe twenty years ago and you often hear about families taking loans for expenses like technical equipment or mobile phone bills for their children. Certainly in the current economic climate many parents face tough decisions especially when it comes to what they can afford for their offspring. The most important point is that teenagers are often an easy target for companies advertising their latest gadgets Many teenagers will buy it if theyjust manage to convince them that their product is an absolute ‘n'|ust—have', because the pressure of belonging to a certain group, feeling accepted and not being an outsider is a big issue for a young person.\n" +
            "On the other hand, teenagers are trend setters. They have to create new ideas to be unique orjust different from their own parents and this often sets the trend for a whole generation. Being special and fashionable is so important and therefore one needs to spend money on clothes, computers, games or phones to be part of your teenage generation and to find common grounds to make friends and have a fulfilling social life.\n" +
            "Personally, I find it quite shocking when reading about the psychological strategies advertising companies use to gain influence on young people to sell a product. They are also often exploiting the creative energy of teenagers and it is almost impossible to escape the world of advertisement.\n" +
            "To conclude, I believe it is not feasible to prohibit adverts for teenagers. Furthermore, parents cannot" +
            " avoid their children coming into contact with it, but it needs sensible adults helping and supporting teenagers in developing their own personality and sense of taste without the powerful influence of adverts.\n","Timing is critical for playing a musical instrument, swinging a baseball bat, and many other activities. Neuroscientists have come up with several models of how the brain achieves its exquisite control over timing, the most prominent being that there is a centralized clock, or pacemaker, somewhere in the brain that keeps time for the entire brain.\n" +
            "However, a new study from MIT researchers provides evidence for an alternative timekeeping system that relies on the neurons responsible for producing a specific action. Depending on the time interval required, these neurons compress or stretch out the steps they take to generate the behavior at a specific time.\n" +
            "“What we found is that it’s a very active process. The brain is not passively waiting for a clock to reach a particular point,” says Mehrdad Jazayeri, the Robert A. Swanson Career Development Professor of Life Sciences, a member of MIT’s McGovern Institute for Brain Research, and the senior author of the study.\n" +
            "MIT postdoc Jing Wang and former postdoc Devika Narain are the lead authors of the paper, which appears in the Dec. 4 issue of Nature Neuroscience. Graduate student Eghbal Hosseini is also an author of the paper.\n" +
            "One of the earliest models of timing control, known as the clock accumulator model, suggested that the brain has an internal clock or pacemaker that keeps time for the rest of the brain. A later variation of this model suggested that instead of using a central pacemaker, the brain measures time by tracking the synchronization between different brain wave frequencies.\n" +
            "Although these clock models are intuitively appealing, Jazayeri says, “they don’t match well with what the brain does.”\n" +
            "No one has found evidence for a centralized clock, and Jazayeri and others wondered if parts of the " +
            "brain that control behaviors that require precise timing might perform the timing function themselves. “People now question why would the brain want to spend the time and energy to generate a clock when it’s not always needed. For certain behaviors you need to do timing, so perhaps the parts of the brain that subserve these functions can also do timing,” he says.\n","C can definitively be mastered. C at it's core is pragmatic minimalism. The basic ideas are very simple. If you want to be a language lawyer and know the standard completely (including all historical accidents), it can get complex, but still manageable. But anyways, you shouldn't be a language lawyer. That's not C. Make maintainable programs instead, stay in the middle of the road.\n" +
            "C gets out of the programmer's way. It's not about mastering C, but about mastering programming. And while I agree there's much bad C software out there: I haven't seen one maintainable non-bloated Java project. Here is one master of C that I'm sure you know: Linus Torvalds. Of course there are many, many more. Just remember it's not about C, but programming machines in general.\n" +
            "I also haven't seen one large-scale network-facing C project written using reasonable development practices (i.e. not absurdly expensive formal verification) that hasn't had some sort of terrible remote code execution vulnerability. By contrast, Java programs tend to be far less vulnerable to this kind of problem. (The closest thing is probably bugs with attacker controlled java.io.Serializable, which while severe are much less frequent than RCE in C programs.)\n" +
            "I wouldn't say \"mastering C\" should imply \"never have any security issues\". And many vulnerabilities are conceptual and don't have anything to do with the use of C.\n" +
            "Use your tools wisely. Architect programs for clear data flow. Validate inputs as soon as possible. Don't do (de)serialization by hand.\n" +
            "By all means use a managed \"memory safe\" language if you have many data accesses that are not behind a" +
            " validation gateway. But for large amounts of data or complex software, that's still not an option. C is" +
            " still the only language in which I can write software of advanced complexity - because it does not get " +
            "in my way.","Casual carpooling opportunities don't have enormously wealthy corporations behind them.\n" +
            "Setting the support obligation or morality questions aside for a moment (though I'm on the side of \"by facilitating and profiting from this, you accept some responsibility for the quality of that facilitation\"), that big difference is still critical: suing the operator of a neighborhood carpool mailing list or somesuch has limited yield. Suing Google has potentially massive yield. So a corporation should think about that sort of risk, just like they would the PR risks, etc, of letting it be an unregulated wild west.\n" +
            "Your position sounds a lot like \"light or even largely-community-based self-moderation will be enough\" and yet platforms like Twitter and Reddit that have attracted some large controversies and PR shitshows even without real money or real physical harm being involved. Heck, \"don't read the comments\" is standard internet advice to the point of being cliche.\n" +
            "These things could happen, but since the product/service is about carpooling, I tend to pick up the same people repeatedly. Any time you work with a new person, there is a risk. That risk goes down significantly with repeated rides. I initially had issues with pick up and drop off location, due to Waze letting you pick how many minutes you're willing to walk. With new riders, I have a chat before accepting so they understand the nuances of Waze Carpool.\n" +
            "Good point.\n" +
            "I think it’s intersting that you go to medium for even small claims is a phone call.\n" +
            "I find the level of support we can get over chat to be pretty good nowadays, my bank, insurance, company HR also deals with all non lofe threatening issues by mail and messaging only.\n" +
            "We’re finaly getting away from a phone centric world, and I feel the service is actualy better while cheaper and more efficient.\n" +
            "I specifically chose \"phone call\" because it's an instant response, and you're certain you're talking to a human being - someone who can empathize, and who can elevate, and who's focused on you, right now.\n" +
            "A chat box? That can be a bot. That can be someone in a call center in Hyderabad or Abilene. That can be" +
            " someone juggling five conversations at the same time, whose ability to escalate starts and ends at a button, the effects of which they don't even really understand.","I'm just saying that the way compensation is determined currently (primarily per tech stack and years of experience) doesn't seem to have a good effect on the industry as a whole. It encourages rushing into \"hot\" technologies, and discourages sticking around with a single company and project for more than a couple of years. I think companies have to start taking into account the possibility that the value of certain classes of employees (like software developers, for one) to the organization might drastically increase without that person learning any new skills.\n" +
            "If I'm making $50,000 as a developer at Company X, but I know that other developers using the same tech I do at other companies are making $75,000, what are the chances I'm going to get a $25,000 raise from Company X? Probably nothing. But the chances of me getting myself a raise by switching jobs are pretty good. Likewise if I know that developers using Tech Y are making $100,000, I'm going to try and get my company to adopt Tech Y, regardless if it's good for the company or not. Then, once I know enough about it to impress an interviewer, I'm gone. I have a theory that this dynamic is behind the phenomenon of new techs coming out of Silicon Valley suddenly becoming extremely popular and then causing huge waves of buyer's remorse.\n" +
            "My observation from working in this industry for 10 years, is that the true potential of software is not unlocked until it's been in production for at least 3 years. This is a bit of an oddball view of mine but I believe it's backed by research. 3-4 years is around the time when the developers are familiar enough with the requirements and the code to make big, bold plans and execute on them. But usually that doesn't happen -- usually, the developers who created it leave before then for greener pastures, and the new folks who come in have zero context on the decisions behind the original system. So they try to rewrite it, repeat all the original mistakes, and maybe even add some new ones.\n" +
            "The easiest thing companies can do to fix this is just get more aggressive with counteroffers. If a " +
            "developer quits, ask them how much they're getting and then match it. Counteroffers happen all the time with new hires, but rarely with existing employees. It should be flipped; companies should try harder to retain than to hire new.","Exactly. There are lots of great reasons to justify it. Higher wages offset the cost of living (which can't be caused by the rising wages, right?) and has the side effect of locking out anyone who can't or won't work for a tech company, driving them from the homes they can no longer afford, ensuring that the next person who moves in there will be just like me.\n" +
            "Personally I wouldn't want to live anywhere else. Because anywhere else there are other kinds of people, doing other kinds of things and living other kinds of lives. Can't have that, it would bring down my paycheck. Gotta have that network effect, and of course by network effect, I mean people who are just like me.\n" +
            "I am being too cynical, you're right. I'm pushing into the hyperbole territory to try to make my point as clear as possible.\n" +
            "Diversity isn't how many black people you know. And it's not a perfect line of \"SV is awful, everywhere else is better\". Some places around the country are better for your soul than others, and the best way to experience life is by visiting places, spending time in places where people live drastically different lives than you do. Bonus points if you're a minority (a rich person living in a poor town, a poor person living in a rich town, black living in a white area, white living in a black area, conservative living in a liberal area, you get the idea).\n" +
            "Point is, congregating everyone of a type in one area leads to a monoculture which is dangerous. Race " +
            "doesn't matter nearly as much as economic class, and making well-paying tech jobs centralized in one area for really no good reason does very little to help. If people going to SV are so willing to move to somewhere new for work, does it really all have to be the exact same place? With a ton of other people just like them?","It's fine for things to be subsidized and taxes collected so that a way of life is more attainable, that's how societies work. In all likelihood I'm subsidizing the people around here who use NJ transit in place of driving - I hardly have my car on for more than 10 minutes a day and it's around 30mpg. It's just part of a larger give-and-take that we all participate in, I pay for trains I don't use today and they pay for state parks they don't use tomorrow. Are you opposed to all government subsidies? It's not tenable for everybody to pay the full cost of everything they do. A prime example is healthcare.\n" +
            "It's not okay to subsidize things in general, and especially things with massive negative externalities (like cars), when the person using that subsidy can easily afford it. And let's face it, the middle class can easily afford $8/gallon. Nobody wants to pay that, but they can afford it. As a proof that people can afford it, we have dozens of first world counties with strong middle classes that correctly price their road taxes. They do just fine.\n" +
            "I've never understood the idea that we should just cross subsidize every single thing we can. It's absurd. Prices affect decisions, and when artificially low prices induce people to collectively make decisions that are bad for society, we should stop fucking subsidizing it.\n" +
            "Imagine how much better our government would be if we took all of the taxes we take in, and stopped spending it all on things that are bad for society on behalf of people that can afford it or don't need it, and started spending it all on things that are good for society on behalf of people that need it but can't afford it.\n" +
            "Replying to the lowest level comment because this is the one where you call it out specifically.\n" +
            "These subsidies aren't driven by an outcry from the population, they're driven by groups of companies lobbying the government. Car companies would almost certainly lobby against reducing gas subsidies - it would cause people to reconsider buying a car.\n" +
            "Lobbyists will also be on the lookout for services like waze carpool because it has the potential to cut" +
            " in on their business (transit and taxis).","There are tons of justifications you can come up with for not using something you don't want to use. The down side is that you aren't going to be getting the upsides you'd get if you used a new technology, possibly to the extent of being no longer competitive with people who do use that technology.\n" +
            "The important thing is balancing chasing the new hotness vs. always using the tried and true.\n" +
            "Last year I ran into a similar sort of situation at work, the funds to buy Ansible Tower required a battle I wasn't willing to fight. The argument was \"We've spent so much money on tools that then get abandoned.\" We spent nearly a year with me being the only one in the company that could run Ansible playbooks because of this, until I finally found RunDeck. Now, we aren't paying for Rundeck, does that make it more likely to be abandoned? Was the risk in our operations if I suddenly became unavailable worth the saved licensing fees? Well, in this case it worked out ok, but it could have gone very badly.\n" +
            "As far as timeseries goes, there are huge advantages here. We used to use collectd/graphite/carbon, but a year or more ago I switched us over to InfluxDB/telegraf/grafana. It was a little rocky a start, the first version of Influx I used had plenty of problems. At the time Prometheus was probably a better choice, but I couldn't come up with a way to make it's pull-centric design fit into our environment. Then InfluxDB settled down and things have been great since.\n" +
            "We have way better metrics, with a way more usable dashboard, and significantly lower load. Literally, " +
            "disabling collectd ended the complaints about performance on our dev/stg environments.");

}
