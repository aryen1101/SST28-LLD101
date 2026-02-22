package pricing.roompricing;

import entitites.Money;

public interface RoomPricing {
    boolean supports(int roomType);

    Money getBasePrice();
}
