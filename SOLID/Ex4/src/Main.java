import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        List<RoomPricing> rooms = Arrays.asList(
            new SingleRoomPricing(), 
            new DoubleRoomPricing(),
            new TripleRoomPricing(), 
            new DeluxeRoomPricing()
        );

        List<AddOnPricing> addOns = Arrays.asList(
            new MessPricing(), 
            new LaundryPricing(), 
            new GymPricing()
        );

        HostelFeeCalculator calc = new HostelFeeCalculator(
            new FakeBookingRepo(), 
            rooms, 
            addOns
        );

        BookingRequest req = new BookingRequest(
            LegacyRoomTypes.DOUBLE, 
            List.of(AddOn.LAUNDRY, AddOn.MESS)
        );
        
        calc.process(req);
    }
}