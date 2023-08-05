package desing.patterns.decorator.icecream.impl;

import desing.patterns.decorator.icecream.IceCream;

public class VanillaIceCream implements IceCream {

    @Override
    public String getDescription() {
        return "Vanilla Ice Cream";
    }

    @Override
    public double cost() {
        return 0.9;
    }
}
