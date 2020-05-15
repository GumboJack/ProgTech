import BreweryClient.ClientGUI;
import BreweryStockMarket.StockServiceGUI;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {

        final JFrame service = new StockServiceGUI();
        service.setVisible(true);

        JFrame client = new ClientGUI();
        client.setVisible(true);

        ((StockServiceGUI)service).addObserver(((ClientGUI)client).getObserver());
    }
}
