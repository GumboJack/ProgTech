package BreweryStockMarket;

import Models.*;

import java.util.ArrayList;
import java.util.Observable;

public class BreweryStock extends Observable {
    private IngredientsFactory factory = IngredientsFactory.getInstance();
    private ArrayList<Ingredient> stock = new ArrayList<Ingredient>();
    private static BreweryStock instance = null;

    private BreweryStock(){}

    public static BreweryStock getInstance(){
        if(instance == null){
            instance = new BreweryStock();
        }
        return instance;
    }

    public ArrayList<Ingredient> getStock(){
        return (ArrayList<Ingredient>) stock;
    }

    public void updatePrices(){
        for (Ingredient item:
             stock) {
            item.randomizePrice();
        }
        setChanged();
        notifyObservers();
    }

    public void addIngredient(char itemType, double alphaAcid, String itemName, double stockPrice,
                         int quantity, double minIncrease, double maxIncrease, double mindDecrease, double maxDecrease, UnitType unit){
        Ingredient ingredient = factory.makeIngredient(itemType);
        if(ingredient instanceof Hop){
            ((Hop) ingredient).setAlphaAcid(alphaAcid);
            ingredient.setItemName(itemName);
            ingredient.setStockPrice(stockPrice);
            ingredient.setQunantity(quantity);
            ingredient.setMinIncrease(minIncrease);
            ingredient.setMaxIncrease(maxIncrease);
            ingredient.setMinDecrease(mindDecrease);
            ingredient.setMaxDecrease(maxDecrease);
        } else if(ingredient instanceof Malt || ingredient instanceof Yiest){
            ingredient.setItemName(itemName);
            ingredient.setStockPrice(stockPrice);
            ingredient.setQunantity(quantity);
            ingredient.setMinIncrease(minIncrease);
            ingredient.setMaxIncrease(maxIncrease);
            ingredient.setMinDecrease(mindDecrease);
            ingredient.setMaxDecrease(maxDecrease);
        } else if(ingredient instanceof OtherIngredient){
            ingredient.setItemName(itemName);
            ingredient.setStockPrice(stockPrice);
            ingredient.setQunantity(quantity);
            ingredient.setUnit(unit);
        }
        stock.add(ingredient);
        super.setChanged();
        notifyObservers();
    }

    public void addIngredient(Ingredient ingredient){
        stock.add(ingredient);
        setChanged();
        notifyObservers();
    }
}
