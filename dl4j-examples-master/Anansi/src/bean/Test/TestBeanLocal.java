package bean.Test;


import hibernate.Test;
import org.orm.PersistentException;

import java.security.NoSuchAlgorithmException;

/**
 * Created by andrepinto on 03/02/18.
 */
public interface TestBeanLocal {

    public Test getTestByID(int id) throws PersistentException, NoSuchAlgorithmException;

}
