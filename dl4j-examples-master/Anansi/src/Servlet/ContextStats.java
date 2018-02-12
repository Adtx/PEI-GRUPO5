package Servlet;

import Util.CSV_Tester;
import bean.ComponentResult.ComponentResultBeanLocal;
import bean.Context.ContextBeanLocal;
import bean.EvaluationComponent.EvaluationComponentBeanLocal;
import bean.Response.ResponseBeanLocal;
import bean.Result.ResultBeanLocal;
import bean.Test.TestBean;
import bean.Test.TestBeanLocal;
import bean.User.UserBeanLocal;
import bean.util.AppConfigBeanLocal;
import bean_lookup.*;
import hibernate.*;
import org.bytedeco.javacv.FrameFilter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andrepinto on 07/02/18.
 */
@WebServlet(name = "contextStats")
@MultipartConfig
public class ContextStats extends HttpServlet {

    private final static Logger LOGGER =
            Logger.getLogger(ContextStats.class.getCanonicalName());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // --- BEANS
        AppConfigBeanLocal appConfig = AppConfigBeanLookup.getAppConfigBean();
        ContextBeanLocal contextBeanLocal = ContextBeanLookup.getContextBean();
        ResponseBeanLocal responseBeanLocal = ResponseBeanLookup.getResponserBean();
        ResultBeanLocal resultBean = ResultBeanLookup.getResultBean();
        ComponentResultBeanLocal componentResultBean = ComponentResultBeanLookup.getComponentResultBean();
        UserBeanLocal userBeanLocal = UserBeanLookup.getUserBean();
        TestBeanLocal testBeanLocal = TestBeanLookup.getTestBean();
        EvaluationComponentBeanLocal evaluationComponentBeanLocal = EvaluationComponentBeanLookup.getEvaluationComponentBean();

        HttpSession httpSession = request.getSession();


        int id;

        if(request.getParameter("id") != null)
            id = Integer.parseInt(request.getParameter("id"));
        else
            id = (int)httpSession.getAttribute("id");




        final String path = request.getParameter("description");
        String fileName = "";
        CSV_Tester csv_tester = new CSV_Tester();
        Part filePart = null;
        if(path!=null) {
            try {
                Context con = contextBeanLocal.getContextByID(id);
                filePart = request.getPart("file");
                fileName = filePart.getSubmittedFileName();
                System.out.println(fileName);
                String uploadFolder = getServletContext().getRealPath("")
                        + File.separator;
                System.out.println(uploadFolder);
                csv_tester.test_csv_file(fileName, "C:\\Users\\Pedro\\Desktop\\" + File.separator
                        + fileName, con, userBeanLocal,testBeanLocal.getTestByID(1),evaluationComponentBeanLocal.getComponentResults());
            }catch (Exception e ){
                e.printStackTrace();
            }
           /* try {
                out = new FileOutputStream(new File("/Users/andrepinto" + File.separator
                        + fileName));
                filecontent = filePart.getInputStream();

                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = filecontent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                writer.println("New file " + fileName + " created at " + path);
                LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",
                        new Object[]{fileName, path});
            } catch(Exception fne) {
                writer.println("You either did not specify a file to upload or are "
                        + "trying to upload a file to a protected or nonexistent "
                        + "location.");
                writer.println("<br/> ERROR: " + fne.getMessage());

                LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
                        new Object[]{fne.getMessage()});
            } finally {
                if (out != null) {
                    out.close();
                }
                if (filecontent != null) {
                    filecontent.close();
                }
                if (writer != null) {
                    writer.close();
                }
            }*/
        }




        try {
            Context con = contextBeanLocal.getContextByID(id);
            Response[] responses = responseBeanLocal.getContextResponse(con.getID());
            ArrayList<FullTest1> ft = new ArrayList<FullTest1>();
            ArrayList<ComponentResult> temp = null;
            for(Response r : responses){
                Result r1 = resultBean.getResult(r.getID());
                FullTest1 ft1 = new FullTest1();
                ft1.setCandidateName(r.getUser().getName());
                ft1.setResponse(r.getContent());
                ft1.setResponseID(r.getID());
                ft1.setDesignation(r1.getDesignation());
                ft1.setResult(r1.getResult().intValue());
                temp = new ArrayList<ComponentResult>();
                for (ComponentResult cr : componentResultBean.getComponentResults(r.getID())){
                    temp.add(cr);
                }


                ft1.setMetric1(""+(int)temp.get(0).getNumber());
                ft1.setMetric2(""+(int)temp.get(1).getNumber());
                ft1.setMetric3(""+temp.get(2).getNumber());
                ft1.setMetric4(""+temp.get(3).getNumber());
                ft1.setMetric5(""+temp.get(4).getNumber());
                ft1.setMetric6(""+temp.get(5).getNumber());
                ft1.setDay(r.getDay());
                ft1.setYear(r.getYear());
                ft1.setMonth(r.getMonth());
                ft.add(ft1);
            }


            FullTest1[] fts = new FullTest1[ft.size()];
            for(int i =0; i<ft.size();i++) {
                fts[i] = ft.get(i);
            }

            httpSession.setAttribute("results",fts);
        }catch (Exception e ){
            e.printStackTrace();
        }
        httpSession.setAttribute("id", id);
        // POST and GET
        String page = "contest_stats";
        request.setAttribute("req_project_name", appConfig.getProject() );
        request.setAttribute("req_page_title", appConfig.getPageTitle(page) );
        request.setAttribute("req_page_jsp_files", appConfig.getPageTemplates(page) );

        getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/template.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        }
        catch (Exception e) { e.printStackTrace(); }
    }
}
