package BreweryClient;

import BreweryStockMarket.BreweryStock;
import Models.Ingredient;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class BreweryStockObserver implements Observer {
    private ArrayList<Ingredient> observedStock = new ArrayList<Ingredient>();
    private ArrayList<Recipe> craftBeers = new ArrayList<Recipe>();

    private ClientGUI frame = new ClientGUI("BreweryClient");

    public void update(Observable o, Object arg) {
        observedStock = ((BreweryStock)o).getStock();
        updatestoreStore(observedStock);
    }

    private void updatestoreStore(ArrayList<Ingredient> stock){
        frame.fillStore(stock);
    }

}
