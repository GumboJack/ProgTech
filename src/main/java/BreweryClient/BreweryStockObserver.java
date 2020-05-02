package BreweryClient;

import BreweryStockMarket.Stock;
import Models.Ingredient;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class BreweryStockObserver implements Observer {
    private ArrayList<Ingredient> observedStock = new ArrayList<Ingredient>();
    private ArrayList<Beer> craftBeers = new ArrayList<Beer>();

    private ClientGUI frame = new ClientGUI("BreweryClient");

    public void update(Observable o, Object arg) {
        observedStock = ((Stock)o).getStock();
        updatestoreStore(observedStock);
    }

    private void updatestoreStore(ArrayList<Ingredient> stock){
        frame.fillStore(stock);
    }


}
