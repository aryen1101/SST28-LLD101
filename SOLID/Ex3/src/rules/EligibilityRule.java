package rules;

import entities.StudentProfile;

public interface EligibilityRule {
    String evaluate(StudentProfile s);
}
