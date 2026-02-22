package rules.discountRules;

public class StudentDiscountRules implements DiscountRules {
    private static final double MIN_SUBTOTAL_FOR_DISCOUNT = 100.0;
    private static final double DISCOUNT_RATE = 10.0;

    @Override
    public double discountAmount(double subtotal, int distinctLines) {
        return subtotal >= MIN_SUBTOTAL_FOR_DISCOUNT ? DISCOUNT_RATE : 0.0;
    }
}