package Decorator;

import BreweryClient.*;
import ModelsTest.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class DecoratorTest {
    @Test
    void TestBeerDecorator(){
        Recipe recipe = new Recipe(
                "Premium Berry Pils",
                23,
                70,
                40,
                45,
                true,
                true,
                new ArrayList<Hop>(Arrays.asList(
                        new Hop(0.12, "Citra Hop", 1200, 100, 10,10,10,10),
                        new Hop(0.1, "Amarillo Hop", 2000, 100, 10,10,10,10)
                )),
                new ArrayList<Malt>(Arrays.asList(
                        new Malt("Caramel Malt", 2400, 1, 10,10,10,10)
                )),
                new ArrayList<Yiest>(Arrays.asList(
                        new Yiest("WLP800 Pilsner", 800, 100, 10, 10, 10, 10)
                )),
                new ArrayList<OtherIngredient>(Arrays.asList(
                    new OtherIngredient("Berries", 500, 2, UnitType.KILOGRAM)
                ))        );
        recipe.getHops().get(1).setQuantity(2);
        BeerCost beer = new Beer(new Wort(new Mash(new Water(), recipe), recipe), recipe);
        System.out.println(recipe.getBeerName());
        int liter = 500;
        System.out.println(Ingredient.round(beer.getCost(liter), 2) + "Ft / " + liter + "L");
    }
}
