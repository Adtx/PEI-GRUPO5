package bean.User;

import hibernate.User;
import org.orm.PersistentException;

import java.security.NoSuchAlgorithmException;

/**
 * Created by andrepinto on 14/11/17.
 */
public interface UserBeanLocal {


    public User registerUser(String name, String email, String password)throws PersistentException, NoSuchAlgorithmException;
    public User loginUser(String email, String password)throws PersistentException, NoSuchAlgorithmException;
}