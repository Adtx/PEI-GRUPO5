/**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
public class CreatePEIMVPData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = PEIMVPPersistentManager.instance().getSession().beginTransaction();
		try {
			Test test = TestDAO.createTest();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : responses, Content, Description, Type
			TestDAO.save(test);
			User user = UserDAO.createUser();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : responses, Password, Email, Name
			UserDAO.save(user);
			Response response = ResponseDAO.createResponse();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : result, componentResults, test, user
			ResponseDAO.save(response);
			Result result = ResultDAO.createResult();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : componentResults, Designation, response
			ResultDAO.save(result);
			EvaluationComponent evaluationComponent = EvaluationComponentDAO.createEvaluationComponent();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : componentResults, Name
			EvaluationComponentDAO.save(evaluationComponent);
			ComponentResult componentResult = ComponentResultDAO.createComponentResult();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Designation, Number, response, result, evaluationComponent
			ComponentResultDAO.save(componentResult);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreatePEIMVPData createPEIMVPData = new CreatePEIMVPData();
			try {
				createPEIMVPData.createTestData();
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
