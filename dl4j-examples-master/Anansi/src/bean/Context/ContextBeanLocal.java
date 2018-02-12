package bean.Context;

import hibernate.Context;
import org.orm.PersistentException;

import java.security.NoSuchAlgorithmException;

/**
 * Created by andrepinto on 07/02/18.
 */
public interface ContextBeanLocal {
    public Context[] getCompanyContexts(int companyID) throws PersistentException, NoSuchAlgorithmException;
    public Context getContextByCode(String code) throws PersistentException, NoSuchAlgorithmException;
    public Context getContextByID(int id) throws PersistentException, NoSuchAlgorithmException;
    public Context getContextByCodePw(String code, String pw) throws PersistentException, NoSuchAlgorithmException;
    }
