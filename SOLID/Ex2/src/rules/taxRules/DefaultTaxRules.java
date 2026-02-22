package rules.taxRules;

public class DefaultTaxRules implements TaxRules {
    private static final double BASE_TAX_RATE = 8.0;

    @Override
    public double taxPercent() {
        return BASE_TAX_RATE;
    }
}

