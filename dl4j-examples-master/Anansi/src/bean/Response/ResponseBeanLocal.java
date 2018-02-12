package bean.Response;

import hibernate.Response;
import org.orm.PersistentException;

import java.security.NoSuchAlgorithmException;

/**
 * Created by andrepinto on 03/02/18.
 */
public interface ResponseBeanLocal {

    public Response[] getUserResponses(int userid) throws PersistentException, NoSuchAlgorithmException;
    public int getContextResponses(int contextid) throws PersistentException, NoSuchAlgorithmException;
    public Response[] getContextResponse(int contextid) throws PersistentException, NoSuchAlgorithmException;
    }

