package desing.patterns.decorator.condiment.impl;

import desing.patterns.decorator.condiment.IceCreamCondiment;
import desing.patterns.decorator.icecream.IceCream;

public class ChoppedNuts implements IceCreamCondiment {

    final IceCream iceCream;

    public ChoppedNuts(final IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public String getDescription() {
        return String.format("%s, %s", iceCream.getDescription(), "Chopped nuts");
    }

    @Override
    public double cost() {
        return iceCream.cost() + 0.9;
    }
}
