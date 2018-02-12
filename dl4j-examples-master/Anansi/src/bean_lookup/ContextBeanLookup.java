package bean_lookup;

import bean.Context.ContextBeanLocal;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Created by andrepinto on 30/01/18.
 */
public class ContextBeanLookup {


    private static ContextBeanLocal contextBeanLocal = null;

    public ContextBeanLookup() {}

    public static ContextBeanLocal getContextBean() {
        if (contextBeanLocal == null) {
            try {
                Context c = new InitialContext();
                contextBeanLocal = (ContextBeanLocal) c.lookup("java:global/Anansi/ContextBean!bean.Context.ContextBeanLocal");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return contextBeanLocal;
    }
}

