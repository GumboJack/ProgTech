package Models;

import java.util.Random;

public class Yiest extends Ingredient {

    public void randomizePrice() {
        Random randomGenerator = new Random();
        if (randomGenerator.nextBoolean()){
            double increase;
            increase = getMinIncrease() + (getMaxIncrease() - getMinIncrease()) * randomGenerator.nextDouble();
            this.setStockPrice(Ingredient.round(this.getStockPrice()+increase, 2));
        } else {
            double decrease;
            decrease = getMinDecrease() + (getMaxDecrease() - getMinDecrease()) * randomGenerator.nextDouble();
            this.setStockPrice(Ingredient.round(this.getStockPrice()-decrease, 2));
        }
    }

    public Yiest(Yiest yiest){
        this.setItemName(yiest.getItemName());
        this.setStockPrice(yiest.getStockPrice());
        this.setPackVolume(yiest.getPackVolume());
        this.setUnit(yiest.getUnit());
    }

    public Yiest(){
        this.setUnit(UnitType.GRAM);
    }

    public Yiest(String itemName, double stockPrice, int packVolume, double minIncrease, double maxIncrease, double mindDecrease, double maxDecrease){
        this.setItemName(itemName);
        this.setStockPrice(stockPrice);
        this.setPackVolume(packVolume);
        this.setMinIncrease(minIncrease);
        this.setMaxIncrease(maxIncrease);
        this.setMinDecrease(mindDecrease);
        this.setMaxDecrease(maxDecrease);
        this.setUnit(UnitType.GRAM);
        this.setQuantity(1);
    }

}
