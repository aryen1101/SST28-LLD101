public class GymPricing implements AddOnPricing {
    
    @Override
    public AddOn getAddOn() {
        return AddOn.GYM;
    }

    @Override
    public Money getPrice() {
        return new Money(300.0);
    }
    
}