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

public class TestDAO {
	public static Test loadTestByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadTestByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Test getTestByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return getTestByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Test loadTestByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadTestByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Test getTestByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return getTestByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Test loadTestByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Test) session.load(Test.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Test getTestByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Test) session.get(Test.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Test loadTestByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Test) session.load(Test.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Test getTestByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Test) session.get(Test.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTest(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return queryTest(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTest(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return queryTest(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Test[] listTestByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return listTestByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Test[] listTestByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return listTestByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTest(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Test as Test");
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
	
	public static List queryTest(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Test as Test");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Test", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Test[] listTestByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryTest(session, condition, orderBy);
			return (Test[]) list.toArray(new Test[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Test[] listTestByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryTest(session, condition, orderBy, lockMode);
			return (Test[]) list.toArray(new Test[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Test loadTestByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadTestByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Test loadTestByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return loadTestByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Test loadTestByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Test[] tests = listTestByQuery(session, condition, orderBy);
		if (tests != null && tests.length > 0)
			return tests[0];
		else
			return null;
	}
	
	public static Test loadTestByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Test[] tests = listTestByQuery(session, condition, orderBy, lockMode);
		if (tests != null && tests.length > 0)
			return tests[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateTestByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return iterateTestByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTestByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = PEIMVPPersistentManager.instance().getSession();
			return iterateTestByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTestByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Test as Test");
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
	
	public static java.util.Iterator iterateTestByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Test as Test");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Test", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Test createTest() {
		return new Test();
	}
	
	public static boolean save(Test test) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().saveObject(test);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(Test test) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().deleteObject(test);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Test test)throws PersistentException {
		try {
			if (test.getUser() != null) {
				test.getUser().tests.remove(test);
			}
			
			Response[] lResponsess = test.responses.toArray();
			for(int i = 0; i < lResponsess.length; i++) {
				lResponsess[i].setTest(null);
			}
			return delete(test);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(Test test, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (test.getUser() != null) {
				test.getUser().tests.remove(test);
			}
			
			Response[] lResponsess = test.responses.toArray();
			for(int i = 0; i < lResponsess.length; i++) {
				lResponsess[i].setTest(null);
			}
			try {
				session.delete(test);
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
	
	public static boolean refresh(Test test) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().getSession().refresh(test);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(Test test) throws PersistentException {
		try {
			PEIMVPPersistentManager.instance().getSession().evict(test);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Test loadTestByCriteria(TestCriteria testCriteria) {
		Test[] tests = listTestByCriteria(testCriteria);
		if(tests == null || tests.length == 0) {
			return null;
		}
		return tests[0];
	}
	
	public static Test[] listTestByCriteria(TestCriteria testCriteria) {
		return testCriteria.listTest();
	}
}
