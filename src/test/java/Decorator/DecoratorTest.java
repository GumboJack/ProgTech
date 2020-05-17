package Decorator;

import BreweryClient.*;
import ModelsTest.Hop;
import ModelsTest.Malt;
import ModelsTest.OtherIngredient;
import ModelsTest.Yiest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class DecoratorTest {
    @Test
    void TestBeerDecorator(){
        Recipe recipe = new Recipe(
                "Premium Pils",
                500,
                70,
                40,
                45,
                true,
                true,
                new ArrayList<Hop>(Arrays.asList(
                       new Hop(0.12, "Citra Hop", 1200, 100, 10,10,10,10),
                       new Hop(0.1, "Citra2 Hop", 1200, 100, 10,10,10,10)
                )),
                new ArrayList<Malt>(Arrays.asList(
                        new Malt("Caramel Malt", 2000, 1, 10,10,10,10)
                )),
                new ArrayList<Yiest>(Arrays.asList(
                        new Yiest("WLP800 Pilsner", 800, 100, )
                )),
                new ArrayList<OtherIngredient>(Arrays.asList(

                ))
        );
        BeerCost beer = new Beer(new Wort(new Mash(new Water(), recipe), recipe), recipe);
    }
}
