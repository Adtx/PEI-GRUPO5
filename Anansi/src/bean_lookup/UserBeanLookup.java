package bean_lookup;

import bean.User.UserBeanLocal;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Created by andrepinto on 30/01/18.
 */
public class UserBeanLookup {


    private static UserBeanLocal userBeanLocal = null;

    public UserBeanLookup() {}

    public static UserBeanLocal getUserBean() {
        if (userBeanLocal == null) {
            try {
                Context c = new InitialContext();
                userBeanLocal = (UserBeanLocal) c.lookup("java:global/Anansi/UserBean!bean.User.UserBeanLocal");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return userBeanLocal;
    }
}





