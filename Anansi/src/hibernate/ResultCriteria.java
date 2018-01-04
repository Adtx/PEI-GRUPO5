package hibernate;
/**
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
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ResultCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression Designation;
	public final CollectionExpression componentResults;
	public final IntegerExpression responseId;
	public final AssociationExpression response;
	
	public ResultCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		Designation = new StringExpression("Designation", this);
		componentResults = new CollectionExpression("ORM_ComponentResults", this);
		responseId = new IntegerExpression("response.ID", this);
		response = new AssociationExpression("response", this);
	}
	
	public ResultCriteria(PersistentSession session) {
		this(session.createCriteria(Result.class));
	}
	
	public ResultCriteria() throws PersistentException {
		this(PEIMVPPersistentManager.instance().getSession());
	}
	
	public ComponentResultCriteria createComponentResultsCriteria() {
		return new ComponentResultCriteria(createCriteria("ORM_ComponentResults"));
	}
	
	public ResponseCriteria createResponseCriteria() {
		return new ResponseCriteria(createCriteria("response"));
	}
	
	public Result uniqueResult2() {
		return (Result) super.uniqueResult();
	}
	
	public Result[] listResult() {
		java.util.List list = super.list();
		return (Result[]) list.toArray(new Result[list.size()]);
	}
}

