package ObserverTest;

import BreweryClient.BreweryStockObserver;
import BreweryClient.ClientGUI;
import BreweryStockMarket.BreweryStock;
import org.junit.jupiter.api.Test;

import java.util.Observable;
import java.util.Observer;

import static org.junit.Assert.*;

public class ObserverTester {

    @Test
    void testIfObserversSigned(){
        BreweryStockObserver obs1 = new BreweryStockObserver(new ClientGUI());
        BreweryStockObserver obs2 = new BreweryStockObserver(new ClientGUI());
        BreweryStockObserver obs3 = new BreweryStockObserver(new ClientGUI());
        BreweryStock stock = BreweryStock.getInstance();
        stock.addObserver(obs1);
        stock.addObserver(obs2);
        stock.addObserver(obs3);
        assertEquals(3, stock.countObservers());
    }

    @Test
    void testIfObserversupdated(){
        MockObserver observer = new MockObserver();
        BreweryStock stock = BreweryStock.getInstance();
        stock.addObserver(observer);
        stock.updatePrices();

        assertTrue(observer.updated);
    }

    @Test
    void observableIsSingleton(){
        BreweryStock stock = BreweryStock.getInstance();
        BreweryStock stock2 = BreweryStock.getInstance();
        assertEquals(stock, stock2);
    }
}

class MockObserver implements Observer{
    boolean updated = false;

    @Override
    public void update(Observable o, Object arg) {
        updated = true;
    }
}
