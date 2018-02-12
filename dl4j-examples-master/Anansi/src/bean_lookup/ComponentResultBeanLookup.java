package bean_lookup;

import bean.ComponentResult.ComponentResultBeanLocal;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Created by andrepinto on 30/01/18.
 */
public class ComponentResultBeanLookup {


    private static ComponentResultBeanLocal componentResultBeanLocal = null;

    public ComponentResultBeanLookup() {}

    public static ComponentResultBeanLocal getComponentResultBean() {
        if (componentResultBeanLocal == null) {
            try {
                Context c = new InitialContext();
                componentResultBeanLocal = (ComponentResultBeanLocal) c.lookup("java:global/Anansi/ComponentResultBean!bean.ComponentResult.ComponentResultBeanLocal");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return componentResultBeanLocal;
    }
}

