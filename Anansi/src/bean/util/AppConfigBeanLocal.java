package bean.util;

import java.util.List;

/**
 * Created by andrepinto on 14/11/17.
 */
public interface AppConfigBeanLocal {


    String getProject();
    String getPageTitle(String page);
    List<String> getPageTemplates(String page);
}
