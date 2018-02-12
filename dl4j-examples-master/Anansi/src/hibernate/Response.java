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
public class Response {
	public Response() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_RESPONSE_COMPONENTRESULTS) {
			return ORM_componentResults;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_RESPONSE_TEST) {
			this.test = (Test) owner;
		}
		
		else if (key == ORMConstants.KEY_RESPONSE_USER) {
			this.user = (User) owner;
		}
		
		else if (key == ORMConstants.KEY_RESPONSE_CONTEXT) {
			this.context = (Context) owner;
		}
		
		else if (key == ORMConstants.KEY_RESPONSE_RESULT) {
			this.result = (Result) owner;
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
	
	public Test test;
	
	private String Content;
	
	private java.sql.Timestamp date;
	
	private Integer month;
	
	private Integer day;
	
	private Integer year;
	
	private Context context;
	
	private java.util.Set ORM_componentResults = new java.util.HashSet();
	
	public Result result;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setContent(String value) {
		this.Content = value;
	}
	
	public String getContent() {
		return Content;
	}
	
	public void setDate(java.sql.Timestamp value) {
		this.date = value;
	}
	
	public java.sql.Timestamp getDate() {
		return date;
	}
	
	public void setMonth(int value) {
		setMonth(new Integer(value));
	}
	
	public void setMonth(Integer value) {
		this.month = value;
	}
	
	public Integer getMonth() {
		return month;
	}
	
	public void setDay(int value) {
		setDay(new Integer(value));
	}
	
	public void setDay(Integer value) {
		this.day = value;
	}
	
	public Integer getDay() {
		return day;
	}
	
	public void setYear(int value) {
		setYear(new Integer(value));
	}
	
	public void setYear(Integer value) {
		this.year = value;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public void setTest(Test value) {
		if (test != null) {
			test.responses.remove(this);
		}
		if (value != null) {
			value.responses.add(this);
		}
	}
	
	public Test getTest() {
		return test;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Test(Test value) {
		this.test = value;
	}
	
	private Test getORM_Test() {
		return test;
	}
	
	public void setUser(User value) {
		if (user != null) {
			user.responses.remove(this);
		}
		if (value != null) {
			value.responses.add(this);
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
	
	public void setContext(Context value) {
		if (context != null) {
			context.response.remove(this);
		}
		if (value != null) {
			value.response.add(this);
		}
	}
	
	public Context getContext() {
		return context;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Context(Context value) {
		this.context = value;
	}
	
	private Context getORM_Context() {
		return context;
	}
	
	private void setORM_ComponentResults(java.util.Set value) {
		this.ORM_componentResults = value;
	}
	
	private java.util.Set getORM_ComponentResults() {
		return ORM_componentResults;
	}
	
	public final ComponentResultSetCollection componentResults = new ComponentResultSetCollection(this, _ormAdapter, ORMConstants.KEY_RESPONSE_COMPONENTRESULTS, ORMConstants.KEY_COMPONENTRESULT_RESPONSE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setResult(Result value) {
		if (this.result != value) {
			Result lresult = this.result;
			this.result = value;
			if (value != null) {
				result.setResponse(this);
			}
			if (lresult != null && lresult.getResponse() == this) {
				lresult.setResponse(null);
			}
		}
	}
	
	public Result getResult() {
		return result;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
