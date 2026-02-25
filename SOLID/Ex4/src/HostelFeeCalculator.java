import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final Map<Integer, RoomPricing> roomPrices = new HashMap<>();
    private final Map<AddOn, AddOnPricing> addOnPrices = new HashMap<>();

    public HostelFeeCalculator(FakeBookingRepo repo, List<RoomPricing> rp, List<AddOnPricing> ap) {
        this.repo = repo;
        for (RoomPricing r : rp) roomPrices.put(r.getRoomType(), r);
        for (AddOnPricing a : ap) addOnPrices.put(a.getAddOn(), a);
    }
    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        Money total = roomPrices.get(req.roomType).getPrice();
        for (AddOn a : req.addOns) {
            total = total.plus(addOnPrices.get(a).getPrice());
        }
        return total;

    }
}
