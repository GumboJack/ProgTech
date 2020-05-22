package BreweryClient;

import ModelsTest.OtherIngredient;

import java.util.ArrayList;

public class Beer extends BeerDecorator {

    public Beer(BeerCost newBeerCost, Recipe recipe) {
        super(newBeerCost, recipe);
        super.recipe = recipe;
    }

    @Override
    public double getCost(int liter) {
        double counter = 0;
        ArrayList<OtherIngredient> ingredients = recipe.getOtherIngredients();
        for (int i = 0; i < ingredients.size(); i++){
            counter += ingredients.get(i).getQuantity() * ingredients.get(i).getPackVolume() * ingredients.get(i).getStockPrice();
        }
        return tempBeerCost.getCost(liter) + counter * (recipe.getLiter() / liter); //+ recipe.getFermentationTimeInDays() * 50 +
//                (recipe.isFiltrarion() ? 50*liter : 0 + (recipe.isPasteurization() ? 200*liter : 0));
    }
}
