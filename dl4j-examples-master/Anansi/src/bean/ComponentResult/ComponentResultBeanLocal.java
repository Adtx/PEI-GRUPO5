package bean.ComponentResult;

import hibernate.ComponentResult;
import org.orm.PersistentException;

import java.security.NoSuchAlgorithmException;

/**
 * Created by andrepinto on 03/02/18.
 */
public interface ComponentResultBeanLocal {
    public ComponentResult[] getComponentResults(int responseId) throws PersistentException, NoSuchAlgorithmException;

}
