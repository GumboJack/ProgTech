package BreweryStockMarket;

import Models.Hop;
import Models.Ingredient;

import java.util.ArrayList;
import java.util.Observable;

public class Stock extends Observable {
    private BreweryIngredientsFactory factory = BreweryIngredientsFactory.getInstance();
    private ArrayList<Ingredient> stock = new ArrayList<Ingredient>();
    private static Stock instance = null;

    private Stock(){}

    public static Stock getInstance(){
        if(instance == null){
            instance = new Stock();
        }
        return instance;
    }

    public void addItem(char itemType){
        Ingredient ingredient = factory.makeIngredient(itemType);
        switch (ingredient.getClass().toString()){
            case "Hop":
                break;
        }
        stock.add();
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
