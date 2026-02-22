package pricing.roompricing.impl;

import entitites.Money;
import enums.LegacyRoomTypes;
import pricing.roompricing.RoomPricing;

public class SingleRoomPricing implements RoomPricing {

    private static final double SINGLE_ROOM_PRICE = 14000.0;

    @Override
    public boolean supports(int roomType) {
        return LegacyRoomTypes.nameOf(roomType).equals(LegacyRoomTypes.nameOf(LegacyRoomTypes.SINGLE));
    }

    @Override
    public Money getBasePrice() {
        return new Money(SINGLE_ROOM_PRICE);
    }
}
