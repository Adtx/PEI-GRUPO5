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
import org.hibernate.LockMode;
import java.util.List;

public class ResponseDAO {
	public static Response loadResponseByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadResponseByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Response getResponseByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return getResponseByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Response loadResponseByORMID(int ID, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadResponseByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Response getResponseByORMID(int ID, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return getResponseByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Response loadResponseByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Response) session.load(Response.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Response getResponseByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Response) session.get(Response.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Response loadResponseByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
		try {
			return (Response) session.load(Response.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Response getResponseByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
		try {
			return (Response) session.get(Response.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryResponse(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return queryResponse(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryResponse(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return queryResponse(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Response[] listResponseByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return listResponseByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Response[] listResponseByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return listResponseByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryResponse(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Response as Response");
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
	
	public static List queryResponse(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Response as Response");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Response", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Response[] listResponseByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryResponse(session, condition, orderBy);
			return (Response[]) list.toArray(new Response[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Response[] listResponseByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			List list = queryResponse(session, condition, orderBy, lockMode);
			return (Response[]) list.toArray(new Response[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Response loadResponseByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadResponseByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Response loadResponseByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadResponseByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Response loadResponseByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Response[] responses = listResponseByQuery(session, condition, orderBy);
		if (responses != null && responses.length > 0)
			return responses[0];
		else
			return null;
	}
	
	public static Response loadResponseByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		Response[] responses = listResponseByQuery(session, condition, orderBy, lockMode);
		if (responses != null && responses.length > 0)
			return responses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateResponseByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return iterateResponseByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateResponseByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return iterateResponseByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateResponseByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Response as Response");
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
	
	public static java.util.Iterator iterateResponseByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Response as Response");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Response", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Response createResponse() {
		return new Response();
	}
	
	public static boolean save(Response response) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().saveObject(response);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Response response) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().deleteObject(response);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Response response)throws PersistentException {
		try {
			if (response.getUser() != null) {
				response.getUser().responses.remove(response);
			}
			
			if (response.getTest() != null) {
				response.getTest().responses.remove(response);
			}
			
			ComponentResult[] lComponentResultss = response.componentResults.toArray();
			for(int i = 0; i < lComponentResultss.length; i++) {
				lComponentResultss[i].setResponse(null);
			}
			if (response.getResult() != null) {
				response.getResult().setResponse(null);
			}
			
			return delete(response);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Response response, PersistentSession session)throws PersistentException {
		try {
			if (response.getUser() != null) {
				response.getUser().responses.remove(response);
			}
			
			if (response.getTest() != null) {
				response.getTest().responses.remove(response);
			}
			
			ComponentResult[] lComponentResultss = response.componentResults.toArray();
			for(int i = 0; i < lComponentResultss.length; i++) {
				lComponentResultss[i].setResponse(null);
			}
			if (response.getResult() != null) {
				response.getResult().setResponse(null);
			}
			
			try {
				session.delete(response);
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
	
	public static boolean refresh(Response response) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().getSession().refresh(response);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Response response) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().getSession().evict(response);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Response loadResponseByCriteria(ResponseCriteria responseCriteria) {
		Response[] responses = listResponseByCriteria(responseCriteria);
		if(responses == null || responses.length == 0) {
			return null;
		}
		return responses[0];
	}
	
	public static Response[] listResponseByCriteria(ResponseCriteria responseCriteria) {
		return responseCriteria.listResponse();
	}
}
