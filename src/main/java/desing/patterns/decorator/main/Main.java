package desing.patterns.decorator.main;

import desing.patterns.decorator.condiment.IceCreamCondiment;
import desing.patterns.decorator.condiment.impl.ChoppedNuts;
import desing.patterns.decorator.condiment.impl.MaraschinoCherries;
import desing.patterns.decorator.exceptions.CreationException;
import desing.patterns.decorator.icecream.IceCream;
import desing.patterns.decorator.icecream.impl.VanillaIceCream;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(final String[] args) {
        final IceCream vanillaIceCream = new VanillaIceCream();
        final IceCream choppedNuts = new ChoppedNuts(vanillaIceCream);
        final IceCream maraschinoCherries = new MaraschinoCherries(choppedNuts);

        System.out.println(maraschinoCherries.getDescription());
        System.out.println(maraschinoCherries.cost());
    }


    //Helper method for units test
    @SafeVarargs
    final IceCream wrapIceCream(IceCream iceCream, final Class<? extends IceCreamCondiment>... condimentClasses) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (final Class<? extends IceCreamCondiment> condimentClass : condimentClasses) {
            final Constructor<? extends IceCreamCondiment> constructor = condimentClass.getConstructor(IceCream.class);
            iceCream = constructor.newInstance(iceCream);
        }
        return iceCream;
    }

    //Helper method for units test
    @SafeVarargs
    final double calculateCost(IceCream iceCream, final Class<? extends IceCreamCondiment>... condimentClasses) {
        try {
            iceCream = wrapIceCream(iceCream, condimentClasses);
            return iceCream.cost();
        } catch (final Exception exception) {
            throw new CreationException("Failed to create Ice Cream!", exception);
        }
    }
}