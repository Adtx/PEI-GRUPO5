package bean_lookup;

import bean.Test.TestBeanLocal;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Created by andrepinto on 30/01/18.
 */
public class TestBeanLookup {


    private static TestBeanLocal testBeanLocal = null;

    public TestBeanLookup() {}

    public static TestBeanLocal getTestBean() {
        if (testBeanLocal == null) {
            try {
                Context c = new InitialContext();
                testBeanLocal = (TestBeanLocal) c.lookup("java:global/Anansi/TestBean!bean.Test.TestBeanLocal");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return testBeanLocal;
    }
}

