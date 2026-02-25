public class InvoiceData {
    public final String id;
    public final double subtotal;
    public final double tax;
    public final double discount;
    public final double total;
    public final double taxPct;

    public InvoiceData(String id, double subtotal, double tax, double taxPct, double discount) {
        this.id = id;
        this.subtotal = subtotal;
        this.tax = tax;
        this.taxPct = taxPct;
        this.discount = discount;
        this.total = subtotal + tax - discount;
    }
}