package rules.taxRules;

public class StaffTaxRules implements TaxRules {
    private static final double STAFF_TAX_RATE = 5.0;

    @Override
    public double taxPercent() {
        return STAFF_TAX_RATE;
    }
}
