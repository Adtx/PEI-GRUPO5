package hibernate; /**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
public class CreatePEIMVPData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = PEIMVPPersistentManager.instance().getSession().beginTransaction();
		try {
			Test test = TestDAO.createTest();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : responses, Type
			TestDAO.save(test);
			User user = UserDAO.createUser();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : responses, password, email, Name
			UserDAO.save(user);
			Response response = ResponseDAO.createResponse();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : result, componentResults, Content, test, user
			ResponseDAO.save(response);
			Result result = ResultDAO.createResult();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Designation, response
			ResultDAO.save(result);
			EvaluationComponent evaluationComponent = EvaluationComponentDAO.createEvaluationComponent();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : componentResults
			EvaluationComponentDAO.save(evaluationComponent);
			ComponentResult componentResult = ComponentResultDAO.createComponentResult();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Number, response, evaluationComponent
			ComponentResultDAO.save(componentResult);
			Company company = CompanyDAO.createCompany();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : context, email, password, name
			CompanyDAO.save(company);
			Context context = ContextDAO.createContext();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : company, code, password, name
			ContextDAO.save(context);
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
