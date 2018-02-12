package Servlet;

import bean.Company.CompaniesBeanLocal;
import bean.util.AppConfigBeanLocal;
import bean_lookup.AppConfigBeanLookup;
import bean_lookup.CompaniesBeanLookup;
import hibernate.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by andrepinto on 06/02/18.
 */
@WebServlet(name = "companies")
public class Companies extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // --- BEANS
        AppConfigBeanLocal appConfig = AppConfigBeanLookup.getAppConfigBean();
        CompaniesBeanLocal companiesBean = CompaniesBeanLookup.getCompaniesBean();

        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute("results");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String password = request.getParameter("pass");

        Company c = null;
        try {
            if (nome != null && email != null && telefone != null && password != null) {
                Company temp = companiesBean.loginCompany1(email);
                if(temp == null)
                    c = companiesBean.registerCompany(nome, email, password);
                else request.setAttribute("register_failed", "Registo falhado! E-mail já registado!");
            }

            if (c != null) {
                request.setAttribute("login_company_modal", "yes");
            }

            // POST and GET
            String page = "home";
            request.setAttribute("req_project_name", appConfig.getProject());
            request.setAttribute("req_page_title", appConfig.getPageTitle(page));
            request.setAttribute("req_page_jsp_files", appConfig.getPageTemplates(page));

        } catch (Exception e) {
            e.printStackTrace();
        }
        // POST and GET
        String page = "companiesHome";
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
