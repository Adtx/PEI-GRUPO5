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
public class EvaluationComponent implements Serializable {
	public EvaluationComponent() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_EVALUATIONCOMPONENT_COMPONENTRESULTS) {
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
	
	private String Name;
	
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
	
	public void setName(String value) {
		this.Name = value;
	}
	
	public String getName() {
		return Name;
	}
	
	private void setORM_ComponentResults(java.util.Set value) {
		this.ORM_componentResults = value;
	}
	
	private java.util.Set getORM_ComponentResults() {
		return ORM_componentResults;
	}
	
	public final ComponentResultSetCollection componentResults = new ComponentResultSetCollection(this, _ormAdapter, ORMConstants.KEY_EVALUATIONCOMPONENT_COMPONENTRESULTS, ORMConstants.KEY_COMPONENTRESULT_EVALUATIONCOMPONENT, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
