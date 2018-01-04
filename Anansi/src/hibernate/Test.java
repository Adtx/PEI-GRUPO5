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
public class Test {
	public Test() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Test))
			return false;
		Test test = (Test)aObj;
		if ((getID() != null && !getID().equals(test.getID())) || (getID() == null && test.getID() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getID() == null ? 0 : getID().hashCode());
		return hashcode;
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_TEST_RESPONSES) {
			return ORM_responses;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private String ID;
	
	private int Type;
	
	private String Description;
	
	private String Content;
	
	private java.util.Set ORM_responses = new java.util.HashSet();
	
	public void setID(String value) {
		this.ID = value;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getORMID() {
		return getID();
	}
	
	public void setType(int value) {
		this.Type = value;
	}
	
	public int getType() {
		return Type;
	}
	
	public void setDescription(String value) {
		this.Description = value;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setContent(String value) {
		this.Content = value;
	}
	
	public String getContent() {
		return Content;
	}
	
	private void setORM_Responses(java.util.Set value) {
		this.ORM_responses = value;
	}
	
	private java.util.Set getORM_Responses() {
		return ORM_responses;
	}
	
	public final ResponseSetCollection responses = new ResponseSetCollection(this, _ormAdapter, ORMConstants.KEY_TEST_RESPONSES, ORMConstants.KEY_RESPONSE_TEST, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
