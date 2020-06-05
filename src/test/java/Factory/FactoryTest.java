package Factory;

import BreweryStockMarket.IngredientsFactory;
import Models.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class FactoryTest {
    static final IngredientsFactory factory = IngredientsFactory.getInstance();

    @Test
    void factoryReturnsExpected(){
        try{
            Object object = factory.makeIngredient('o');
            assertNotNull(object);
            assertTrue(object instanceof OtherIngredient);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        try{
            Object object = factory.makeIngredient('h');
            assertNotNull(object);
            assertTrue(object instanceof Hop);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        try{
            Object object = factory.makeIngredient('m');
            assertNotNull(object);
            assertTrue(object instanceof Malt);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        try{
            Object object = factory.makeIngredient('y');
            assertNotNull(object);
            assertTrue(object instanceof Yiest);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    void factoryIsSingleton(){
        IngredientsFactory factory = IngredientsFactory.getInstance();
        IngredientsFactory factory2 = IngredientsFactory.getInstance();
        assertEquals(factory, factory2);
    }
}
