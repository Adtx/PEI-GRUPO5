package bean.User;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import hibernate.User;
import hibernate.UserDAO;
import org.orm.PersistentException;

import javax.ejb.Stateless;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.nio.charset.StandardCharsets;


/**
 * Created by andrepinto on 30/01/18.
 */
@Stateless(name = "UserBean")
public class UserBean implements UserBeanLocal {

    public UserBean(){}
    public User registerUser(String name, String email, String password)
            throws PersistentException, NoSuchAlgorithmException {
        User user = new User();
        user.setName(name);
        user.setEmail(email);

        //MessageDigest digest = MessageDigest.getInstance("SHA-256");
        //byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        //password = String.format("%064x", new java.math.BigInteger(1, hash));

        user.setPassword(password);

        UserDAO.save(user);

        return user;
    }

    public User loginUser(String email, String password) throws PersistentException, NoSuchAlgorithmException {
        User res = null;

        //MessageDigest digest = MessageDigest.getInstance("SHA-256");
        //byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        //password = String.format("%064x", new java.math.BigInteger(1, hash));
        res = UserDAO.loadUserByQuery( "Email = '" + email + "' AND Password = '" + password + "' ", "Email");

        return res;
    }
}

