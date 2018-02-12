package bean.Corrector;

import Util.Text_stats;
import hibernate.User;
import hibernate.UserDAO;
import org.orm.PersistentException;

/**
 * Created by danys on 29-Nov-17.
 */


public class Main {

    public static void main (String [] args) {

       String s1 = "ola eu tenho 5 palavras\ne depois mais 4";
       Util.Text_stats ts = new Text_stats();
       int i = ts.countWords(s1);
       System.out.println(i);

    }
}
