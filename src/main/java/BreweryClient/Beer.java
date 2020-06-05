package BreweryClient;

import Models.OtherIngredient;
import Models.Yiest;

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
        ArrayList<Yiest> yiests = recipe.getYiests();
        for (int i = 0; i < ingredients.size(); i++){
            counter += ingredients.get(i).getQuantity() * ingredients.get(i).getStockPrice();
        }
        for (int i = 0; i < yiests.size(); i++){
            counter += yiests.get(i).getQuantity() * yiests.get(i).getStockPrice();
        }
        return tempBeerCost.getCost(liter) + counter * ((double)liter / (double)recipe.getLiter()); //+ recipe.getFermentationTimeInDays() * 50 +
//                (recipe.isFiltrarion() ? 50*liter : 0 + (recipe.isPasteurization() ? 200*liter : 0));
    }
}
