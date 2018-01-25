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

public class EvaluationComponentDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression Name;
	public final CollectionExpression componentResults;
	
	public EvaluationComponentDetachedCriteria() {
		super(EvaluationComponent.class, EvaluationComponentCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		componentResults = new CollectionExpression("ORM_ComponentResults", this.getDetachedCriteria());
	}
	
	public EvaluationComponentDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, EvaluationComponentCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		componentResults = new CollectionExpression("ORM_ComponentResults", this.getDetachedCriteria());
	}
	
	public ComponentResultDetachedCriteria createComponentResultsCriteria() {
		return new ComponentResultDetachedCriteria(createCriteria("ORM_ComponentResults"));
	}
	
	public EvaluationComponent uniqueEvaluationComponent(PersistentSession session) {
		return (EvaluationComponent) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public EvaluationComponent[] listEvaluationComponent(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (EvaluationComponent[]) list.toArray(new EvaluationComponent[list.size()]);
	}
}

