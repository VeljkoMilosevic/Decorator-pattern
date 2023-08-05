package desing.patterns.decorator.condiment.impl;

import desing.patterns.decorator.condiment.IceCreamCondiment;
import desing.patterns.decorator.icecream.IceCream;

public class Sprinkles implements IceCreamCondiment {

    final IceCream iceCream;

    public Sprinkles(final IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public String getDescription() {
        return String.format("%s, %s", iceCream.getDescription(), "sprinkles");
    }

    @Override
    public double cost() {
        return iceCream.cost() + 0.6;
    }
}
