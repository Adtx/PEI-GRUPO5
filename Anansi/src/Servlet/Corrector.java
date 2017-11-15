package Servlet;

import bean.Corrector.CorrectorBeanLocal;
import bean.util.AppConfigBeanLocal;
import bean_lookup.AppConfigBeanLookup;
import bean_lookup.CorrectorBeanLookup;
import hibernate.Info;
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
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "homepage")
public class Corrector  extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // --- BEANS
        AppConfigBeanLocal appConfig = AppConfigBeanLookup.getAppConfigBean();
        CorrectorBeanLocal correctorBean = CorrectorBeanLookup.getCorrectorBean();

        try {
            HttpSession httpSession = request.getSession();
// correctorBean.checker();

            List<Info> infos = new ArrayList<Info>();
            String teste="ERROS ====> ";
                    JLanguageTool langTool = new JLanguageTool(new PortugalPortuguese());
            //for (Rule rule : langTool.getAllRules()) {
            //    if (!rule.isDictionaryBasedSpellingRule()) {
            //        langTool.disableRule(rule.getId());
            //    }
            //}
            List<RuleMatch> matches = langTool.check("Isto é um maçã. A maca murcou.");
            for (RuleMatch match : matches) {
                System.out.println("Potential typo at line " +
                        match.getLine() + ", column " +
                        match.getColumn() + ": " + match.getMessage());
                System.out.println("Suggested correction(s): " +
                        match.getSuggestedReplacements());
                for(String s : match.getSuggestedReplacements()){
                    Info temp = new Info();
                    temp.nome = s;
                    infos.add(temp);
                    teste = teste +" , " + s;
                }

            }


            System.out.println(infos);

            httpSession.setAttribute("info", teste);
            String page = "homepage";
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
