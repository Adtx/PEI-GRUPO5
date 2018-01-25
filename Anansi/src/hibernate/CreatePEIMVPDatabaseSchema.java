package hibernate; /**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
public class CreatePEIMVPDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(PEIMVPPersistentManager.instance());
			PEIMVPPersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
