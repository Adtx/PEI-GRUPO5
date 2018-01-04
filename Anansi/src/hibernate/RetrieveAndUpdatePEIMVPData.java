package hibernate;
/**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
public class RetrieveAndUpdatePEIMVPData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = PEIMVPPersistentManager.instance().getSession().beginTransaction();
		try {
			Test test = TestDAO.loadTestByQuery(null, null);
			// Update the properties of the persistent object
			TestDAO.save(test);
			User user = UserDAO.loadUserByQuery(null, null);
			// Update the properties of the persistent object
			UserDAO.save(user);
			Response response = ResponseDAO.loadResponseByQuery(null, null);
			// Update the properties of the persistent object
			ResponseDAO.save(response);
			Result result = ResultDAO.loadResultByQuery(null, null);
			// Update the properties of the persistent object
			ResultDAO.save(result);
			EvaluationComponent evaluationComponent = EvaluationComponentDAO.loadEvaluationComponentByQuery(null, null);
			// Update the properties of the persistent object
			EvaluationComponentDAO.save(evaluationComponent);
			ComponentResult componentResult = ComponentResultDAO.loadComponentResultByQuery(null, null);
			// Update the properties of the persistent object
			ComponentResultDAO.save(componentResult);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Test by TestCriteria");
		TestCriteria testCriteria = new TestCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//testCriteria.ID.eq();
		System.out.println(testCriteria.uniqueTest());
		
		System.out.println("Retrieving User by UserCriteria");
		UserCriteria userCriteria = new UserCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//userCriteria.ID.eq();
		System.out.println(userCriteria.uniqueUser());
		
		System.out.println("Retrieving Response by ResponseCriteria");
		ResponseCriteria responseCriteria = new ResponseCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//responseCriteria.ID.eq();
		System.out.println(responseCriteria.uniqueResponse());
		
		System.out.println("Retrieving Result by ResultCriteria");
		ResultCriteria resultCriteria = new ResultCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//resultCriteria.ID.eq();
		System.out.println(resultCriteria.uniqueResult());
		
		System.out.println("Retrieving EvaluationComponent by EvaluationComponentCriteria");
		EvaluationComponentCriteria evaluationComponentCriteria = new EvaluationComponentCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//evaluationComponentCriteria.ID.eq();
		System.out.println(evaluationComponentCriteria.uniqueEvaluationComponent());
		
		System.out.println("Retrieving ComponentResult by ComponentResultCriteria");
		ComponentResultCriteria componentResultCriteria = new ComponentResultCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//componentResultCriteria.ID.eq();
		System.out.println(componentResultCriteria.uniqueComponentResult());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdatePEIMVPData retrieveAndUpdatePEIMVPData = new RetrieveAndUpdatePEIMVPData();
			try {
				retrieveAndUpdatePEIMVPData.retrieveAndUpdateTestData();
				//retrieveAndUpdatePEIMVPData.retrieveByCriteria();
			}
			finally {
				PEIMVPPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
