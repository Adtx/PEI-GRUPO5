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
public class User {
	public User() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_USER_TESTS) {
			return ORM_tests;
		}
		else if (key == ORMConstants.KEY_USER_RESPONSES) {
			return ORM_responses;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private String Name;
	
	private String email;
	
	private String password;
	
	private java.util.Set ORM_tests = new java.util.HashSet();
	
	private java.util.Set ORM_responses = new java.util.HashSet();
	
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
		this.Name = value;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	private void setORM_Tests(java.util.Set value) {
		this.ORM_tests = value;
	}
	
	private java.util.Set getORM_Tests() {
		return ORM_tests;
	}
	
	public final TestSetCollection tests = new TestSetCollection(this, _ormAdapter, ORMConstants.KEY_USER_TESTS, ORMConstants.KEY_TEST_USER, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Responses(java.util.Set value) {
		this.ORM_responses = value;
	}
	
	private java.util.Set getORM_Responses() {
		return ORM_responses;
	}
	
	public final ResponseSetCollection responses = new ResponseSetCollection(this, _ormAdapter, ORMConstants.KEY_USER_RESPONSES, ORMConstants.KEY_RESPONSE_USER, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
