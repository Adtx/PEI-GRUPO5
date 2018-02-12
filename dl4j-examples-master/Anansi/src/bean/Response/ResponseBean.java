package bean.Response;

import hibernate.Response;
import hibernate.ResponseDAO;
import org.orm.PersistentException;

import javax.ejb.Stateless;
import java.security.NoSuchAlgorithmException;

/**
 * Created by andrepinto on 03/02/18.
 */

@Stateless(name = "ResponseBean")
public class ResponseBean implements ResponseBeanLocal{



    public Response[] getUserResponses(int userid) throws PersistentException, NoSuchAlgorithmException {
        Response[] res = null;

       res = ResponseDAO.listResponseByQuery( "UserID = '" + userid + "'" , "Date");

        return res;
    }

    public int getContextResponses(int contextid) throws PersistentException, NoSuchAlgorithmException {
        Response[] res = null;

        res = ResponseDAO.listResponseByQuery( "ContextID = '" + contextid + "'" , null);

        return res.length;
    }
    public Response[] getContextResponse(int contextid) throws PersistentException, NoSuchAlgorithmException {
        Response[] res = null;

        res = ResponseDAO.listResponseByQuery( "ContextID = '" + contextid + "'" , null);

        return res;
    }

}
