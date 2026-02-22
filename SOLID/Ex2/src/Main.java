import checkout.CafeteriaSystem;
import dto.OrderLine;
import entities.MenuItem;
import invoice.InvoiceFormatter;
import invoice.InvoiceIDGenerator;
import rules.discountRules.StudentDiscountRules;
import rules.taxRules.StudentTaxRules;
import store.FileStore;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Cafeteria Billing ===");
        CafeteriaSystem system = new CafeteriaSystem(
                new InvoiceFormatter(),
                new InvoiceIDGenerator(),
                new FileStore()
        );

        system.addToMenu(new MenuItem("M1", "Veg Thali", 80.00));
        system.addToMenu(new MenuItem("C1", "Coffee", 30.00));
        system.addToMenu(new MenuItem("S1", "Sandwich", 60.00));

        system.checkout(List.of(
                new OrderLine("M1", 2),
                new OrderLine("C1", 1)
        ), new StudentTaxRules(), new StudentDiscountRules());
    }
}