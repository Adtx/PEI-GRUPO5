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

public class TestCriteria extends AbstractORMCriteria {
	public final StringExpression ID;
	public final IntegerExpression Type;
	public final StringExpression Description;
	public final StringExpression Content;
	public final CollectionExpression responses;
	
	public TestCriteria(Criteria criteria) {
		super(criteria);
		ID = new StringExpression("ID", this);
		Type = new IntegerExpression("Type", this);
		Description = new StringExpression("Description", this);
		Content = new StringExpression("Content", this);
		responses = new CollectionExpression("ORM_Responses", this);
	}
	
	public TestCriteria(PersistentSession session) {
		this(session.createCriteria(Test.class));
	}
	
	public TestCriteria() throws PersistentException {
		this(PEIMVPPersistentManager.instance().getSession());
	}
	
	public ResponseCriteria createResponsesCriteria() {
		return new ResponseCriteria(createCriteria("ORM_Responses"));
	}
	
	public Test uniqueTest() {
		return (Test) super.uniqueResult();
	}
	
	public Test[] listTest() {
		java.util.List list = super.list();
		return (Test[]) list.toArray(new Test[list.size()]);
	}
}

