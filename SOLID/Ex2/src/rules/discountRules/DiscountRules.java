package rules.discountRules;

public interface DiscountRules {
    default double discountAmount(double subtotal, int distinctLines) {
        return 0.0;
    }
}
