package Servlet;

import Util.KNN;
import Util.SVM_Classifier;
import Util.NeuralNet;
import Util.Test;
import bean.Context.ContextBean;
import bean.Context.ContextBeanLocal;
import bean.Corrector.CorrectorBeanLocal;
import bean.EvaluationComponent.EvaluationComponentBeanLocal;
import bean.Test.TestBeanLocal;
import bean.util.AppConfigBeanLocal;
import bean_lookup.*;
import hibernate.*;
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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
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

        EvaluationComponentBeanLocal evaluationComponentBean = EvaluationComponentBeanLookup.getEvaluationComponentBean();
        TestBeanLocal testBeanLocal = TestBeanLookup.getTestBean();
        ContextBeanLocal contextBeanLocal = ContextBeanLookup.getContextBean();


        String teste = "";
        //System.out.println("UPS!!!!!! " + teste);
        try {
            HttpSession httpSession = request.getSession();

            String s = request.getParameter("texto");

            SVM_Classifier svm_classifier;
            KNN knn_classifier;
            NeuralNet nn_classifier;
            Test tester;

            tester=new Test();
            svm_classifier=new SVM_Classifier("C:\\Users\\Pedro\\Desktop\\final_proj\\dl4j-examples-master\\Anansi\\svm_classifier");
            //knn_classifier=new KNN("knn_arf");
            svm_classifier.train_classifier();
            //knn_classifier=new KNN("/Users/andrepinto/GitHub/PEI-GRUPO5/dl4j-examples-master/Anansi/knn_arf");
            knn_classifier = new KNN();
            knn_classifier.train_model();
            nn_classifier=new NeuralNet("C:\\Users\\Pedro\\Desktop\\final_proj\\dl4j-examples-master\\Anansi\\MyMultiLayerNetwork.zip");
            //nn_classifier = new NeuralNet();
            //nn_classifier.train_neural_net();

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
            double level=Math.round((svm_test_grade+knn_test_grade+nn_test_grade+1)/3);
            if(level==1){
                teste =(teste+"CEFR level: A1\n");
            }
            if(level==2){
                teste = (teste+"CEFR level: A2\n");
            }
            if(level==3){
                teste = (teste +"CEFR level: B1\n");
            }
            if(level==4){
                teste = (teste +"CEFR level: B2\n");
            }
            if(level==5){
                teste = (teste +"CEFR level: C1\n");
            }
            if(level==6){
                teste = (teste +"CEFR level: C2\n");
            }
            System.out.println(svm_test_grade+"//"+knn_test_grade+"//"+nn_test_grade);

/*
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
            }*/
    /*
            //KNN grade
            if(knn_test_grade==1){
                teste = (teste +"CEFR level: A1\n");
                System.out.println("CEFR level: A1");
            }
            if(knn_test_grade==2){
                teste = (teste +"CEFR level: A2\n");
                System.out.println("CEFR level: A2");
            }
            if(knn_test_grade==3){
                teste = (teste +"CEFR level: B1\n");
                System.out.println("CEFR level: B1");
            }
            if(knn_test_grade==4){
                teste = (teste +"CEFR level: B2\n");
                System.out.println("CEFR level: B2");
            }
            if(knn_test_grade==5){
                teste = (teste +"CEFR level: C1\n");
                System.out.println("CEFR level: C1");
            }
            if(knn_test_grade==6){
                teste = (teste +"CEFR level: C2\n");
                System.out.println("CEFR level: C2");
            }
            */
/*
            //Neural Net Grade
            if(nn_test_grade==0){
                teste = (teste +"CEFR level: A1\n");
                System.out.println("NN CEFR level: A1");
            }
            if(nn_test_grade==1){
                teste = (teste +"CEFR level: A2\n");
                System.out.println("NN CEFR level: A2");
            }
            if(nn_test_grade==2){
                teste = (teste +"CEFR level: B1\n");
                System.out.println("NN CEFR level: B1");
            }
            if(nn_test_grade==3){
                teste = (teste +"CEFR level: B2\n");
                System.out.println("NN CEFR level: B2");
            }
            if(nn_test_grade==4){
                teste = (teste +"CEFR level: C1\n");
                System.out.println("NN CEFR level: C1");
            }
            if(nn_test_grade==5){
                teste = (teste +"CEFR level: C2\n");
                System.out.println("NN CEFR level: C2");
            }
*/


            User u = (User) httpSession.getAttribute("user");
            Response r = new Response();
            r.setContent(s);
            Result res = new Result();
            res.setResult((nn_test_grade+1+svm_test_grade+knn_test_grade)/3);
            if(res.getResult()<=1.0){
                //teste = (teste +"CEFR level: A1\n");
                res.setDesignation("A1");
            } else if(res.getResult()<=2.0){
                teste = (teste +"CEFR level: A2\n");
                res.setDesignation("A2");
            } else if(res.getResult()<=3.0){
                //teste = (teste +"CEFR level: B1\n");
                res.setDesignation("B1");
            } else if(res.getResult()<=4.0){
                //teste = (teste +"CEFR level: B2\n");
                res.setDesignation("B2");
            } else if(res.getResult()<=5.0){
                //teste = (teste +"CEFR level: C1\n");
                res.setDesignation("C1");
            } else if(res.getResult()<=6.0){
                //teste = (teste +"CEFR level: C2\n");
                res.setDesignation("C2");
            }


            String con_nome = request.getParameter("name");
            String con_pw = request.getParameter("pass");
            Context con = contextBeanLocal.getContextByCodePw(con_nome, con_pw);
            if(con!=null)
                r.setContext(con);
            r.setUser(u);
            r.setTest(testBeanLocal.getTestByID(1));
            r.setDate(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
            r.setDay(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
            r.setMonth(Calendar.getInstance().get(Calendar.MONTH)+1);
            r.setYear(Calendar.getInstance().get(Calendar.YEAR));

            ResponseDAO.save(r);
            res.setResponse(r);
            ResultDAO.save(res);

            //component total_words
            EvaluationComponent[] eva = evaluationComponentBean.getComponentResults();
            ComponentResult comRes1 = new ComponentResult();
            comRes1.setEvaluationComponent(eva[0]);
            comRes1.setNumber(tester.get_total_words());
            comRes1.setDesignation("total " + tester.get_total_words() + " words");
            comRes1.setResponse(r);
            comRes1.setResult(res);
            ComponentResultDAO.save(comRes1);

            //component total_errors
            comRes1 = new ComponentResult();
            comRes1.setEvaluationComponent(eva[1]);
            comRes1.setNumber(tester.get_complex_errors()+tester.get_simple_errors());
            comRes1.setDesignation("total " + tester.get_complex_errors()+tester.get_simple_errors() + " errors");
            comRes1.setResponse(r);
            comRes1.setResult(res);
            ComponentResultDAO.save(comRes1);

            //component Readability
            comRes1 = new ComponentResult();
            comRes1.setEvaluationComponent(eva[2]);
            comRes1.setNumber(0.4*((tester.get_total_words()/tester.get_total_sentences())+100*(tester.get_complex_words()/tester.get_total_words())));
            comRes1.setDesignation(0.4*((tester.get_total_words()/tester.get_total_sentences())+100*(tester.get_complex_words()/tester.get_total_words())) + " readability");
            comRes1.setResponse(r);
            comRes1.setResult(res);
            ComponentResultDAO.save(comRes1);

            //component Perplexity
            comRes1 = new ComponentResult();
            comRes1.setEvaluationComponent(eva[3]);
            comRes1.setNumber(tester.get_bigram_perplexity());
            comRes1.setDesignation(tester.get_bigram_perplexity() + " perplexity");
            comRes1.setResponse(r);
            comRes1.setResult(res);
            ComponentResultDAO.save(comRes1);

            //component lexical_density
            comRes1 = new ComponentResult();
            comRes1.setEvaluationComponent(eva[4]);
            comRes1.setNumber(tester.get_lexical_density());
            comRes1.setDesignation(tester.get_lexical_density() + " lexical_density");
            comRes1.setResponse(r);
            comRes1.setResult(res);
            ComponentResultDAO.save(comRes1);

            //component lexical_richness
            comRes1 = new ComponentResult();
            comRes1.setEvaluationComponent(eva[5]);
            double lexical_rich=0.0;
            lexical_rich= tester.get_beyond_2000()+tester.get_advanced_ttr()+tester.get_advanced_guiraud()+
                    tester.get_ttr()+tester.get_rttr()+tester.get_cttr()+tester.get_m()+tester.get_h()+
                    tester.get_r()+tester.get_s()+tester.get_mwf();
            lexical_rich=lexical_rich/11;
            comRes1.setNumber(lexical_rich);
            comRes1.setDesignation(lexical_rich + " lexical_richness");
            comRes1.setResponse(r);
            comRes1.setResult(res);
            ComponentResultDAO.save(comRes1);



            httpSession.setAttribute("info", teste);
            String page = "writing";
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
