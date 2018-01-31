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

            String nome = request.getParameter("nome");
            System.out.println(nome);
            String email = request.getParameter("email");
            System.out.println(email);
            String telefone = request.getParameter("telefone");
            System.out.println(telefone);
            String password = request.getParameter("pass");
            System.out.println(password);
            User u = null;
            try {
                if (nome != null || email != null || telefone != null || password != null) {
                    u = userBean.registerUser(nome, email, password);
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


