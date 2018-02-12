package bean.Result;

import hibernate.Result;
import hibernate.ResultDAO;
import org.orm.PersistentException;

import javax.ejb.Stateless;
import java.security.NoSuchAlgorithmException;

/**
 * Created by andrepinto on 03/02/18.
 */
@Stateless (name = "ResultBean")
public class ResultBean implements ResultBeanLocal{

    public Result getResult(int responseId) throws PersistentException, NoSuchAlgorithmException {
        Result res = null;

        //MessageDigest digest = MessageDigest.getInstance("SHA-256");
        //byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        //password = String.format("%064x", new java.math.BigInteger(1, hash));
        res = ResultDAO.loadResultByQuery( "ResponseID = '" + responseId +"'", "ResponseID");

        return res;
    }
}
