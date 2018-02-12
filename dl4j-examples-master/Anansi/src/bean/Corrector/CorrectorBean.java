package bean.Corrector;

import org.languagetool.JLanguageTool;
import org.languagetool.language.PortugalPortuguese;
import org.languagetool.rules.Rule;
import org.languagetool.rules.RuleMatch;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrepinto on 14/11/17.
 */
@Stateless(name = "CorrectorBean")
public class CorrectorBean implements CorrectorBeanLocal {

    public CorrectorBean() {
    }


}
