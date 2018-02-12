package bean_lookup;

import bean.util.AppConfigBeanLocal;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Created by andrepinto on 14/11/17.
 */
public class AppConfigBeanLookup {

    private static AppConfigBeanLocal appconfigBeanLocal = null;

    public AppConfigBeanLookup() {}

    public static AppConfigBeanLocal getAppConfigBean() {
        if (appconfigBeanLocal == null) {
            try {
                Context c = new InitialContext();
                appconfigBeanLocal = (AppConfigBeanLocal) c.lookup("java:global/Anansi/AppConfigBean!bean.util.AppConfigBeanLocal");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return appconfigBeanLocal;
    }
}
