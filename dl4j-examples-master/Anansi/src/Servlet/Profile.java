package Servlet;

import bean.ComponentResult.ComponentResultBeanLocal;
import bean.Response.ResponseBeanLocal;
import bean.Result.ResultBeanLocal;
import bean.util.AppConfigBeanLocal;
import bean_lookup.AppConfigBeanLookup;
import bean_lookup.ComponentResultBeanLookup;
import bean_lookup.ResponseBeanLookup;
import bean_lookup.ResultBeanLookup;
import hibernate.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "profile")
public class Profile extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // --- BEANS
        AppConfigBeanLocal appConfig = AppConfigBeanLookup.getAppConfigBean();
        ResponseBeanLocal responseBean = ResponseBeanLookup.getResponserBean();
        ResultBeanLocal resultBean = ResultBeanLookup.getResultBean();
        ComponentResultBeanLocal componentResultBean = ComponentResultBeanLookup.getComponentResultBean();

        ArrayList<FullTeste> ft = new ArrayList<FullTeste>();
        HttpSession httpSession = request.getSession();
        User u = (User) httpSession.getAttribute("user");
        try {
            Response[] responses = responseBean.getUserResponses(u.getID());
            ArrayList<ComponentResult> temp = null;
            for(Response r : responses){
                Result r1 = resultBean.getResult(r.getID());
                FullTeste ft1 = new FullTeste();
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


            FullTeste[] fts = new FullTeste[ft.size()];
            for(int i =0; i<ft.size();i++) {
                fts[i] = ft.get(i);
            }
            httpSession.setAttribute("results",fts);
        }catch (Exception e){
            e.printStackTrace();
        }

        // POST and GET
        String page = "profile";
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
