
public class SingleRoomPricing implements RoomPricing {

    @Override
    public int getRoomType() {

        return LegacyRoomTypes.SINGLE;
    }

    @Override
    public Money getPrice() {
        return new Money(14000.0);
    }

}
