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
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ComponentResultDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression evaluationComponentId;
	public final AssociationExpression evaluationComponent;
	public final IntegerExpression responseId;
	public final AssociationExpression response;
	public final IntegerExpression Number;
	public final StringExpression Designation;
	
	public ComponentResultDetachedCriteria() {
		super(ComponentResult.class, ComponentResultCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		evaluationComponentId = new IntegerExpression("evaluationComponent.ID", this.getDetachedCriteria());
		evaluationComponent = new AssociationExpression("evaluationComponent", this.getDetachedCriteria());
		responseId = new IntegerExpression("response.ID", this.getDetachedCriteria());
		response = new AssociationExpression("response", this.getDetachedCriteria());
		Number = new IntegerExpression("Number", this.getDetachedCriteria());
		Designation = new StringExpression("Designation", this.getDetachedCriteria());
	}
	
	public ComponentResultDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ComponentResultCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		evaluationComponentId = new IntegerExpression("evaluationComponent.ID", this.getDetachedCriteria());
		evaluationComponent = new AssociationExpression("evaluationComponent", this.getDetachedCriteria());
		responseId = new IntegerExpression("response.ID", this.getDetachedCriteria());
		response = new AssociationExpression("response", this.getDetachedCriteria());
		Number = new IntegerExpression("Number", this.getDetachedCriteria());
		Designation = new StringExpression("Designation", this.getDetachedCriteria());
	}
	
	public EvaluationComponentDetachedCriteria createEvaluationComponentCriteria() {
		return new EvaluationComponentDetachedCriteria(createCriteria("evaluationComponent"));
	}
	
	public ResponseDetachedCriteria createResponseCriteria() {
		return new ResponseDetachedCriteria(createCriteria("response"));
	}
	
	public ComponentResult uniqueComponentResult(PersistentSession session) {
		return (ComponentResult) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ComponentResult[] listComponentResult(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ComponentResult[]) list.toArray(new ComponentResult[list.size()]);
	}
}

