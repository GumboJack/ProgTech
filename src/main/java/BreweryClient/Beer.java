package BreweryClient;

import Models.Ingredient;
import java.util.ArrayList;

public class Beer {
    private String name;
    private ArrayList<Ingredient> ingredients;
    private DrinkType type;

    public Beer(ArrayList<Ingredient> ingredient, DrinkType type){
        this.ingredients = ingredient;
        this.type = type;
    }

    public double calculateBrewingPrice(double brewQuantity){
        double fullPrice = 0;
        for (Ingredient i:
             ingredients) {
            fullPrice += i.getStockPrice() * i.getQunantity();
        }
        return fullPrice * brewQuantity;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public DrinkType getType() {
        return type;
    }

    public void setType(DrinkType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
