package Util;
import bean.User.UserBeanLocal;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import hibernate.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class CSV_Tester {

          ArrayList<String> header_names;
// download opencsv JAR from https://sourceforge.net/projects/opencsv/

        public void test_csv_file(String path, String output_name, Context con, UserBeanLocal userBeanLocal, hibernate.Test default_test, EvaluationComponent[] eva) throws FileNotFoundException {


            //System.out.println(path);
          Test t= new Test();
          PrintWriter pw = new PrintWriter(new File(output_name));
          StringBuilder sb = new StringBuilder();
          String csvFile = path;
          CSVReader reader=null;
          header_names= new ArrayList<>();
          ArrayList<String> last_test_values;

          //iniciar classificadores
          SVM_Classifier svm_classifier=new SVM_Classifier("C:\\Users\\Pedro\\Desktop\\final_proj\\dl4j-examples-master\\Anansi\\svm_classifier");
          //knn_classifier=new KNN("knn_arf");
          KNN knn_classifier=new KNN();
          knn_classifier.train_model();
          NeuralNet nn_classifier=new NeuralNet("C:\\Users\\Pedro\\Desktop\\final_proj\\dl4j-examples-master\\Anansi\\MyMultiLayerNetwork.zip");
            CSVWriter csvWriter=null;
          try {
            //iniciar writer
              Writer writer = Files.newBufferedWriter(Paths.get(output_name));

            csvWriter = new CSVWriter(writer,';',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);



            //iniciar reader
              //reader= new CSVReader()
            reader=new CSVReader(new FileReader(csvFile),';');


            String[] line;
            //getting headers
            line= reader.readNext();
            for(int i=0;i<line.length;i++){
              header_names.add(line[i]);
            }
            add_test_headers();
            String[] header = new String[header_names.size()];
            header = header_names.toArray(header);
              //System.out.println(header[0]);
              //System.out.println(header[1]);
              //System.out.println(header[2]);

            csvWriter.writeNext(header);




          while ((line = reader.readNext()) != null) {
              if(line.length>1) {
                  //System.out.println(line.length>1);
                  //System.out.println(line[line.length-1]);

                  //novo teste
                  last_test_values = new ArrayList<>();

                  //adicionar os campos do cliente
                  for (int i = 0; i < line.length; i++) {
                      last_test_values.add(line[i]);
                  }

                  // correr teste e meter resultados numa string
                  t.run_test(line[line.length - 1]);
                  String test_results = t.print_test();

                  //obter notas dos classificadores
                  double svm_test_grade = svm_classifier.predict(test_results, ";");
                  double knn_test_grade = knn_classifier.predict(test_results, ";");
                  double nn_test_grade = nn_classifier.predict(test_results, ";") + 1;

                  //TODO: note given by equal weight of the three classifiers needs to be changed
                  double true_final_grade = (svm_test_grade + knn_test_grade + nn_test_grade) / 3;
                  int final_grade_rounded = (int) Math.round(true_final_grade);
                  String desig = "";
                  if (final_grade_rounded == 1) {
                      last_test_values.add("A1");
                      desig = "A1";
                  }
                  if (final_grade_rounded == 2) {
                      last_test_values.add("A2");
                      desig = "A2";
                  }
                  if (final_grade_rounded == 3) {
                      last_test_values.add("B1");
                      desig = "B1";
                  }
                  if (final_grade_rounded == 4) {
                      last_test_values.add("B2");
                      desig = "B2";
                  }
                  if (final_grade_rounded == 5) {
                      last_test_values.add("C1");
                      desig = "C1";
                  }
                  if (final_grade_rounded == 6) {
                      last_test_values.add("C2");
                      desig = "C2";
                  }


                  String[] values = test_results.split(";");
                  Collections.addAll(last_test_values, values);

                  String[] test_values = new String[last_test_values.size()];
                  test_values = last_test_values.toArray(test_values);
                  csvWriter.writeNext(test_values);
                  try {
                      User u = userBeanLocal.loginUser1(line[1]);
                      if (u == null) {
                          u = new User();
                          u.setEmail(line[1]);
                          u.setName(line[0]);
                          u.setPassword("tempPass");
                          UserDAO.save(u);
                      }
                      Response r = new Response();
                      r.setContent(line[line.length - 1]);
                      Result res = new Result();
                      res.setResult(final_grade_rounded);
                      res.setDesignation(desig);
                      r.setContext(con);
                      r.setUser(u);
                      r.setTest(default_test);
                      r.setDate(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
                      r.setDay(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                      r.setMonth(Calendar.getInstance().get(Calendar.MONTH) + 1);
                      r.setYear(Calendar.getInstance().get(Calendar.YEAR));

                      ResponseDAO.save(r);
                      res.setResponse(r);
                      ResultDAO.save(res);


                      ComponentResult comRes1 = new ComponentResult();
                      comRes1.setEvaluationComponent(eva[0]);
                      comRes1.setNumber(t.get_total_words());
                      comRes1.setDesignation("total " + t.get_total_words() + " words");
                      comRes1.setResponse(r);
                      comRes1.setResult(res);
                      ComponentResultDAO.save(comRes1);

                      //component total_errors
                      comRes1 = new ComponentResult();
                      comRes1.setEvaluationComponent(eva[1]);
                      comRes1.setNumber(t.get_complex_errors() + t.get_simple_errors());
                      comRes1.setDesignation("total " + t.get_complex_errors() + t.get_simple_errors() + " errors");
                      comRes1.setResponse(r);
                      comRes1.setResult(res);
                      ComponentResultDAO.save(comRes1);

                      //component Readability
                      comRes1 = new ComponentResult();
                      comRes1.setEvaluationComponent(eva[2]);
                      comRes1.setNumber(0.4 * ((t.get_total_words() / t.get_total_sentences()) + 100 * (t.get_complex_words() / t.get_total_words())));
                      comRes1.setDesignation(0.4 * ((t.get_total_words() / t.get_total_sentences()) + 100 * (t.get_complex_words() / t.get_total_words())) + " readability");
                      comRes1.setResponse(r);
                      comRes1.setResult(res);
                      ComponentResultDAO.save(comRes1);

                      //component Perplexity
                      comRes1 = new ComponentResult();
                      comRes1.setEvaluationComponent(eva[3]);
                      comRes1.setNumber(t.get_bigram_perplexity());
                      comRes1.setDesignation(t.get_bigram_perplexity() + " perplexity");
                      comRes1.setResponse(r);
                      comRes1.setResult(res);
                      ComponentResultDAO.save(comRes1);

                      //component lexical_density
                      comRes1 = new ComponentResult();
                      comRes1.setEvaluationComponent(eva[4]);
                      comRes1.setNumber(t.get_lexical_density());
                      comRes1.setDesignation(t.get_lexical_density() + " lexical_density");
                      comRes1.setResponse(r);
                      comRes1.setResult(res);
                      ComponentResultDAO.save(comRes1);

                      //component lexical_richness
                      comRes1 = new ComponentResult();
                      comRes1.setEvaluationComponent(eva[5]);
                      double lexical_rich = 0.0;
                      lexical_rich = t.get_beyond_2000() + t.get_advanced_ttr() + t.get_advanced_guiraud() +
                          t.get_ttr() + t.get_rttr() + t.get_cttr() + t.get_m() + t.get_h() +
                          t.get_r() + t.get_s() + t.get_mwf();
                      lexical_rich = lexical_rich / 11;
                      comRes1.setNumber(lexical_rich);
                      comRes1.setDesignation(lexical_rich + " lexical_richness");
                      comRes1.setResponse(r);
                      comRes1.setResult(res);
                      ComponentResultDAO.save(comRes1);

                  } catch (Exception e) {
                      e.printStackTrace();
                  }


              }
          }
              csvWriter.close();
          } catch (IOException e) {
          e.printStackTrace();
          }

        }


        private void add_test_headers(){
          header_names.add("level");
          header_names.add("total_words");
          header_names.add("total_sentences");
          header_names.add("total_syllables");
          header_names.add("complex_words");
          header_names.add("letter_count");
          header_names.add("common_words");
          header_names.add("total_different_words");
          header_names.add("different_advanced_words");
          header_names.add("advanced_ttr");
          header_names.add("advanced_guiraud");
          header_names.add("ttr");
          header_names.add("rttr");
          header_names.add("cttr");
          header_names.add("h");
          header_names.add("s");
          header_names.add("mwf");
          header_names.add("r");
          header_names.add("bigram_perplexety");
          header_names.add("a1_words");
          header_names.add("a2_words");
          header_names.add("b1_words");
          header_names.add("b2_words");
          header_names.add("c1_words");
          header_names.add("c2_words");
          header_names.add("bigram_perplexety_reverse");
          header_names.add("simple_errors_per_word");
          header_names.add("complex_errors_per_word");


        }




}
