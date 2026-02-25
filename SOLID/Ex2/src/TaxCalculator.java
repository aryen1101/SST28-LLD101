public interface TaxCalculator {
    double getTaxRate();
    double calculateTax(double subtotal);
}
