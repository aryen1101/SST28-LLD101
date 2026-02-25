import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    
    private final InvoiceStore store;
    private final InvoicePrinter printer;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(InvoiceStore store, InvoicePrinter printer) {
        this.store = store;
        this.printer = printer;
    }

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(TaxCalculator taxCalc, DiscountCalculator discountCalc, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
        }

        double tax = taxCalc.calculateTax(subtotal);
        double taxPct = taxCalc.getTaxRate();
        double discount = discountCalc.calculateDiscount(subtotal, lines.size());

        InvoiceData data = new InvoiceData(invId, subtotal, tax, taxPct, discount);


        String printable = printer.format(data, lines, menu);
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
