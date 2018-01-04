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

public class ResponseCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression resultId;
	public final AssociationExpression result;
	public final IntegerExpression userId;
	public final AssociationExpression user;
	public final StringExpression testId;
	public final AssociationExpression test;
	public final StringExpression Content;
	public final CollectionExpression componentResults;
	
	public ResponseCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		resultId = new IntegerExpression("result.ID", this);
		result = new AssociationExpression("result", this);
		userId = new IntegerExpression("user.ID", this);
		user = new AssociationExpression("user", this);
		testId = new StringExpression("test.ID", this);
		test = new AssociationExpression("test", this);
		Content = new StringExpression("Content", this);
		componentResults = new CollectionExpression("ORM_ComponentResults", this);
	}
	
	public ResponseCriteria(PersistentSession session) {
		this(session.createCriteria(Response.class));
	}
	
	public ResponseCriteria() throws PersistentException {
		this(PEIMVPPersistentManager.instance().getSession());
	}
	
	public ResultCriteria createResultCriteria() {
		return new ResultCriteria(createCriteria("result"));
	}
	
	public UserCriteria createUserCriteria() {
		return new UserCriteria(createCriteria("user"));
	}
	
	public TestCriteria createTestCriteria() {
		return new TestCriteria(createCriteria("test"));
	}
	
	public ComponentResultCriteria createComponentResultsCriteria() {
		return new ComponentResultCriteria(createCriteria("ORM_ComponentResults"));
	}
	
	public Response uniqueResponse() {
		return (Response) super.uniqueResult();
	}
	
	public Response[] listResponse() {
		java.util.List list = super.list();
		return (Response[]) list.toArray(new Response[list.size()]);
	}
}

