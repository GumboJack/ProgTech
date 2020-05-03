package BreweryStockMarket;

import Models.*;

public class IngredientsFactory {
    private static IngredientsFactory instance = null;

    private IngredientsFactory(){}

    public static IngredientsFactory getInstance(){
        if (instance == null){
            instance = new IngredientsFactory();
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
            case 'o':
                return new OtherIngredient();
            default:
                return null;
        }
    }
}
