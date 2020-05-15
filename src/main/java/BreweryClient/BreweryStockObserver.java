package BreweryClient;

import BreweryStockMarket.BreweryStock;
import ModelsTest.Ingredient;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class BreweryStockObserver implements Observer {
    private ArrayList<Ingredient> observedStock = new ArrayList<Ingredient>();
    private ArrayList<Recipe> craftBeers = new ArrayList<Recipe>();
    private ClientGUI gui;

    public BreweryStockObserver(ClientGUI gui) {
        this.gui = gui;
    }

    @Override
    public void update(Observable o, Object arg) {
        observedStock = ((BreweryStock)o).getStock();
        gui.fillStore(observedStock);
    }

    public ArrayList<Ingredient> getObservedStock() {
        return observedStock;
    }
}
