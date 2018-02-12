package bean.Test;

import hibernate.Test;
import hibernate.TestDAO;
import org.languagetool.JLanguageTool;
import org.languagetool.language.PortugalPortuguese;
import org.languagetool.rules.Rule;
import org.languagetool.rules.RuleMatch;
import org.orm.PersistentException;

import javax.ejb.Stateless;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrepinto on 14/11/17.
 */
@Stateless(name = "TestBean")
public class TestBean implements TestBeanLocal {

    public TestBean() {
    }

    public Test getTestByID(int id) throws PersistentException, NoSuchAlgorithmException {

        Test res = null;
        res = TestDAO.loadTestByQuery("ID = '" +id+"'",null);
        return res;
    }
}
