package desing.patterns.decorator.icecream.impl;

import desing.patterns.decorator.icecream.IceCream;

public class CaramelIceCream implements IceCream {

    @Override
    public String getDescription() {
        return "Caramel Ice Cream";
    }

    @Override
    public double cost() {
        return 1.2;
    }
}
