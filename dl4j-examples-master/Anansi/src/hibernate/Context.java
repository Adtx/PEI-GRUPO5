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
public class Context {
	public Context() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_CONTEXT_RESPONSE) {
			return ORM_response;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_CONTEXT_COMPANY) {
			this.company = (Company) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private String name;
	
	private String password;
	
	private String code;
	
	private Company company;
	
	private java.util.Set ORM_response = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setCode(String value) {
		this.code = value;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCompany(Company value) {
		if (company != null) {
			company.context.remove(this);
		}
		if (value != null) {
			value.context.add(this);
		}
	}
	
	public Company getCompany() {
		return company;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Company(Company value) {
		this.company = value;
	}
	
	private Company getORM_Company() {
		return company;
	}
	
	private void setORM_Response(java.util.Set value) {
		this.ORM_response = value;
	}
	
	private java.util.Set getORM_Response() {
		return ORM_response;
	}
	
	public final ResponseSetCollection response = new ResponseSetCollection(this, _ormAdapter, ORMConstants.KEY_CONTEXT_RESPONSE, ORMConstants.KEY_RESPONSE_CONTEXT, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
