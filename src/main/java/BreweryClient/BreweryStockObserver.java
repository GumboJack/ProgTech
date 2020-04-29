package BreweryClient;

import BreweryStockMarket.Stock;
import Models.Ingredient;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class BreweryStockObserver implements Observer {
    private ArrayList<Ingredient> observedStock = new ArrayList<Ingredient>();
    private ArrayList<Beer> craftBeers = new ArrayList<Beer>();

    public void update(Observable o, Object arg) {
        observedStock = ((Stock)o).getStock();
        displayAllPrices();
    }

    public void displayAllPrices(){
        StringBuilder sb = new StringBuilder();
        sb.append("STOCK: \n");
        for (Ingredient ingredient:
             observedStock) {
            sb.append(ingredient.getItemName());
            sb.append(": ");
            sb.append(ingredient.getStockPrice());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public void displayBrewingPrices(double quantity){
        StringBuilder sb = new StringBuilder();
        sb.append("BEER PRICES: \n");
        for (Beer beer:
             craftBeers) {

        }
    }
}
