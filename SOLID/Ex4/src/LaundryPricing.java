public class LaundryPricing implements AddOnPricing {

    @Override
    public AddOn getAddOn() {
        return AddOn.LAUNDRY;
    }

    @Override
    public Money getPrice() {
        return new Money(500.0);
    }
    
}
