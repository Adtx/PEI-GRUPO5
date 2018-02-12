package bean.ComponentResult;

import hibernate.ComponentResult;
import hibernate.ComponentResultDAO;
import org.orm.PersistentException;

import javax.ejb.Stateless;
import java.security.NoSuchAlgorithmException;

/**
 * Created by andrepinto on 03/02/18.
 */
@Stateless (name = "ComponentResultBean")
public class ComponentResultBean implements ComponentResultBeanLocal{

    public ComponentResult[] getComponentResults(int responseId) throws PersistentException, NoSuchAlgorithmException {

        ComponentResult[] res = null;
        res = ComponentResultDAO.listComponentResultByQuery("ResponseID = '" + responseId + "'","EvaluationComponentID");
        return res;
    }
}
