package bean.Result;

import hibernate.Result;
import org.orm.PersistentException;

import java.security.NoSuchAlgorithmException;

/**
 * Created by andrepinto on 03/02/18.
 */
public interface ResultBeanLocal {
    public Result getResult(int responseId) throws PersistentException, NoSuchAlgorithmException;
}
