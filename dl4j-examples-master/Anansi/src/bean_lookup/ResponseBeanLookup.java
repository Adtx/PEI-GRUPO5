package bean_lookup;


import bean.Response.ResponseBeanLocal;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Created by andrepinto on 30/01/18.
 */
public class ResponseBeanLookup {


    private static ResponseBeanLocal responseBeanLocal = null;

    public ResponseBeanLookup() {}

    public static ResponseBeanLocal getResponserBean() {
        if (responseBeanLocal == null) {
            try {
                Context c = new InitialContext();
                responseBeanLocal = (ResponseBeanLocal) c.lookup("java:global/Anansi/ResponseBean!bean.Response.ResponseBeanLocal");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return responseBeanLocal;
    }
}