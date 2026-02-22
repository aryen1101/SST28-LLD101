package pricing.addonpricing.impl;

import entitites.Money;
import enums.AddOn;
import pricing.addonpricing.AddOnPricing;

public class LaundryAddOnPricing implements AddOnPricing {

    private static final double LAUNDRY_ADD_ON_PRICE = 500.0;

    @Override
    public boolean supports(AddOn addOn) {
        return addOn.equals(AddOn.LAUNDRY);
    }

    @Override
    public Money getPrice() {
        return new Money(LAUNDRY_ADD_ON_PRICE);
    }
}
