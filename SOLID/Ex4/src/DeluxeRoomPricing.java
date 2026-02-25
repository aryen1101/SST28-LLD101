
public class DeluxeRoomPricing implements RoomPricing {

    @Override
    public int getRoomType() {

        return LegacyRoomTypes.DELUXE;
    }

    @Override
    public Money getPrice() {
        return new Money(16000.0);
    }

}
