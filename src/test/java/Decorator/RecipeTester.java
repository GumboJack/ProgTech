package Decorator;

import BreweryClient.MissingIngredientsException;
import BreweryClient.Recipe;
import Models.*;
import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipeTester {
    @Test
    void missingIngredients() throws MissingIngredientsException {
        assertThrows(MissingIngredientsException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                Recipe recipe = new Recipe(
                        "Premium Berry Pils",
                        20,
                        70,
                        40,
                        45,
                        true,
                        true,
                        new ArrayList<Hop>(Arrays.asList(
                                new Hop(0.12, "Citra Hop", 1200, 100, 10, 10, 10, 10),
                                new Hop(0.1, "Amarillo Hop", 2000, 100, 10, 10, 10, 10)
                        )),
                        new ArrayList<Malt>(Arrays.asList(
                                new Malt("Caramel Malt", 2400, 1, 10, 10, 10, 10)
                        )),
                        new ArrayList<Yiest>(),
                        new ArrayList<OtherIngredient>(Arrays.asList(
                                new OtherIngredient("Berries", 500, 2, UnitType.KILOGRAM)
                        )));
            }
        });
    }
}
