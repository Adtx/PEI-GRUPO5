/**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
public class ListPEIMVPData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Test...");
		Test[] tests = TestDAO.listTestByQuery(null, null);
		int length = Math.min(tests.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(tests[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing User...");
		User[] users = UserDAO.listUserByQuery(null, null);
		length = Math.min(users.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(users[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Response...");
		Response[] responses = ResponseDAO.listResponseByQuery(null, null);
		length = Math.min(responses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(responses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Result...");
		Result[] results = ResultDAO.listResultByQuery(null, null);
		length = Math.min(results.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(results[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing EvaluationComponent...");
		EvaluationComponent[] evaluationComponents = EvaluationComponentDAO.listEvaluationComponentByQuery(null, null);
		length = Math.min(evaluationComponents.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(evaluationComponents[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing ComponentResult...");
		ComponentResult[] componentResults = ComponentResultDAO.listComponentResultByQuery(null, null);
		length = Math.min(componentResults.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(componentResults[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Test by Criteria...");
		TestCriteria testCriteria = new TestCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//testCriteria.ID.eq();
		testCriteria.setMaxResults(ROW_COUNT);
		Test[] tests = testCriteria.listTest();
		int length =tests== null ? 0 : Math.min(tests.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(tests[i]);
		}
		System.out.println(length + " Test record(s) retrieved."); 
		
		System.out.println("Listing User by Criteria...");
		UserCriteria userCriteria = new UserCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//userCriteria.ID.eq();
		userCriteria.setMaxResults(ROW_COUNT);
		User[] users = userCriteria.listUser();
		length =users== null ? 0 : Math.min(users.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(users[i]);
		}
		System.out.println(length + " User record(s) retrieved."); 
		
		System.out.println("Listing Response by Criteria...");
		ResponseCriteria responseCriteria = new ResponseCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//responseCriteria.ID.eq();
		responseCriteria.setMaxResults(ROW_COUNT);
		Response[] responses = responseCriteria.listResponse();
		length =responses== null ? 0 : Math.min(responses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(responses[i]);
		}
		System.out.println(length + " Response record(s) retrieved."); 
		
		System.out.println("Listing Result by Criteria...");
		ResultCriteria resultCriteria = new ResultCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//resultCriteria.ID.eq();
		resultCriteria.setMaxResults(ROW_COUNT);
		Result[] results = resultCriteria.listResult();
		length =results== null ? 0 : Math.min(results.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(results[i]);
		}
		System.out.println(length + " Result record(s) retrieved."); 
		
		System.out.println("Listing EvaluationComponent by Criteria...");
		EvaluationComponentCriteria evaluationComponentCriteria = new EvaluationComponentCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//evaluationComponentCriteria.ID.eq();
		evaluationComponentCriteria.setMaxResults(ROW_COUNT);
		EvaluationComponent[] evaluationComponents = evaluationComponentCriteria.listEvaluationComponent();
		length =evaluationComponents== null ? 0 : Math.min(evaluationComponents.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(evaluationComponents[i]);
		}
		System.out.println(length + " EvaluationComponent record(s) retrieved."); 
		
		System.out.println("Listing ComponentResult by Criteria...");
		ComponentResultCriteria componentResultCriteria = new ComponentResultCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//componentResultCriteria.ID.eq();
		componentResultCriteria.setMaxResults(ROW_COUNT);
		ComponentResult[] componentResults = componentResultCriteria.listComponentResult();
		length =componentResults== null ? 0 : Math.min(componentResults.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(componentResults[i]);
		}
		System.out.println(length + " ComponentResult record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListPEIMVPData listPEIMVPData = new ListPEIMVPData();
			try {
				listPEIMVPData.listTestData();
				//listPEIMVPData.listByCriteria();
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
