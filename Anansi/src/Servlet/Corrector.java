package Servlet;

import Util.KNN;
import Util.SVM_Classifier;
import Util.NeuralNet;
import Util.Test;
import bean.Corrector.CorrectorBeanLocal;
import bean.util.AppConfigBeanLocal;
import bean_lookup.AppConfigBeanLookup;
import bean_lookup.CorrectorBeanLookup;
import org.languagetool.JLanguageTool;
import org.languagetool.language.PortugalPortuguese;
import org.languagetool.rules.Rule;
import org.languagetool.rules.RuleMatch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet(name = "corrector")
public class Corrector  extends HttpServlet {

    private static final String PARAGRAPH_SPLIT_REGEX = "\\n";




    protected static int countSyllables(String word){
        // TODO: Implement this method so that you can call it from the
        // getNumSyllables method in BasicDocument (module 1) and
        // EfficientDocument (module 2).
        int count = 0;
        word = word.toLowerCase();

        if (word.charAt(word.length()-1) == 'e') {
            if (silente(word)){
                String newword = word.substring(0, word.length()-1);
                count = count + countit(newword);
            } else {
                count++;
            }
        } else {
            count = count + countit(word);
        }
        return count;
    }

    private static int countit(String word) {
        int count = 0;
        Pattern splitter = Pattern.compile("[^aeiouy]*[aeiouy]+");
        Matcher m = splitter.matcher(word);

        while (m.find()) {
            count++;
        }
        return count;
    }

    private static boolean silente(String word) {
        word = word.substring(0, word.length()-1);

        Pattern yup = Pattern.compile("[aeiouy]");
        Matcher m = yup.matcher(word);

        if (m.find()) {
            return true;
        } else
            return false;
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // --- BEANS
        AppConfigBeanLocal appConfig = AppConfigBeanLookup.getAppConfigBean();
        CorrectorBeanLocal correctorBean = CorrectorBeanLookup.getCorrectorBean();

        try {
            HttpSession httpSession = request.getSession();
            String teste = "";

            
            String s = "Isto é um maçã. A maca murcou.\nPararafo teste!";
             SVM_Classifier svm_classifier;
             KNN knn_classifier;
             NeuralNet nn_classifier;
             Test tester;

            tester=new Test();
            svm_classifier=new SVM_Classifier("/Users/andrepinto/GitHub/PEI-GRUPO5/Anansi/svm_classifier");
            //knn_classifier=new KNN("knn_arf");
            knn_classifier=new KNN();
            knn_classifier.train_model();
            nn_classifier=new NeuralNet("/Users/andrepinto/GitHub/PEI-GRUPO5/Anansi/MyMultiLayerNetwork.zip");
            
            
            try {
                tester.run_test(s);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            String test_result=tester.print_test();
            System.out.println(test_result);
            double svm_test_grade=svm_classifier.predict(test_result,";");
            double knn_test_grade= knn_classifier.predict(test_result,";");
            double nn_test_grade=nn_classifier.predict(test_result,";");



            //svm test grade
            if(svm_test_grade==1){
                teste =(teste+"SVM CEFR level: A1\n");
                System.out.println("SVM CEFR level: A1");
            }
            if(svm_test_grade==2){
                teste = (teste+"SVM CEFR level: A2\n");
                System.out.println("SVM CEFR level: A2");
            }
            if(svm_test_grade==3){
                teste = (teste +"SVM CEFR level: B1\n");
                System.out.println("SVM CEFR level: B1");
            }
            if(svm_test_grade==4){
                teste = (teste +"SVM CEFR level: B2\n");
                System.out.println("SVM CEFR level: B2");
            }
            if(svm_test_grade==5){
                teste = (teste +"SVM CEFR level: C1\n");
                System.out.println("SVM CEFR level: C1");
            }
            if(svm_test_grade==6){
                teste = (teste +"SVM CEFR level: C2\n");
                System.out.println("SVM CEFR level: C2");
            }

            //KNN grade
            if(knn_test_grade==1){
                teste = (teste +"KNN CEFR level: A1\n");
                System.out.println("KNN CEFR level: A1");
            }
            if(knn_test_grade==2){
                teste = (teste +"KNN CEFR level: A2\n");
                System.out.println("KNN CEFR level: A2");
            }
            if(knn_test_grade==3){
                teste = (teste +"KNN CEFR level: B1\n");
                System.out.println("KNN CEFR level: B1");
            }
            if(knn_test_grade==4){
                teste = (teste +"KNN CEFR level: B2\n");
                System.out.println("KNN CEFR level: B2");
            }
            if(knn_test_grade==5){
                teste = (teste +"KNN CEFR level: C1\n");
                System.out.println("KNN CEFR level: C1");
            }
            if(knn_test_grade==6){
                teste = (teste +"KNN CEFR level: C2\n");
                System.out.println("KNN CEFR level: C2");
            }

            //Neural Net Grade
            if(nn_test_grade==1){
                teste = (teste +"NN CEFR level: A1\n");
                System.out.println("NN CEFR level: A1");
            }
            if(nn_test_grade==2){
                teste = (teste +"NN CEFR level: A2\n");
                System.out.println("NN CEFR level: A2");
            }
            if(nn_test_grade==3){
                teste = (teste +"NN CEFR level: B1\n");
                System.out.println("NN CEFR level: B1");
            }
            if(nn_test_grade==4){
                teste = (teste +"NN CEFR level: B2\n");
                System.out.println("NN CEFR level: B2");
            }
            if(nn_test_grade==5){
                teste = (teste +"NN CEFR level: C1\n");
                System.out.println("NN CEFR level: C1");
            }
            if(nn_test_grade==6){
                teste = (teste +"NN CEFR level: C2\n");
                System.out.println("NN CEFR level: C2");
            }
            
            
            
            /*
            // correctorBean.checker();

            String teste="";
            int err_dif=0;
            int err_fac=0;
            int paragrafo_nr = 1;
            JLanguageTool langTool = new JLanguageTool(new PortugalPortuguese());
            //for (Rule rule : langTool.getAllRules()) {
            //    if (!rule.isDictionaryBasedSpellingRule()) {
            //        langTool.disableRule(rule.getId());
            //    }
            //}
            List<RuleMatch> matches = langTool.check("Isto é um maçã. A maca murcou.\nPararafo teste!");
            String str = "Isto é um maçã. A maca murcou.\nPararafo teste!";
            String[] parag = str.split(PARAGRAPH_SPLIT_REGEX);


            System.out.println(str);
            for (String s : parag){

               ArrayList<String> frases = new ArrayList<String>();
                for ( String a : langTool.sentenceTokenize(s)){
                    frases.add(a);
                }

                teste = teste + "O paragrafo "+paragrafo_nr+ " tem "+ frases.size() + " frases, cada uma com ";

                for(String a : frases){
                    if(a.equals(frases.get(frases.size()-1))){
                        teste = teste + a.split(" ").length;
                    }
                    else{
                        teste = teste + a.split(" ").length +", ";
                    }

                }
                teste = teste + " palavras.\n";
                paragrafo_nr++;
            }
            teste= teste + "\n\n\n";
            ArrayList<String> parags  = new ArrayList<String>();
            for(String b : parag)
                parags.add(b);
            for (RuleMatch match : matches) {
                int lin = match.getLine();
                int col = match.getColumn();
                String[] words = parag[lin].split(" ");
                int curpos = 1;
                String error = "";
                for(String a : words){
                    if(col == curpos){error = a;break;}
                    else{
                        curpos += a.length() + 1;
                    }
                }

                System.out.println("Potential typo at line " +
                        match.getLine() + ", column " +
                        match.getColumn() + ": " + match.getMessage() +
                        " at word " + error);
                if(countSyllables(error)>=3){System.out.println("Erro dificil!");err_dif++; }
                else {System.out.println("Erro facil!");err_fac++;}
                System.out.println("Suggested correction(s): " +
                        match.getSuggestedReplacements());
                for(String s : match.getSuggestedReplacements()){

                teste = teste + match.getShortMessage() + "\n";

                }

            }

            System.out.println(teste);
            teste = teste +  "\n\r\r\nErros faceis: "+ err_fac+ "  <-------> Erros dificeis: "+ err_dif; */



            httpSession.setAttribute("info", teste);
            String page = "corrector";
            request.setAttribute("req_project_name", appConfig.getProject() );
            request.setAttribute("req_page_title", appConfig.getPageTitle(page) );
            request.setAttribute("req_page_jsp_files", appConfig.getPageTemplates(page) );
            getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/template.jsp").forward(request,response);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            processRequest(request, response);
    }
}
