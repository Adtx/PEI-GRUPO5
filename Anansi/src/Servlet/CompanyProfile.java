package Servlet;

import bean.util.AppConfigBeanLocal;
import bean_lookup.AppConfigBeanLookup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "companyProfile")
public class CompanyProfile extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // --- BEANS
        AppConfigBeanLocal appConfig = AppConfigBeanLookup.getAppConfigBean();

        // POST and GET
        String page = "companyProfile";
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
