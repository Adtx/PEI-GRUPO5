package bean.EvaluationComponent;

import hibernate.EvaluationComponent;
import org.orm.PersistentException;

import java.security.NoSuchAlgorithmException;

/**
 * Created by andrepinto on 05/02/18.
 */
public interface EvaluationComponentBeanLocal {
    public EvaluationComponent[] getComponentResults() throws PersistentException, NoSuchAlgorithmException;
}
