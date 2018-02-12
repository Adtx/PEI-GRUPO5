package Servlet;

import bean.Context.ContextBeanLocal;
import bean.Response.ResponseBeanLocal;
import bean.util.AppConfigBeanLocal;
import bean_lookup.AppConfigBeanLookup;
import bean_lookup.ContextBeanLookup;
import bean_lookup.ResponseBeanLookup;
import hibernate.Company;
import hibernate.Context;
import hibernate.Context1;
import hibernate.ContextDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.SecureRandom;


@WebServlet(name = "companyProfile")
public class CompanyProfile extends HttpServlet {

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    String randomString( int len ){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // --- BEANS
        AppConfigBeanLocal appConfig = AppConfigBeanLookup.getAppConfigBean();
        ContextBeanLocal contextBeanLocal = ContextBeanLookup.getContextBean();
        ResponseBeanLocal responseBeanLocal = ResponseBeanLookup.getResponserBean();

        HttpSession httpSession = request.getSession();
        Company c = (Company )httpSession.getAttribute("company");
        try {
            String nome = request.getParameter("name");
            String pw = request.getParameter("pass");

            request.removeAttribute("name");
            request.removeAttribute("pass");

            if (nome != null && pw != null) {
                Context con = new Context();
                con.setName(nome);
                con.setPassword(pw);
                con.setCompany(c);
                con.setCode(randomString(16));
                while (contextBeanLocal.getContextByCode(con.getCode()) != null) {
                    con.setCode(randomString(16));
                }
                ContextDAO.save(con);
            }

            Context[] contexts = contextBeanLocal.getCompanyContexts(c.getID());
            Context1[]context1s= new Context1[contexts.length];
            for(int i=0;i<contexts.length;i++) {
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
