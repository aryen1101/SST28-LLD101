package orders;

import dto.LineDetail;

import java.util.Collections;
import java.util.List;

public class OrderSummary {
    public final List<LineDetail> lines;
    public final double subtotal;
    public final double taxPct;
    public final double tax;
    public final double discount;
    public final double total;

    public OrderSummary(List<LineDetail> lines, double subtotal, double taxPct, double tax, double discount, double total) {
        this.lines = Collections.unmodifiableList(lines);
        this.subtotal = subtotal;
        this.taxPct = taxPct;
        this.tax = tax;
        this.discount = discount;
        this.total = total;
    }
}
