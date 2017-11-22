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
        pageTitle.put("home","Anansi");
        pageTitle.put("corrector","Anansi - Correção");
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
