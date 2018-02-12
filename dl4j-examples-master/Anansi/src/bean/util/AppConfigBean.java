package bean.util;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by andrepinto on 14/11/17.
 */

@Stateless(name = "AppConfigBean")
public class AppConfigBean implements AppConfigBeanLocal {
    private static final String project = "Anansi";

    private static final HashMap<String,String> pageTitle;
    private static final HashMap<String,List<String>> pageTemplates;
    static {
        //--- < URL-PATH, PAGE TITLE > ---//
        pageTitle = new HashMap<String,String>();
        pageTitle.put("home","Anansi - Home");
        pageTitle.put("corrector","Anansi - Evaluation");
        pageTitle.put("profile", "Anansi - User Profile");
        pageTitle.put("companyProfile", "Anansi - Company Profile");
        pageTitle.put("writing", " Anansi - Writting");
        pageTitle.put("companiesHome", "Anansi - Companies");
        pageTitle.put("contest_stats", "Anansi - Context Statistics");



        //--- < URL-PATH, JSP FILE LIST > ---//
        pageTemplates = new HashMap<String,List<String>>();

        List homepage = new ArrayList<String>();
        homepage.add("util/homepage.jsp");
        pageTemplates.put("home",homepage);

        List empresas = new ArrayList<String>();
        empresas.add("util/companiesHome.jsp");
        pageTemplates.put("companiesHome",empresas);

        List correcao = new ArrayList<String>();
        correcao.add("util/corrector.jsp");
        pageTemplates.put("corrector",correcao);

        List profile = new ArrayList<String>();
        profile.add("util/profile.jsp");
        pageTemplates.put("profile",profile);

        List company_profile = new ArrayList<String>();
        company_profile.add("util/company_profile.jsp");
        pageTemplates.put("companyProfile",company_profile);

        List context_stats = new ArrayList<String>();
        context_stats.add("util/context_statistics.jsp");
        pageTemplates.put("contest_stats",context_stats);

        List writing = new ArrayList<String>();
        writing.add("util/writing.jsp");
        pageTemplates.put("writing",writing);

    }

    public AppConfigBean() { }

    public String getProject() { return project; }

    public String getPageTitle(String page) {
        return pageTitle.get(page);
    };

    public List<String> getPageTemplates(String page) {
        return pageTemplates.get(page);
    }
}
