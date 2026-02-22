package rules.taxRules;

public class StudentTaxRules implements TaxRules {
    private static final double STUDENT_TAX_RATE = 5.0;

    @Override
    public double taxPercent() {
        return STUDENT_TAX_RATE;
    }
}