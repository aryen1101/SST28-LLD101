package pricing.roompricing.impl;

import entitites.Money;
import enums.LegacyRoomTypes;
import pricing.roompricing.RoomPricing;

public class DoubleRoomPricing implements RoomPricing {
    private static final double DOUBLE_ROOM_PRICE = 15000.0;

    @Override
    public boolean supports(int roomType) {
        return LegacyRoomTypes.nameOf(roomType).equals(LegacyRoomTypes.nameOf(LegacyRoomTypes.DOUBLE));
    }

    @Override
    public Money getBasePrice() {
        return new Money(DOUBLE_ROOM_PRICE);
    }
}
