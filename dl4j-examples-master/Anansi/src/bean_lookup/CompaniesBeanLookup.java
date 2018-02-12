package bean_lookup;


import bean.Company.CompaniesBeanLocal;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Created by andrepinto on 30/01/18.
 */
public class CompaniesBeanLookup {


    private static CompaniesBeanLocal companiesBeanLocal = null;

    public CompaniesBeanLookup() {}

    public static CompaniesBeanLocal getCompaniesBean() {
        if (companiesBeanLocal == null) {
            try {
                Context c = new InitialContext();
                companiesBeanLocal = (CompaniesBeanLocal) c.lookup("java:global/Anansi/CompaniesBean!bean.Company.CompaniesBeanLocal");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return companiesBeanLocal;
    }
}

