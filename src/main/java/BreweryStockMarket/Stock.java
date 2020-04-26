package BreweryStockMarket;

import Models.Ingredient;

import java.util.ArrayList;
import java.util.Observable;

public class Stock extends Observable {
    BreweryIngredientsFactory factory = BreweryIngredientsFactory.getInstance();
    ArrayList<Ingredient> stock = new ArrayList<Ingredient>();

    public void addItem(char itemType){
        stock.add(factory.makeIngredient(itemType));
    }

    public ArrayList<Ingredient> getStock(){
        return (ArrayList<Ingredient>) stock.clone();
    }

    public void updatePrices(){
        for (Ingredient item:
             stock) {
            item.randomizePrice();
        }
        setChanged();
        notifyObservers();
    }
}
