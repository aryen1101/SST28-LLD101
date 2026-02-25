public class StaffDiscountCalculator implements DiscountCalculator {
    @Override
    public double calculateDiscount(double subtotal, int itemsCount) {
        if (itemsCount >= 3) {
            return 15.0;
        }
        return 5.0;
    }
}