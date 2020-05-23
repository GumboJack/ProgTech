package BreweryClient;

import ModelsTest.Malt;

import java.util.ArrayList;

public class Mash extends BeerDecorator {
    public Mash(BeerCost newBeerCost, Recipe recipe) {
        super(newBeerCost, recipe);
        super.recipe = recipe;
    }

    @Override
    public double getCost(int liter) {
        double counter = 0;
        ArrayList<Malt> malts = recipe.getMalts();
        for(int i = 0; i < malts.size(); i++){
            counter += malts.get(i).getQuantity() * malts.get(i).getStockPrice();
        }
        //counter += recipe.getMashingTimeInMinutes() * 60;
        return tempBeerCost.getCost(liter) + counter * ((double)liter / (double)recipe.getLiter());
    }
}
