package invoice;

public class InvoiceIDGenerator {
    private static int sequence = 1000;

    public String next() {
        return "INV-" + (sequence++);
    }
}