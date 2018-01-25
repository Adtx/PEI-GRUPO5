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

public class UserCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression Name;
	public final StringExpression Email;
	public final StringExpression Password;
	public final CollectionExpression tests;
	public final CollectionExpression responses;
	
	public UserCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		Name = new StringExpression("Name", this);
		Email = new StringExpression("Email", this);
		Password = new StringExpression("Password", this);
		tests = new CollectionExpression("ORM_Tests", this);
		responses = new CollectionExpression("ORM_Responses", this);
	}
	
	public UserCriteria(PersistentSession session) {
		this(session.createCriteria(User.class));
	}
	
	public UserCriteria() throws PersistentException {
		this(PEIMVPPersistentManager.instance().getSession());
	}
	
	public TestCriteria createTestsCriteria() {
		return new TestCriteria(createCriteria("ORM_Tests"));
	}
	
	public ResponseCriteria createResponsesCriteria() {
		return new ResponseCriteria(createCriteria("ORM_Responses"));
	}
	
	public User uniqueUser() {
		return (User) super.uniqueResult();
	}
	
	public User[] listUser() {
		java.util.List list = super.list();
		return (User[]) list.toArray(new User[list.size()]);
	}
}

