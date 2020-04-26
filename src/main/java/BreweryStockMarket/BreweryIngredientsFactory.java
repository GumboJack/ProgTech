package BreweryStockMarket;

import Models.Hop;
import Models.Ingredient;
import Models.Malt;
import Models.Yiest;

//Lazy Singleton Factory
public class BreweryIngredientsFactory {
    private static BreweryIngredientsFactory instance = null;

    private BreweryIngredientsFactory(){}

    public static BreweryIngredientsFactory getInstance(){
        if (instance == null){
            instance = new BreweryIngredientsFactory();
        }
        return instance;
    }

    public Ingredient makeIngredient(char ingredientType) {
        switch (ingredientType){
            case 'h':
                return new Hop();
            case 'm':
                return new Malt();
            case 'y':
                return new Yiest();
            default:
                return null;
        }
    }
}
