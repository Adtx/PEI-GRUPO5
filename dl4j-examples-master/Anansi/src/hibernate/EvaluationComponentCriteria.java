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
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class EvaluationComponentCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression Name;
	public final CollectionExpression componentResults;
	
	public EvaluationComponentCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		Name = new StringExpression("Name", this);
		componentResults = new CollectionExpression("ORM_ComponentResults", this);
	}
	
	public EvaluationComponentCriteria(PersistentSession session) {
		this(session.createCriteria(EvaluationComponent.class));
	}
	
	public EvaluationComponentCriteria() throws PersistentException {
		this(PEIMVPPersistentManager.instance().getSession());
	}
	
	public ComponentResultCriteria createComponentResultsCriteria() {
		return new ComponentResultCriteria(createCriteria("ORM_ComponentResults"));
	}
	
	public EvaluationComponent uniqueEvaluationComponent() {
		return (EvaluationComponent) super.uniqueResult();
	}
	
	public EvaluationComponent[] listEvaluationComponent() {
		java.util.List list = super.list();
		return (EvaluationComponent[]) list.toArray(new EvaluationComponent[list.size()]);
	}
}

