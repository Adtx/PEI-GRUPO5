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

public class ContextCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression name;
	public final StringExpression password;
	public final StringExpression code;
	public final IntegerExpression companyId;
	public final AssociationExpression company;
	public final CollectionExpression response;
	
	public ContextCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		name = new StringExpression("name", this);
		password = new StringExpression("password", this);
		code = new StringExpression("code", this);
		companyId = new IntegerExpression("company.ID", this);
		company = new AssociationExpression("company", this);
		response = new CollectionExpression("ORM_Response", this);
	}
	
	public ContextCriteria(PersistentSession session) {
		this(session.createCriteria(Context.class));
	}
	
	public ContextCriteria() throws PersistentException {
		this(PEIMVPPersistentManager.instance().getSession());
	}
	
	public CompanyCriteria createCompanyCriteria() {
		return new CompanyCriteria(createCriteria("company"));
	}
	
	public ResponseCriteria createResponseCriteria() {
		return new ResponseCriteria(createCriteria("ORM_Response"));
	}
	
	public Context uniqueContext() {
		return (Context) super.uniqueResult();
	}
	
	public Context[] listContext() {
		java.util.List list = super.list();
		return (Context[]) list.toArray(new Context[list.size()]);
	}
}

