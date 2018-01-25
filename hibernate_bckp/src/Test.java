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
import java.io.Serializable;
public class Test implements Serializable {
	public Test() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_TEST_RESPONSES) {
			return ORM_responses;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_TEST_USER) {
			this.user = (User) owner;
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
	
	public User user;
	
	private int Type;
	
	private String Description;
	
	private String Content;
	
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
	
	public void setUser(User value) {
		if (user != null) {
			user.tests.remove(this);
		}
		if (value != null) {
			value.tests.add(this);
		}
	}
	
	public User getUser() {
		return user;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_User(User value) {
		this.user = value;
	}
	
	private User getORM_User() {
		return user;
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
