package bean.Context;

import hibernate.Context;
import hibernate.ContextDAO;
import org.orm.PersistentException;

import javax.ejb.Stateless;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by andrepinto on 07/02/18.
 */
@Stateless(name = "ContextBean")
public class ContextBean implements ContextBeanLocal {
    public Context[] getCompanyContexts(int companyID) throws PersistentException, NoSuchAlgorithmException {
        Context[] res = null;
        res = ContextDAO.listContextByQuery("CompanyID = '"+companyID+"'","ID");
        return res;
    }

    public Context getContextByCode(String code) throws PersistentException, NoSuchAlgorithmException{
        Context c = null;
        c = ContextDAO.loadContextByQuery("Code = '"+code+"'",null);
        return c;
    }

    public Context getContextByCodePw(String code, String pw) throws PersistentException, NoSuchAlgorithmException{
        Context c = null;
        c = ContextDAO.loadContextByQuery("Code = '"+code+"' AND Password = '" +pw+"'",null);
        return c;
    }

    public Context getContextByID(int id) throws PersistentException, NoSuchAlgorithmException{
        Context c = null;
        c = ContextDAO.loadContextByQuery("ID = '"+id+"'",null);
        return c;
    }
}
