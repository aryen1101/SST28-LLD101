package invoice;

import dto.LineDetail;
import orders.OrderSummary;

public class InvoiceFormatter {
    public String format(String invoiceId, OrderSummary summary) {
        StringBuilder sb = new StringBuilder();

        sb.append("Invoice# ").append(invoiceId).append("\n");

        for (LineDetail line : summary.lines) {
            sb.append(String.format("- %s x%d = %.2f%n", line.itemName(), line.qty(), line.lineTotal()));
        }

        sb.append(String.format("Subtotal: %.2f%n", summary.subtotal));
        sb.append(String.format("Tax(%.0f%%): %.2f%n", summary.taxPct, summary.tax));
        sb.append(String.format("Discount: -%.2f%n", summary.discount));
        sb.append(String.format("TOTAL: %.2f%n", summary.total));

        return sb.toString();
    }
}