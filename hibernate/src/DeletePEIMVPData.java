
/**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
public class DeletePEIMVPData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = PEIMVPPersistentManager.instance().getSession().beginTransaction();
		try {
			Test test = TestDAO.loadTestByQuery(null, null);
			// Delete the persistent object
			TestDAO.delete(test);
			User user = UserDAO.loadUserByQuery(null, null);
			// Delete the persistent object
			UserDAO.delete(user);
			Response response = ResponseDAO.loadResponseByQuery(null, null);
			// Delete the persistent object
			ResponseDAO.delete(response);
			Result result = ResultDAO.loadResultByQuery(null, null);
			// Delete the persistent object
			ResultDAO.delete(result);
			EvaluationComponent evaluationComponent = EvaluationComponentDAO.loadEvaluationComponentByQuery(null, null);
			// Delete the persistent object
			EvaluationComponentDAO.delete(evaluationComponent);
			ComponentResult componentResult = ComponentResultDAO.loadComponentResultByQuery(null, null);
			// Delete the persistent object
			ComponentResultDAO.delete(componentResult);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeletePEIMVPData deletePEIMVPData = new DeletePEIMVPData();
			try {
				deletePEIMVPData.deleteTestData();
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
