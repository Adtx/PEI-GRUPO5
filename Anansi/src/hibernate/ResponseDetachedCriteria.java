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

public class ResponseDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression userId;
	public final AssociationExpression user;
	public final IntegerExpression testId;
	public final AssociationExpression test;
	public final StringExpression Content;
	public final CollectionExpression componentResults;
	public final IntegerExpression resultId;
	public final AssociationExpression result;
	
	public ResponseDetachedCriteria() {
		super(Response.class, ResponseCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		userId = new IntegerExpression("user.ID", this.getDetachedCriteria());
		user = new AssociationExpression("user", this.getDetachedCriteria());
		testId = new IntegerExpression("test.ID", this.getDetachedCriteria());
		test = new AssociationExpression("test", this.getDetachedCriteria());
		Content = new StringExpression("Content", this.getDetachedCriteria());
		componentResults = new CollectionExpression("ORM_ComponentResults", this.getDetachedCriteria());
		resultId = new IntegerExpression("result.ID", this.getDetachedCriteria());
		result = new AssociationExpression("result", this.getDetachedCriteria());
	}
	
	public ResponseDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ResponseCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		userId = new IntegerExpression("user.ID", this.getDetachedCriteria());
		user = new AssociationExpression("user", this.getDetachedCriteria());
		testId = new IntegerExpression("test.ID", this.getDetachedCriteria());
		test = new AssociationExpression("test", this.getDetachedCriteria());
		Content = new StringExpression("Content", this.getDetachedCriteria());
		componentResults = new CollectionExpression("ORM_ComponentResults", this.getDetachedCriteria());
		resultId = new IntegerExpression("result.ID", this.getDetachedCriteria());
		result = new AssociationExpression("result", this.getDetachedCriteria());
	}
	
	public UserDetachedCriteria createUserCriteria() {
		return new UserDetachedCriteria(createCriteria("user"));
	}
	
	public TestDetachedCriteria createTestCriteria() {
		return new TestDetachedCriteria(createCriteria("test"));
	}
	
	public ComponentResultDetachedCriteria createComponentResultsCriteria() {
		return new ComponentResultDetachedCriteria(createCriteria("ORM_ComponentResults"));
	}
	
	public ResultDetachedCriteria createResultCriteria() {
		return new ResultDetachedCriteria(createCriteria("result"));
	}
	
	public Response uniqueResponse(PersistentSession session) {
		return (Response) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Response[] listResponse(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Response[]) list.toArray(new Response[list.size()]);
	}
}

