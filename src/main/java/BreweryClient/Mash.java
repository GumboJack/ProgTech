package BreweryClient;

import Models.Malt;

import java.util.ArrayList;

public class Mash extends Vessel {
    protected ArrayList<Malt> malts;

    public Mash(Beer newBeer, Recipe recipe, ArrayList<Malt> malts) {
        super(newBeer, recipe);
        if(recipe.getMaltQuantities().length == malts.size()){
            this.malts = malts;
        }
    }

    @Override
    public double getCost(int liter) {
        double counter = 0;
        for(int i = 0; i < malts.size(); i++){
            counter += recipe.getMaltQuantities()[i] / malts.get(i).getQunantity() * malts.get(i).getStockPrice();
        }
        counter += recipe.getMashingTimeInMinutes() * 60;
        return super.getCost(liter) + counter * (recipe.getLiter() / liter);
    }
}
