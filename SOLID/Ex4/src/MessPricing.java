public class MessPricing implements AddOnPricing {

    @Override
    public AddOn getAddOn() {
        return AddOn.MESS;
    }

    @Override
    public Money getPrice() {
        return new Money(1000.0);
    }

}
