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
        pageTitle.put("corrector","Anansi - Correção");
        pageTitle.put("profile", "Anansi - Perfil de Utilizador");
        pageTitle.put("companyProfile", "Anansi - Perfil da Empresa");
        pageTitle.put("writing", " Anansi - Escrita");
        //pageTitle.put("register","Registar");
        //pageTitle.put("my_account","A minha conta");
        //pageTitle.put("client_area","Área de cliente");
        //pageTitle.put("owner_area","Área de proprietário");
        //pageTitle.put("admin_area","Área de adminstrador");
        //pageTitle.put("notifications","Notificações");
        //pageTitle.put("search","Pesquisar parque");
        //pageTitle.put("user_details","Detalhes de utilizador");
        //pageTitle.put("contacts", "Contactos");
        //pageTitle.put("faq", "FAQs");
        //pageTitle.put("sitemap", "Mapa do Site");



        //--- < URL-PATH, JSP FILE LIST > ---//
        pageTemplates = new HashMap<String,List<String>>();

        List homepage = new ArrayList<String>();
        homepage.add("util/homepage.jsp");
        pageTemplates.put("home",homepage);

        List correcao = new ArrayList<String>();
        correcao.add("util/corrector.jsp");
        pageTemplates.put("corrector",correcao);

        List profile = new ArrayList<String>();
        profile.add("util/profile.jsp");
        pageTemplates.put("profile",profile);

        List company_profile = new ArrayList<String>();
        company_profile.add("util/company_profile.jsp");
        pageTemplates.put("companyProfile",company_profile);

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
