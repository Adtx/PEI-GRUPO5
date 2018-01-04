package hibernate;
/**
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

public class ComponentResultDAO {
	public static ComponentResult loadComponentResultByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadComponentResultByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ComponentResult getComponentResultByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return getComponentResultByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ComponentResult loadComponentResultByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadComponentResultByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ComponentResult getComponentResultByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return getComponentResultByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ComponentResult loadComponentResultByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (ComponentResult) session.load(ComponentResult.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ComponentResult getComponentResultByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (ComponentResult) session.get(ComponentResult.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ComponentResult loadComponentResultByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ComponentResult) session.load(ComponentResult.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ComponentResult getComponentResultByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ComponentResult) session.get(ComponentResult.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryComponentResult(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return queryComponentResult(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryComponentResult(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return queryComponentResult(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ComponentResult[] listComponentResultByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return listComponentResultByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ComponentResult[] listComponentResultByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return listComponentResultByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryComponentResult(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ComponentResult as ComponentResult");
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
	
	public static List queryComponentResult(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ComponentResult as ComponentResult");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ComponentResult", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ComponentResult[] listComponentResultByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryComponentResult(session, condition, orderBy);
			return (ComponentResult[]) list.toArray(new ComponentResult[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ComponentResult[] listComponentResultByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryComponentResult(session, condition, orderBy, lockMode);
			return (ComponentResult[]) list.toArray(new ComponentResult[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ComponentResult loadComponentResultByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadComponentResultByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ComponentResult loadComponentResultByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadComponentResultByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ComponentResult loadComponentResultByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		ComponentResult[] componentResults = listComponentResultByQuery(session, condition, orderBy);
		if (componentResults != null && componentResults.length > 0)
			return componentResults[0];
		else
			return null;
	}
	
	public static ComponentResult loadComponentResultByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		ComponentResult[] componentResults = listComponentResultByQuery(session, condition, orderBy, lockMode);
		if (componentResults != null && componentResults.length > 0)
			return componentResults[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateComponentResultByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return iterateComponentResultByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateComponentResultByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return iterateComponentResultByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateComponentResultByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ComponentResult as ComponentResult");
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
	
	public static java.util.Iterator iterateComponentResultByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From ComponentResult as ComponentResult");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ComponentResult", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ComponentResult createComponentResult() {
		return new ComponentResult();
	}
	
	public static boolean save(ComponentResult componentResult) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().saveObject(componentResult);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(ComponentResult componentResult) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().deleteObject(componentResult);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(ComponentResult componentResult)throws PersistentException {
		try {
			if (componentResult.getEvaluationComponent() != null) {
				//componentResult.getEvaluationComponent().componentResult.remove(componentResult);
			}
			
			if (componentResult.getResponse() != null) {
				componentResult.getResponse().componentResults.remove(componentResult);
			}
			
			return delete(componentResult);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(ComponentResult componentResult, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (componentResult.getEvaluationComponent() != null) {
				//componentResult.getEvaluationComponent().componentResult.remove(componentResult);
			}
			
			if (componentResult.getResponse() != null) {
				componentResult.getResponse().componentResults.remove(componentResult);
			}
			
			try {
				session.delete(componentResult);
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
	
	public static boolean refresh(ComponentResult componentResult) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().getSession().refresh(componentResult);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(ComponentResult componentResult) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().getSession().evict(componentResult);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ComponentResult loadComponentResultByCriteria(ComponentResultCriteria componentResultCriteria) {
		ComponentResult[] componentResults = listComponentResultByCriteria(componentResultCriteria);
		if(componentResults == null || componentResults.length == 0) {
			return null;
		}
		return componentResults[0];
	}
	
	public static ComponentResult[] listComponentResultByCriteria(ComponentResultCriteria componentResultCriteria) {
		return componentResultCriteria.listComponentResult();
	}
}
