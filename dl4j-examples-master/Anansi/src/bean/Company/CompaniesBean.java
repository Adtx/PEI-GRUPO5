package bean.Company;

import Servlet.Companies;
import hibernate.Company;
import hibernate.CompanyDAO;
import hibernate.Context;
import org.orm.PersistentException;
import play.api.libs.iteratee.Cont;

import javax.ejb.Stateless;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by andrepinto on 06/02/18.
 */
@Stateless(name = "CompaniesBean")

public class CompaniesBean implements CompaniesBeanLocal{
    public Company registerCompany(String name, String email, String password)
            throws PersistentException, NoSuchAlgorithmException {
        Company company = new Company();
        company.setName(name);
        company.setEmail(email);

        company.setPassword(password);

        CompanyDAO.save(company);

        return company;
    }

    public Company loginCompany1(String email) throws PersistentException, NoSuchAlgorithmException {
        Company res = null;

        res = CompanyDAO.loadCompanyByQuery( "Email = '" + email + "'", "Email");

        return res;
    }
    public Company loginCompany(String email, String password) throws PersistentException, NoSuchAlgorithmException {
        Company res = null;

        res = CompanyDAO.loadCompanyByQuery( "Email = '" + email + "' AND Password = '" + password + "' ", "Email");

        return res;
    }


}
