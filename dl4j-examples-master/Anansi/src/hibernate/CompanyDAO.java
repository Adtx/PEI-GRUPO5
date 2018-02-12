package hibernate; /**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
import org.hibernate.Query;

import java.util.List;

public class CompanyDAO {
	public static Company loadCompanyByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadCompanyByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Company getCompanyByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return getCompanyByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Company loadCompanyByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadCompanyByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Company getCompanyByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return getCompanyByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Company loadCompanyByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Company) session.load(Company.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Company getCompanyByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Company) session.get(Company.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Company loadCompanyByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Company) session.load(Company.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Company getCompanyByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Company) session.get(Company.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCompany(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return queryCompany(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCompany(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return queryCompany(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Company[] listCompanyByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return listCompanyByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Company[] listCompanyByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return listCompanyByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCompany(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Company as Company");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCompany(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Company as Company");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Company", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Company[] listCompanyByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryCompany(session, condition, orderBy);
			return (Company[]) list.toArray(new Company[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Company[] listCompanyByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryCompany(session, condition, orderBy, lockMode);
			return (Company[]) list.toArray(new Company[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Company loadCompanyByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadCompanyByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Company loadCompanyByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadCompanyByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Company loadCompanyByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Company[] companys = listCompanyByQuery(session, condition, orderBy);
		if (companys != null && companys.length > 0)
			return companys[0];
		else
			return null;
	}
	
	public static Company loadCompanyByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Company[] companys = listCompanyByQuery(session, condition, orderBy, lockMode);
		if (companys != null && companys.length > 0)
			return companys[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCompanyByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return iterateCompanyByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCompanyByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return iterateCompanyByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCompanyByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Company as Company");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCompanyByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Company as Company");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Company", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Company createCompany() {
		return new Company();
	}
	
	public static boolean save(Company company) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().saveObject(company);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Company company) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().deleteObject(company);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Company company)throws PersistentException {
		try {
			Context[] lContexts = company.context.toArray();
			for(int i = 0; i < lContexts.length; i++) {
				lContexts[i].setCompany(null);
			}
			return delete(company);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Company company, org.orm.PersistentSession session)throws PersistentException {
		try {
			Context[] lContexts = company.context.toArray();
			for(int i = 0; i < lContexts.length; i++) {
				lContexts[i].setCompany(null);
			}
			try {
				session.delete(company);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(Company company) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().getSession().refresh(company);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Company company) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().getSession().evict(company);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Company loadCompanyByCriteria(CompanyCriteria companyCriteria) {
		Company[] companys = listCompanyByCriteria(companyCriteria);
		if(companys == null || companys.length == 0) {
			return null;
		}
		return companys[0];
	}
	
	public static Company[] listCompanyByCriteria(CompanyCriteria companyCriteria) {
		return companyCriteria.listCompany();
	}
}
