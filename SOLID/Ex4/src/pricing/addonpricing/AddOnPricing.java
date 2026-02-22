package pricing.addonpricing;

import entitites.Money;
import enums.AddOn;

public interface AddOnPricing {
    boolean supports(AddOn addOn);

    Money getPrice();
}
