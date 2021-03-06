package Decorator;

import BreweryClient.*;
import Models.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class DecoratorTest {
    @Test
    void TestBeerDecorator() throws MissingIngredientsException {
        Recipe recipe = new Recipe(
                "Premium Berry Pils",
                20,
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
        recipe.getMalts().get(0).setQuantity(3);
        BeerCost beer = new Beer(new Wort(new Mash(new Water(), recipe), recipe), recipe);
        double fullprice = recipe.getLiter()*100;

        for (Malt malt:
             recipe.getMalts()) {
            fullprice += malt.getStockPrice() * malt.getQuantity();
        }
        for (Hop hop:
                recipe.getHops()) {
            fullprice += hop.getStockPrice() * hop.getQuantity();
        }
        for (Yiest yiest:
                recipe.getYiests()) {
            fullprice += yiest.getStockPrice() * yiest.getQuantity();
        }
        for (OtherIngredient other:
                recipe.getOtherIngredients()) {
            fullprice += other.getStockPrice() * other.getQuantity();
        }

        assertEquals(fullprice, beer.getCost(recipe.getLiter()), 2);
        System.out.println(recipe.getBeerName());
        System.out.println("Expected: " + fullprice);
        System.out.println("Actual: " + beer.getCost(recipe.getLiter()));
    }
}
