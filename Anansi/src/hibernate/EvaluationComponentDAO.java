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

public class EvaluationComponentDAO {
	public static EvaluationComponent loadEvaluationComponentByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadEvaluationComponentByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static EvaluationComponent getEvaluationComponentByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return getEvaluationComponentByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static EvaluationComponent loadEvaluationComponentByORMID(int ID, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadEvaluationComponentByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static EvaluationComponent getEvaluationComponentByORMID(int ID, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return getEvaluationComponentByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static EvaluationComponent loadEvaluationComponentByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (EvaluationComponent) session.load(EvaluationComponent.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static EvaluationComponent getEvaluationComponentByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (EvaluationComponent) session.get(EvaluationComponent.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static EvaluationComponent loadEvaluationComponentByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
		try {
			return (EvaluationComponent) session.load(EvaluationComponent.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static EvaluationComponent getEvaluationComponentByORMID(PersistentSession session, int ID, LockMode lockMode) throws PersistentException {
		try {
			return (EvaluationComponent) session.get(EvaluationComponent.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEvaluationComponent(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return queryEvaluationComponent(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEvaluationComponent(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return queryEvaluationComponent(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static EvaluationComponent[] listEvaluationComponentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return listEvaluationComponentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static EvaluationComponent[] listEvaluationComponentByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return listEvaluationComponentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEvaluationComponent(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From EvaluationComponent as EvaluationComponent");
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
	
	public static List queryEvaluationComponent(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From EvaluationComponent as EvaluationComponent");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("EvaluationComponent", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static EvaluationComponent[] listEvaluationComponentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryEvaluationComponent(session, condition, orderBy);
			return (EvaluationComponent[]) list.toArray(new EvaluationComponent[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static EvaluationComponent[] listEvaluationComponentByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			List list = queryEvaluationComponent(session, condition, orderBy, lockMode);
			return (EvaluationComponent[]) list.toArray(new EvaluationComponent[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static EvaluationComponent loadEvaluationComponentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadEvaluationComponentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static EvaluationComponent loadEvaluationComponentByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadEvaluationComponentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static EvaluationComponent loadEvaluationComponentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		EvaluationComponent[] evaluationComponents = listEvaluationComponentByQuery(session, condition, orderBy);
		if (evaluationComponents != null && evaluationComponents.length > 0)
			return evaluationComponents[0];
		else
			return null;
	}
	
	public static EvaluationComponent loadEvaluationComponentByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		EvaluationComponent[] evaluationComponents = listEvaluationComponentByQuery(session, condition, orderBy, lockMode);
		if (evaluationComponents != null && evaluationComponents.length > 0)
			return evaluationComponents[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateEvaluationComponentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return iterateEvaluationComponentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateEvaluationComponentByQuery(String condition, String orderBy, LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return iterateEvaluationComponentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateEvaluationComponentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From EvaluationComponent as EvaluationComponent");
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
	
	public static java.util.Iterator iterateEvaluationComponentByQuery(PersistentSession session, String condition, String orderBy, LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From EvaluationComponent as EvaluationComponent");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("EvaluationComponent", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static EvaluationComponent createEvaluationComponent() {
		return new EvaluationComponent();
	}
	
	public static boolean save(EvaluationComponent evaluationComponent) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().saveObject(evaluationComponent);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(EvaluationComponent evaluationComponent) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().deleteObject(evaluationComponent);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(EvaluationComponent evaluationComponent)throws PersistentException {
		try {
			ComponentResult[] lComponentResultss = evaluationComponent.componentResults.toArray();
			for(int i = 0; i < lComponentResultss.length; i++) {
				lComponentResultss[i].setEvaluationComponent(null);
			}
			return delete(evaluationComponent);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(EvaluationComponent evaluationComponent, PersistentSession session)throws PersistentException {
		try {
			ComponentResult[] lComponentResultss = evaluationComponent.componentResults.toArray();
			for(int i = 0; i < lComponentResultss.length; i++) {
				lComponentResultss[i].setEvaluationComponent(null);
			}
			try {
				session.delete(evaluationComponent);
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
	
	public static boolean refresh(EvaluationComponent evaluationComponent) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().getSession().refresh(evaluationComponent);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(EvaluationComponent evaluationComponent) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().getSession().evict(evaluationComponent);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static EvaluationComponent loadEvaluationComponentByCriteria(EvaluationComponentCriteria evaluationComponentCriteria) {
		EvaluationComponent[] evaluationComponents = listEvaluationComponentByCriteria(evaluationComponentCriteria);
		if(evaluationComponents == null || evaluationComponents.length == 0) {
			return null;
		}
		return evaluationComponents[0];
	}
	
	public static EvaluationComponent[] listEvaluationComponentByCriteria(EvaluationComponentCriteria evaluationComponentCriteria) {
		return evaluationComponentCriteria.listEvaluationComponent();
	}
}
