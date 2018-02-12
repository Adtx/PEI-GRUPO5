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

public class ContextDAO {
	public static Context loadContextByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadContextByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Context getContextByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return getContextByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Context loadContextByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadContextByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Context getContextByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return getContextByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Context loadContextByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Context) session.load(Context.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Context getContextByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Context) session.get(Context.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Context loadContextByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Context) session.load(Context.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Context getContextByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Context) session.get(Context.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryContext(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return queryContext(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryContext(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return queryContext(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Context[] listContextByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return listContextByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Context[] listContextByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return listContextByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryContext(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Context as Context");
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
	
	public static List queryContext(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Context as Context");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Context", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Context[] listContextByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryContext(session, condition, orderBy);
			return (Context[]) list.toArray(new Context[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Context[] listContextByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryContext(session, condition, orderBy, lockMode);
			return (Context[]) list.toArray(new Context[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Context loadContextByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadContextByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Context loadContextByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadContextByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Context loadContextByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Context[] contexts = listContextByQuery(session, condition, orderBy);
		if (contexts != null && contexts.length > 0)
			return contexts[0];
		else
			return null;
	}
	
	public static Context loadContextByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Context[] contexts = listContextByQuery(session, condition, orderBy, lockMode);
		if (contexts != null && contexts.length > 0)
			return contexts[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateContextByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return iterateContextByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateContextByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return iterateContextByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateContextByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Context as Context");
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
	
	public static java.util.Iterator iterateContextByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Context as Context");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Context", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Context createContext() {
		return new Context();
	}
	
	public static boolean save(Context context) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().saveObject(context);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Context context) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().deleteObject(context);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Context context)throws PersistentException {
		try {
			if (context.getCompany() != null) {
				context.getCompany().context.remove(context);
			}
			
			Response[] lResponses = context.response.toArray();
			for(int i = 0; i < lResponses.length; i++) {
				lResponses[i].setContext(null);
			}
			return delete(context);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Context context, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (context.getCompany() != null) {
				context.getCompany().context.remove(context);
			}
			
			Response[] lResponses = context.response.toArray();
			for(int i = 0; i < lResponses.length; i++) {
				lResponses[i].setContext(null);
			}
			try {
				session.delete(context);
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
	
	public static boolean refresh(Context context) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().getSession().refresh(context);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Context context) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().getSession().evict(context);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Context loadContextByCriteria(ContextCriteria contextCriteria) {
		Context[] contexts = listContextByCriteria(contextCriteria);
		if(contexts == null || contexts.length == 0) {
			return null;
		}
		return contexts[0];
	}
	
	public static Context[] listContextByCriteria(ContextCriteria contextCriteria) {
		return contextCriteria.listContext();
	}
}
