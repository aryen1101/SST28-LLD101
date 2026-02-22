package orders;

import dto.LineDetail;
import dto.OrderLine;
import entities.MenuItem;
import rules.discountRules.DiscountRules;
import rules.taxRules.TaxRules;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderCalculator {

    private final TaxRules taxRules;
    private final DiscountRules discountRules;

    public OrderCalculator(TaxRules taxRules, DiscountRules discountRules) {
        this.taxRules = taxRules;
        this.discountRules = discountRules;
    }

    public OrderSummary calculate(List<OrderLine> lines, Map<String, MenuItem> menu) {
        List<LineDetail> details = new ArrayList<>();
        double subtotal = 0.0;

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
            details.add(new LineDetail(item.name, l.qty, lineTotal));
        }

        double taxPct = taxRules.taxPercent();
        double tax = subtotal * (taxPct / 100.0);
        double discount = discountRules.discountAmount(subtotal, lines.size());
        double total = subtotal + tax - discount;

        return new OrderSummary(details, subtotal, taxPct, tax, discount, total);
    }
}