package BreweryClient;

public abstract class BeerDecorator implements BeerCost {
    protected BeerCost tempBeerCost;
    protected Recipe recipe;

    public BeerDecorator(BeerCost newBeerCost, Recipe recipe){
        tempBeerCost = newBeerCost;
        this.recipe = recipe;
    }

    public double getCost(int liter) {
        return tempBeerCost.getCost(liter);
    }
}
