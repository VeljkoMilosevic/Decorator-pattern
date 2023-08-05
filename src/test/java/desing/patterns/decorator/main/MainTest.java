package desing.patterns.decorator.main;

import desing.patterns.decorator.condiment.IceCreamCondiment;
import desing.patterns.decorator.condiment.impl.ChoppedNuts;
import desing.patterns.decorator.condiment.impl.MaraschinoCherries;
import desing.patterns.decorator.condiment.impl.Sprinkles;
import desing.patterns.decorator.icecream.IceCream;
import desing.patterns.decorator.icecream.impl.CaramelIceCream;
import desing.patterns.decorator.icecream.impl.ChocolateIceCream;
import desing.patterns.decorator.icecream.impl.VanillaIceCream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {


    private static final Double VANILLA_ICE_CREAM_PRICE = 0.9;
    private static final Double CHOCOLATE_ICE_CREAM_PRICE = 1.05;
    private static final Double CARAMEL_ICE_CREAM_PRICE = 1.2;
    private static final Double MARASCHINO_CHERRIES_PRICE = 0.7;
    private static final Double CHOPPED_NUTS_PRICE = 0.9;
    private static final Double SPRINKLES_PRICE = 0.6;

    Main main;

    @BeforeEach
    void initMainClass() {
        main = new Main();
    }

    @ParameterizedTest
    @MethodSource("providerOneCondiment")
    void calculateCost_ProvidedOneCondiments_CalculatedCosts(final IceCream iceCream, final Class<? extends IceCreamCondiment> iceCreamCondiment, final double expected) {
        assertEquals(expected, main.calculateCost(iceCream, iceCreamCondiment));
    }

    @ParameterizedTest
    @MethodSource("providerTwoCondiments")
    void calculateCost_ProvidedTwoCondiments_CalculatedCosts(final IceCream iceCream, final Class<? extends IceCreamCondiment> iceCreamCondiment1, final Class<? extends IceCreamCondiment> iceCreamCondiment2, final double expected) {
        assertEquals(expected, main.calculateCost(iceCream, iceCreamCondiment1, iceCreamCondiment2));
    }

    @ParameterizedTest
    @MethodSource("providerThreeCondiment")
    void calculateCost_ProvidedThreeCondiments_CalculatedCosts(final IceCream iceCream, final Class<? extends IceCreamCondiment> iceCreamCondiment1, final Class<? extends IceCreamCondiment> iceCreamCondiment2, final Class<? extends IceCreamCondiment> iceCreamCondiment3, final double expected) {
        assertEquals(expected, main.calculateCost(iceCream, iceCreamCondiment1, iceCreamCondiment2, iceCreamCondiment3));
    }

    private static Stream<Arguments> providerOneCondiment() {
        final IceCream vanillaIceCream = new VanillaIceCream();
        final IceCream chocolateIceCream = new ChocolateIceCream();
        final IceCream caramelIceCream = new CaramelIceCream();

        return Stream.of(
                Arguments.of(chocolateIceCream, ChoppedNuts.class, CHOCOLATE_ICE_CREAM_PRICE + CHOPPED_NUTS_PRICE),
                Arguments.of(vanillaIceCream, Sprinkles.class, VANILLA_ICE_CREAM_PRICE + SPRINKLES_PRICE),
                Arguments.of(caramelIceCream, MaraschinoCherries.class, CARAMEL_ICE_CREAM_PRICE + MARASCHINO_CHERRIES_PRICE)
        );
    }

    private static Stream<Arguments> providerTwoCondiments() {
        final IceCream vanillaIceCream = new VanillaIceCream();
        final IceCream chocolateIceCream = new ChocolateIceCream();
        final IceCream caramelIceCream = new CaramelIceCream();

        return Stream.of(
                Arguments.of(vanillaIceCream, ChoppedNuts.class, MaraschinoCherries.class, VANILLA_ICE_CREAM_PRICE + CHOPPED_NUTS_PRICE + MARASCHINO_CHERRIES_PRICE),
                Arguments.of(chocolateIceCream, MaraschinoCherries.class, Sprinkles.class, CHOCOLATE_ICE_CREAM_PRICE + MARASCHINO_CHERRIES_PRICE + SPRINKLES_PRICE),
                Arguments.of(caramelIceCream, ChoppedNuts.class, Sprinkles.class, CARAMEL_ICE_CREAM_PRICE + CHOPPED_NUTS_PRICE + SPRINKLES_PRICE)
        );
    }

    private static Stream<Arguments> providerThreeCondiment() {
        final IceCream vanillaIceCream = new VanillaIceCream();
        final IceCream chocolateIceCream = new ChocolateIceCream();
        final IceCream caramelIceCream = new CaramelIceCream();

        return Stream.of(
                Arguments.of(chocolateIceCream, MaraschinoCherries.class, MaraschinoCherries.class, MaraschinoCherries.class, CHOCOLATE_ICE_CREAM_PRICE + MARASCHINO_CHERRIES_PRICE + MARASCHINO_CHERRIES_PRICE + MARASCHINO_CHERRIES_PRICE),
                Arguments.of(vanillaIceCream, Sprinkles.class, MaraschinoCherries.class, MaraschinoCherries.class, VANILLA_ICE_CREAM_PRICE + SPRINKLES_PRICE + MARASCHINO_CHERRIES_PRICE + MARASCHINO_CHERRIES_PRICE),
                Arguments.of(caramelIceCream, Sprinkles.class, ChoppedNuts.class, MaraschinoCherries.class, CARAMEL_ICE_CREAM_PRICE + SPRINKLES_PRICE + CHOPPED_NUTS_PRICE + MARASCHINO_CHERRIES_PRICE)
        );
    }
}
