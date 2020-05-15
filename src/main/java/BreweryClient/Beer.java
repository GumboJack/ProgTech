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
        int[] quantities = recipe.getMaltQuantities();
        ArrayList<OtherIngredient> ingredients = recipe.getOtherIngredients();
        for (int i = 0; i < ingredients.size(); i++){
            counter += quantities[i] / ingredients.get(i).getQunantity() * ingredients.get(i).getStockPrice();
        }
        return tempBeerCost.getCost(liter) + recipe.getFermentationTimeInDays() * 50 +
                (recipe.isFiltrarion() ? 50*liter : 0 + (recipe.isPasteurization() ? 200*liter : 0));
    }
}
