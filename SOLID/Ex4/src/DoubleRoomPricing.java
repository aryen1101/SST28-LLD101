
public class DoubleRoomPricing implements RoomPricing {

    @Override
    public int getRoomType() {

        return LegacyRoomTypes.DOUBLE;
    }

    @Override
    public Money getPrice() {
        return new Money(15000.0);
    }
}
