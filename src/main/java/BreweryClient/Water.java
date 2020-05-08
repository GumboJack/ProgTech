package BreweryClient;

public class Water implements Beer {

    public String getDescription() {
        return "Water";
    }

    public double getCost(int liter) {
        return liter*100;
    }

}
