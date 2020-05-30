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
        BreweryStock observable = BreweryStock.getInstance();
        observable.addObserver(obs1);
        observable.addObserver(obs2);
        observable.addObserver(obs3);
        assertEquals(3, observable.countObservers());
    }

    @Test
    void testIfObserversupdated(){
        MockObserver observer = new MockObserver();
        BreweryStock observable = BreweryStock.getInstance();
        observable.addObserver(observer);
        observable.updatePrices();

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
