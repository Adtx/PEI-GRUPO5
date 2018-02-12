package bean.Company;

import hibernate.Company;
import org.orm.PersistentException;

import java.security.NoSuchAlgorithmException;

/**
 * Created by andrepinto on 06/02/18.
 */
public interface CompaniesBeanLocal {
    public Company registerCompany(String name, String email, String password) throws PersistentException, NoSuchAlgorithmException;
    public Company loginCompany1(String email) throws PersistentException, NoSuchAlgorithmException;
    public Company loginCompany(String email, String password) throws PersistentException, NoSuchAlgorithmException;



    }
