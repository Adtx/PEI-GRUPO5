
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

public class ComponentResultCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression evaluationComponentId;
	public final AssociationExpression evaluationComponent;
	public final IntegerExpression responseId;
	public final AssociationExpression response;
	public final IntegerExpression Number;
	public final StringExpression Designation;
	
	public ComponentResultCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		evaluationComponentId = new IntegerExpression("evaluationComponent.ID", this);
		evaluationComponent = new AssociationExpression("evaluationComponent", this);
		responseId = new IntegerExpression("response.ID", this);
		response = new AssociationExpression("response", this);
		Number = new IntegerExpression("Number", this);
		Designation = new StringExpression("Designation", this);
	}
	
	public ComponentResultCriteria(PersistentSession session) {
		this(session.createCriteria(ComponentResult.class));
	}
	
	public ComponentResultCriteria() throws PersistentException {
		this(PEIMVPPersistentManager.instance().getSession());
	}
	
	public EvaluationComponentCriteria createEvaluationComponentCriteria() {
		return new EvaluationComponentCriteria(createCriteria("evaluationComponent"));
	}
	
	public ResponseCriteria createResponseCriteria() {
		return new ResponseCriteria(createCriteria("response"));
	}
	
	public ComponentResult uniqueComponentResult() {
		return (ComponentResult) super.uniqueResult();
	}
	
	public ComponentResult[] listComponentResult() {
		java.util.List list = super.list();
		return (ComponentResult[]) list.toArray(new ComponentResult[list.size()]);
	}
}

