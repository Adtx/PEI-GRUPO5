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
public class ComponentResult implements Serializable {
	public ComponentResult() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_COMPONENTRESULT_RESPONSE) {
			this.response = (Response) owner;
		}
		
		else if (key == ORMConstants.KEY_COMPONENTRESULT_RESULT) {
			this.result = (Result) owner;
		}
		
		else if (key == ORMConstants.KEY_COMPONENTRESULT_EVALUATIONCOMPONENT) {
			this.evaluationComponent = (EvaluationComponent) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	public EvaluationComponent evaluationComponent;
	
	public Result result;
	
	public Response response;
	
	private double Number;
	
	private String Designation;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setNumber(double value) {
		this.Number = value;
	}
	
	public double getNumber() {
		return Number;
	}
	
	public void setDesignation(String value) {
		this.Designation = value;
	}
	
	public String getDesignation() {
		return Designation;
	}
	
	public void setResponse(Response value) {
		if (response != null) {
			response.componentResults.remove(this);
		}
		if (value != null) {
			value.componentResults.add(this);
		}
	}
	
	public Response getResponse() {
		return response;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Response(Response value) {
		this.response = value;
	}
	
	private Response getORM_Response() {
		return response;
	}
	
	public void setResult(Result value) {
		if (result != null) {
			result.componentResults.remove(this);
		}
		if (value != null) {
			value.componentResults.add(this);
		}
	}
	
	public Result getResult() {
		return result;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Result(Result value) {
		this.result = value;
	}
	
	private Result getORM_Result() {
		return result;
	}
	
	public void setEvaluationComponent(EvaluationComponent value) {
		if (evaluationComponent != null) {
			evaluationComponent.componentResults.remove(this);
		}
		if (value != null) {
			value.componentResults.add(this);
		}
	}
	
	public EvaluationComponent getEvaluationComponent() {
		return evaluationComponent;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_EvaluationComponent(EvaluationComponent value) {
		this.evaluationComponent = value;
	}
	
	private EvaluationComponent getORM_EvaluationComponent() {
		return evaluationComponent;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
