package BreweryClient;

//beer decorator
public abstract class Vessel implements Beer {
    protected Beer tempBeer;
    protected Recipe recipe;

    public Vessel(Beer newBeer, Recipe recipe){
        tempBeer = newBeer;
        this.recipe = recipe;
    }

    public double getCost(int liter) {
        return tempBeer.getCost(liter);
    }
}
