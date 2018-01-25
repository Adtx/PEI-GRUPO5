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
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ResultDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression responseId;
	public final AssociationExpression response;
	public final StringExpression Designation;
	public final DoubleExpression result;
	public final CollectionExpression componentResults;
	
	public ResultDetachedCriteria() {
		super(Result.class, ResultCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		responseId = new IntegerExpression("response.ID", this.getDetachedCriteria());
		response = new AssociationExpression("response", this.getDetachedCriteria());
		Designation = new StringExpression("Designation", this.getDetachedCriteria());
		result = new DoubleExpression("result", this.getDetachedCriteria());
		componentResults = new CollectionExpression("ORM_ComponentResults", this.getDetachedCriteria());
	}
	
	public ResultDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ResultCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		responseId = new IntegerExpression("response.ID", this.getDetachedCriteria());
		response = new AssociationExpression("response", this.getDetachedCriteria());
		Designation = new StringExpression("Designation", this.getDetachedCriteria());
		result = new DoubleExpression("result", this.getDetachedCriteria());
		componentResults = new CollectionExpression("ORM_ComponentResults", this.getDetachedCriteria());
	}
	
	public ResponseDetachedCriteria createResponseCriteria() {
		return new ResponseDetachedCriteria(createCriteria("response"));
	}
	
	public ComponentResultDetachedCriteria createComponentResultsCriteria() {
		return new ComponentResultDetachedCriteria(createCriteria("ORM_ComponentResults"));
	}
	
	public Result uniqueResult2(PersistentSession session) {
		return (Result) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Result[] listResult(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Result[]) list.toArray(new Result[list.size()]);
	}
}

