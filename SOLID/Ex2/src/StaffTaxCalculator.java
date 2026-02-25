public class StaffTaxCalculator implements TaxCalculator {
    @Override
    public double getTaxRate() {
        return 2.0;
    }

    @Override
    public double calculateTax(double subtotal) {
        return subtotal * (getTaxRate() / 100.0);
    }
}