package BreweryClient;

import Models.Hop;

import java.util.ArrayList;

public class Wort extends BeerDecorator {

    public Wort(BeerCost newBeerCost, Recipe recipe) {
        super(newBeerCost, recipe);
        super.recipe = recipe;
    }

    @Override
    public double getCost(int liter) {
        double counter = 0;
        ArrayList<Hop> hops = recipe.getHops();
        for(int i = 0; i < hops.size(); i++){
            counter += hops.get(i).getQuantity() * hops.get(i).getStockPrice();
        }
        //counter += recipe.getHopBoilingTimeInMinutes() * 80;
        return tempBeerCost.getCost(liter) + counter * ((double)liter / (double)recipe.getLiter());
    }
}
