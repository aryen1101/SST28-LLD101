public class StudentTaxCalculator implements TaxCalculator {
    @Override
    public double getTaxRate() {
        return 5.0;
    }

    @Override
    public double calculateTax(double subtotal) {
        return subtotal * (getTaxRate() / 100.0);
    }
}