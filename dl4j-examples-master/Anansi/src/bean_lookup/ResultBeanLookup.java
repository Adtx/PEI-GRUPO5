package bean_lookup;

import bean.Result.ResultBeanLocal;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Created by andrepinto on 30/01/18.
 */
public class ResultBeanLookup {


    private static ResultBeanLocal resultBeanLocal = null;

    public ResultBeanLookup() {}

    public static ResultBeanLocal getResultBean() {
        if (resultBeanLocal == null) {
            try {
                Context c = new InitialContext();
                resultBeanLocal = (ResultBeanLocal) c.lookup("java:global/Anansi/ResultBean!bean.Result.ResultBeanLocal");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return resultBeanLocal;
    }
}