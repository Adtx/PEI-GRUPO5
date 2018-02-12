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

public class ContextDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression name;
	public final StringExpression password;
	public final StringExpression code;
	public final IntegerExpression companyId;
	public final AssociationExpression company;
	public final CollectionExpression response;
	
	public ContextDetachedCriteria() {
		super(Context.class, ContextCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		code = new StringExpression("code", this.getDetachedCriteria());
		companyId = new IntegerExpression("company.ID", this.getDetachedCriteria());
		company = new AssociationExpression("company", this.getDetachedCriteria());
		response = new CollectionExpression("ORM_Response", this.getDetachedCriteria());
	}
	
	public ContextDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ContextCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		code = new StringExpression("code", this.getDetachedCriteria());
		companyId = new IntegerExpression("company.ID", this.getDetachedCriteria());
		company = new AssociationExpression("company", this.getDetachedCriteria());
		response = new CollectionExpression("ORM_Response", this.getDetachedCriteria());
	}
	
	public CompanyDetachedCriteria createCompanyCriteria() {
		return new CompanyDetachedCriteria(createCriteria("company"));
	}
	
	public ResponseDetachedCriteria createResponseCriteria() {
		return new ResponseDetachedCriteria(createCriteria("ORM_Response"));
	}
	
	public Context uniqueContext(PersistentSession session) {
		return (Context) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Context[] listContext(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Context[]) list.toArray(new Context[list.size()]);
	}
}

