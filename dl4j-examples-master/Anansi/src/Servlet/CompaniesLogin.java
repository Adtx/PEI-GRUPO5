package Servlet;

import bean.Company.CompaniesBeanLocal;
import bean.Context.ContextBeanLocal;
import bean.Response.ResponseBeanLocal;
import bean.util.AppConfigBeanLocal;
import bean_lookup.AppConfigBeanLookup;
import bean_lookup.CompaniesBeanLookup;
import bean_lookup.ContextBeanLookup;
import bean_lookup.ResponseBeanLookup;
import hibernate.Company;
import hibernate.Context;
import hibernate.Context1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "companiesLogin")
public class CompaniesLogin extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // --- BEANS
        AppConfigBeanLocal appConfig = AppConfigBeanLookup.getAppConfigBean();
        CompaniesBeanLocal companyBean =  CompaniesBeanLookup.getCompaniesBean();
        ContextBeanLocal contextBeanLocal = ContextBeanLookup.getContextBean();
        ResponseBeanLocal responseBeanLocal = ResponseBeanLookup.getResponserBean();

        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute("register_failed");
        httpSession.removeAttribute("login_fail");

        try {


            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Company company = null;

            company = companyBean.loginCompany(email,password);

            if(company != null) {

                String page = "companyProfile";
                request.setAttribute("req_project_name", appConfig.getProject() );
                request.setAttribute("req_page_title", appConfig.getPageTitle(page) );
                request.setAttribute("req_page_jsp_files", appConfig.getPageTemplates(page) );

                httpSession.setAttribute("logged", "yes");
                httpSession.setAttribute("company", company);
                System.out.println("Login com sucesso!");
                request.removeAttribute("email");
                request.removeAttribute("password");
                try {
                    Context[] contexts = contextBeanLocal.getCompanyContexts(company.getID());
                    Context1[]context1s= new Context1[contexts.length];
                    for(int i=0;i<contexts.length;i++){
                        Context1 temp = new Context1();
                        temp.setName(contexts[i].getName());
                        temp.setCode(contexts[i].getCode());
                        temp.setID(contexts[i].getID());
                        temp.setPassword(contexts[i].getPassword());
                        temp.setStats(responseBeanLocal.getContextResponses(contexts[i].getID()));
                        context1s[i] = temp;
                    }

                    httpSession.setAttribute("contexts",context1s);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            else {
                String login_fail = "Login falhado! Volte a tentar!";
                httpSession.setAttribute("login_fail",login_fail);
                String page = "companiesHome";
                request.setAttribute("req_project_name", appConfig.getProject() );
                request.setAttribute("req_page_title", appConfig.getPageTitle(page) );
                request.setAttribute("req_page_jsp_files", appConfig.getPageTemplates(page) );
                System.out.println("Login falhado!");
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // POST and GET


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


