package rules.impl;

import entities.StudentProfile;
import rules.EligibilityRule;

public class CreditsRule implements EligibilityRule {
    private final int minCredits;

    public CreditsRule(int minCredits) {
        this.minCredits = minCredits;
    }

    @Override
    public String evaluate(StudentProfile s) {
        return s.earnedCredits < minCredits ? "credits below " + minCredits : "";
    }
}