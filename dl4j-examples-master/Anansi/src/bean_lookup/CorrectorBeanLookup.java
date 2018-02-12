package bean_lookup;

import javax.naming.Context;
import javax.naming.InitialContext;
import bean.Corrector.CorrectorBeanLocal;
/**
 * Created by andrepinto on 14/11/17.
 */
public class CorrectorBeanLookup {

    private static CorrectorBeanLocal correctorBeanLocal = null;

    public CorrectorBeanLookup() {}

    public static CorrectorBeanLocal getCorrectorBean() {
        if (correctorBeanLocal == null) {
            try {
                Context c = new InitialContext();
                correctorBeanLocal = (CorrectorBeanLocal) c.lookup("java:global/Anansi/CorrectorBean!bean.Corrector.CorrectorBeanLocal");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return correctorBeanLocal;
    }
}
