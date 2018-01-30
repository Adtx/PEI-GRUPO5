public class CSV_Tester {

          ArrayList<String> header_names;
// download opencsv JAR from https://sourceforge.net/projects/opencsv/

        public void test_csv_file(String path,String output_name){
          Test t= new Test();
          SVM_Classifier
          PrintWriter pw = new PrintWriter(new File(output_name));
          StringBuilder sb = new StringBuilder();
          String csvFile = path;
          CSVReader reader=null;
          header_names= new ArrayList<>();
          ArrayList<String> last_test_values;

          //iniciar classificadores
          SVM_Classifier svm_classifier=new SVM_Classifier("svm_classifier");
          //knn_classifier=new KNN("knn_arf");
          KNN knn_classifier=new KNN();
          knn_classifier.train_model();
          NeuralNet nn_classifier=new NeuralNet("MyMultiLayerNetwork.zip");

          try {
            //iniciar writer
            Writer writer = Files.newBufferedWriter(output_name);

            CSVWriter csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            //iniciar reader
            new CSVReader(new FileReader(csvFile));


            String[] line;
            //getting headers
            line= reader.readNext();
            for(int i=0;i<line.size;i++){
              header_names.add(line[i]);
            }
            add_test_headers();
            String[] header = new String[header_names.size()];
            header = header_names.toArray(header);
            csvWriter.writeNext(header);


          while ((line = reader.readNext()) != null) {

            //novo teste
            last_test_values=new ArrayList<>();

            //adicionar os campos do cliente
            for(int i=0;i<line.size;i++){
              last_test_values.add(line[i]);
            }

            // correr teste e meter resultados numa string
            t.run_test(line[line.size-1]);
            String test_results= t.print_test();

            //obter notas dos classificadores
            double svm_test_grade=svm_classifier.predict(test_result,";");
            double knn_test_grade= knn_classifier.predict(test_result,";");
            double nn_test_grade=nn_classifier.predict(test_result,";")+1;

            //TODO: note given by equal weight of the three classifiers needs to be changed
            double true_final_grade=(svm_test_grade+knn_test_grade+nn_test_grade)/3;
            int final_grade_rounded= (int) Math.round(doubleVar);

            if(final_grade_rounded==1){
                last_test_values.add("A1");
            }
            if(final_grade_rounded==2){
              last_test_values.add("A2");
            }
            if(final_grade_rounded==3){
              last_test_values.add("B1");
            }
            if(final_grade_rounded==4){
              last_test_values.add("B2");
            }
            if(final_grade_rounded==5){
              last_test_values.add("C1");
            }
            if(final_grade_rounded==6){
              last_test_values.add("C2");
            }


            String[] values = teste_results.split(";");
            Collections.addAll(last_test_values, values);

            String[] test_values = new String[last_test_values.size()];
            test_values = last_test_values.toArray(test_values);
            csvWriter.writeNext(test_values);

          }
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
