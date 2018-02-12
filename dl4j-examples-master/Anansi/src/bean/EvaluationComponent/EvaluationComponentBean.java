package bean.EvaluationComponent;

import hibernate.EvaluationComponent;
import hibernate.EvaluationComponentDAO;
import org.orm.PersistentException;

import javax.ejb.Stateless;
import java.security.NoSuchAlgorithmException;

/**
 * Created by andrepinto on 05/02/18.
 */
@Stateless(name = "EvaluationComponentBean")
public class EvaluationComponentBean implements EvaluationComponentBeanLocal{

    public EvaluationComponent[] getComponentResults() throws PersistentException, NoSuchAlgorithmException {

        EvaluationComponent[] res = null;
        res = EvaluationComponentDAO.listEvaluationComponentByQuery(null,"ID");
        return res;
    }
}
