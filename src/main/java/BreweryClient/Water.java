package BreweryClient;

public class Water implements BeerCost {

    public double getCost(int liter) {
        return liter*100;
    }

}
