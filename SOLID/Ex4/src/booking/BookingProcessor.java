package booking;

import dto.BookingRequest;
import entitites.Money;

public interface BookingProcessor {
    void process(BookingRequest req, Money monthly, Money deposit);
}
