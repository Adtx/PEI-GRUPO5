package bean_lookup;

import bean.EvaluationComponent.EvaluationComponentBeanLocal;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Created by andrepinto on 05/02/18.
 */
public class EvaluationComponentBeanLookup {

    private static EvaluationComponentBeanLocal evaluationComponentBeanLocal = null;

    public EvaluationComponentBeanLookup() {}

    public static EvaluationComponentBeanLocal getEvaluationComponentBean() {
        if (evaluationComponentBeanLocal == null) {
            try {
                Context c = new InitialContext();
                evaluationComponentBeanLocal = (EvaluationComponentBeanLocal) c.lookup("java:global/Anansi/EvaluationComponentBean!bean.EvaluationComponent.EvaluationComponentBeanLocal");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return evaluationComponentBeanLocal;
    }
}
