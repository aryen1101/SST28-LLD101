
public class TripleRoomPricing implements RoomPricing {

    @Override
    public int getRoomType() {

        return LegacyRoomTypes.TRIPLE;
    }

    @Override
    public Money getPrice() {
        return new Money(12000.0);
    }

}
