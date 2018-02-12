package Servlet;

import bean.User.UserBean;
import bean.User.UserBeanLocal;
import bean.util.AppConfigBeanLocal;
import bean_lookup.AppConfigBeanLookup;
import bean_lookup.UserBeanLookup;
import hibernate.User;
import hibernate.UserDAO;
import org.orm.PersistentException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;




@WebServlet(name = "home")
public class Home extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // --- BEANS
        AppConfigBeanLocal appConfig = AppConfigBeanLookup.getAppConfigBean();
        UserBeanLocal userBean =  UserBeanLookup.getUserBean();

        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute("results");
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            String password = request.getParameter("pass");


            User u = null;
            try {
                if (nome != null && email != null && telefone != null && password != null) {
                    User temp = userBean.loginUser1(email);
                    if(temp == null)
                        u = userBean.registerUser(nome, email, password);
                    else request.setAttribute("register_failed", "Registo falhado! E-mail já registado!");
                }

                if (u != null) {
                    request.setAttribute("login_modal", "yes");
                }

                // POST and GET
                String page = "home";
                request.setAttribute("req_project_name", appConfig.getProject());
                request.setAttribute("req_page_title", appConfig.getPageTitle(page));
                request.setAttribute("req_page_jsp_files", appConfig.getPageTemplates(page));

            } catch (Exception e) {
                e.printStackTrace();
            }
        httpSession.removeAttribute("user");
        httpSession.removeAttribute("logged");
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


