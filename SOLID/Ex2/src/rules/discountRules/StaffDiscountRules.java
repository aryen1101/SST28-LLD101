package rules.discountRules;

public class StaffDiscountRules implements DiscountRules {
    private static final int MIN_DISTINCT_LINES_FOR_MAX_DISCOUNT = 3;
    private static final double MAX_DISCOUNT_RATE = 15.0;
    private static final double MIN_DISCOUNT_RATE = 5.0;

    @Override
    public double discountAmount(double subtotal, int distinctLines) {
        return distinctLines >= MIN_DISTINCT_LINES_FOR_MAX_DISCOUNT ? MAX_DISCOUNT_RATE : MIN_DISCOUNT_RATE;
    }
}