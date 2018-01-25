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
import java.io.Serializable;
public class Result implements Serializable {
	public Result() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_RESULT_COMPONENTRESULTS) {
			return ORM_componentResults;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	public Response response;
	
	private String Designation;
	
	private Double result;
	
	private java.util.Set ORM_componentResults = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDesignation(String value) {
		this.Designation = value;
	}
	
	public String getDesignation() {
		return Designation;
	}
	
	public void setResult(double value) {
		setResult(new Double(value));
	}
	
	public void setResult(Double value) {
		this.result = value;
	}
	
	public Double getResult() {
		return result;
	}
	
	public void setResponse(Response value) {
		if (this.response != value) {
			Response lresponse = this.response;
			this.response = value;
			if (value != null) {
				response.setResult(this);
			}
			if (lresponse != null && lresponse.getResult() == this) {
				lresponse.setResult(null);
			}
		}
	}
	
	public Response getResponse() {
		return response;
	}
	
	private void setORM_ComponentResults(java.util.Set value) {
		this.ORM_componentResults = value;
	}
	
	private java.util.Set getORM_ComponentResults() {
		return ORM_componentResults;
	}
	
	public final ComponentResultSetCollection componentResults = new ComponentResultSetCollection(this, _ormAdapter, ORMConstants.KEY_RESULT_COMPONENTRESULTS, ORMConstants.KEY_COMPONENTRESULT_RESULT, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
