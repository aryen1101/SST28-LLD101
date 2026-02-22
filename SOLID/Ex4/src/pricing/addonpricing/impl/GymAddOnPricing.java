package pricing.addonpricing.impl;

import entitites.Money;
import enums.AddOn;
import pricing.addonpricing.AddOnPricing;

public class GymAddOnPricing implements AddOnPricing {

    private static final double GYM_ADD_ON_PRICE = 300.0;

    @Override
    public boolean supports(AddOn addOn) {
        return addOn.equals(AddOn.GYM);
    }

    @Override
    public Money getPrice() {
        return new Money(GYM_ADD_ON_PRICE);
    }
}