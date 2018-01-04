package bean.Corrector;

import hibernate.User;
import hibernate.UserDAO;
import org.orm.PersistentException;

/**
 * Created by danys on 29-Nov-17.
 */


public class Main {

    public static void main (String [] args) {

        User u = new User();

        u.setName("AnansiRoot");

        try {
            UserDAO.save(u);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }
}
