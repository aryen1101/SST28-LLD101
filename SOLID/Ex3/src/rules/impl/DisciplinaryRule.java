package rules.impl;

import entities.StudentProfile;
import helper.LegacyFlags;
import rules.EligibilityRule;

public class DisciplinaryRule implements EligibilityRule {
    @Override
    public String evaluate(StudentProfile s) {
        return s.disciplinaryFlag != LegacyFlags.NONE ? "disciplinary flag present" : "";
    }
}
