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

public class UserDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression Name;
	public final StringExpression Email;
	public final StringExpression Password;
	public final CollectionExpression tests;
	public final CollectionExpression responses;
	
	public UserDetachedCriteria() {
		super(User.class, UserCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		Email = new StringExpression("Email", this.getDetachedCriteria());
		Password = new StringExpression("Password", this.getDetachedCriteria());
		tests = new CollectionExpression("ORM_Tests", this.getDetachedCriteria());
		responses = new CollectionExpression("ORM_Responses", this.getDetachedCriteria());
	}
	
	public UserDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, UserCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		Name = new StringExpression("Name", this.getDetachedCriteria());
		Email = new StringExpression("Email", this.getDetachedCriteria());
		Password = new StringExpression("Password", this.getDetachedCriteria());
		tests = new CollectionExpression("ORM_Tests", this.getDetachedCriteria());
		responses = new CollectionExpression("ORM_Responses", this.getDetachedCriteria());
	}
	
	public TestDetachedCriteria createTestsCriteria() {
		return new TestDetachedCriteria(createCriteria("ORM_Tests"));
	}
	
	public ResponseDetachedCriteria createResponsesCriteria() {
		return new ResponseDetachedCriteria(createCriteria("ORM_Responses"));
	}
	
	public User uniqueUser(PersistentSession session) {
		return (User) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public User[] listUser(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (User[]) list.toArray(new User[list.size()]);
	}
}

