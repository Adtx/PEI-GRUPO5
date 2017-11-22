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

    public String checker() {
        JLanguageTool langTool = new JLanguageTool(new PortugalPortuguese());
        for (Rule rule : langTool.getAllRules()) {
            if (!rule.isDictionaryBasedSpellingRule()) {
                langTool.disableRule(rule.getId());
            }
        }

        List<RuleMatch> matches = null;
        List<String> info = new ArrayList<String>();

        String restul = "";
        try {
            matches = langTool.check("Um arro");
        } catch (IOException e) {
            e.printStackTrace();
        }

            restul = "Consegui!!";

    return restul;
    }
}