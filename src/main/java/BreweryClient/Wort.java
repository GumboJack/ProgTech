package BreweryClient;

import ModelsTest.Hop;

import java.util.ArrayList;

public class Wort extends BeerDecorator {

    public Wort(BeerCost newBeerCost, Recipe recipe) {
        super(newBeerCost, recipe);
        super.recipe = recipe;
    }

    @Override
    public double getCost(int liter) {
        double counter = 0;
        int[] quantities = recipe.getHopQuantities();
        ArrayList<Hop> hops = recipe.getHops();
        for(int i = 0; i < hops.size(); i++){
            counter += quantities[i] / hops.get(i).getQunantity() * hops.get(i).getStockPrice();
        }
        counter += recipe.getHopBoilingTimeInMinutes() * 80;
        return tempBeerCost.getCost(liter) + counter * (recipe.getLiter() / liter);
    }
}
