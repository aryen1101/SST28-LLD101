package checkout;

import dto.OrderLine;
import entities.MenuItem;
import invoice.InvoiceFormatter;
import invoice.InvoiceIDGenerator;
import orders.OrderCalculator;
import orders.OrderSummary;
import rules.discountRules.DiscountRules;
import rules.taxRules.TaxRules;
import store.FileStore;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CafeteriaSystem {

    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceFormatter formatter;
    private final InvoiceIDGenerator idGenerator;
    private final FileStore store;

    public CafeteriaSystem(InvoiceFormatter formatter, InvoiceIDGenerator idGenerator, FileStore store) {
        this.formatter = formatter;
        this.idGenerator = idGenerator;
        this.store = store;
    }

    public void addToMenu(MenuItem item) {
        menu.put(item.id, item);
    }

    public void checkout(List<OrderLine> lines, TaxRules taxRules, DiscountRules discountRules) {
        OrderCalculator calculator = new OrderCalculator(taxRules, discountRules);
        OrderSummary summary = calculator.calculate(lines, menu);
        String invoiceId = idGenerator.next();
        String printable = formatter.format(invoiceId, summary);

        System.out.print(printable);

        store.save(invoiceId, printable);
        System.out.println("Saved invoice: " + invoiceId
                + " (lines=" + store.countLines(invoiceId) + ")");
    }
}

// test