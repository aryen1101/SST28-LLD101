package rules.impl;

import entities.StudentProfile;
import rules.EligibilityRule;

public class CgrRule implements EligibilityRule {
    private final double minCgr;

    public CgrRule(double minCgr) {
        this.minCgr = minCgr;
    }

    @Override
    public String evaluate(StudentProfile s) {
        return s.cgr < minCgr ? "CGR below " + minCgr : "";
    }
}