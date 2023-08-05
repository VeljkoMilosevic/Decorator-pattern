package desing.patterns.decorator.icecream.impl;

import desing.patterns.decorator.icecream.IceCream;

public class ChocolateIceCream implements IceCream {

    @Override
    public String getDescription() {
        return "Chocolate ice Cream";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
