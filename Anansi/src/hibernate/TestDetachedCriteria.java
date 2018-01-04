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

public class TestDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression ID;
	public final IntegerExpression Type;
	public final StringExpression Description;
	public final StringExpression Content;
	public final CollectionExpression responses;
	
	public TestDetachedCriteria() {
		super(Test.class, TestCriteria.class);
		ID = new StringExpression("ID", this.getDetachedCriteria());
		Type = new IntegerExpression("Type", this.getDetachedCriteria());
		Description = new StringExpression("Description", this.getDetachedCriteria());
		Content = new StringExpression("Content", this.getDetachedCriteria());
		responses = new CollectionExpression("ORM_Responses", this.getDetachedCriteria());
	}
	
	public TestDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, TestCriteria.class);
		ID = new StringExpression("ID", this.getDetachedCriteria());
		Type = new IntegerExpression("Type", this.getDetachedCriteria());
		Description = new StringExpression("Description", this.getDetachedCriteria());
		Content = new StringExpression("Content", this.getDetachedCriteria());
		responses = new CollectionExpression("ORM_Responses", this.getDetachedCriteria());
	}
	
	public ResponseDetachedCriteria createResponsesCriteria() {
		return new ResponseDetachedCriteria(createCriteria("ORM_Responses"));
	}
	
	public Test uniqueTest(PersistentSession session) {
		return (Test) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Test[] listTest(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Test[]) list.toArray(new Test[list.size()]);
	}
}

