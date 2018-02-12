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




@WebServlet(name = "login")
public class Login extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // --- BEANS
        AppConfigBeanLocal appConfig = AppConfigBeanLookup.getAppConfigBean();
        UserBeanLocal userBean =  UserBeanLookup.getUserBean();

        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute("register_failed");
        httpSession.removeAttribute("login_fail");

        try {


            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = null;

            user = userBean.loginUser(email,password);

            if(user != null) {

                String page = "writing";
                request.setAttribute("req_project_name", appConfig.getProject() );
                request.setAttribute("req_page_title", appConfig.getPageTitle(page) );
                request.setAttribute("req_page_jsp_files", appConfig.getPageTemplates(page) );

                httpSession.setAttribute("logged", "yes");
                httpSession.setAttribute("user", user);
                System.out.println("Login com sucesso!");
            }
            else {
                String login_fail = "Login falhado! Volte a tentar!";
                httpSession.setAttribute("login_fail",login_fail);
                String page = "home";
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


