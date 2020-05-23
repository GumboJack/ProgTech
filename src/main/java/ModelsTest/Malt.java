package ModelsTest;

import java.util.Random;

public class Malt extends Ingredient {

    @Override
    public void randomizePrice() {
        Random randomGenerator = new Random();
        if (randomGenerator.nextBoolean()){
            double increase;
            increase = getMinIncrease() + (getMaxIncrease() - getMinIncrease()) * randomGenerator.nextDouble();
            this.setStockPrice(Ingredient.round(this.getStockPrice()+increase,2));
        } else {
            double decrease;
            decrease = getMinDecrease() + (getMaxDecrease() - getMinDecrease()) * randomGenerator.nextDouble();
            this.setStockPrice(Ingredient.round(this.getStockPrice()-decrease, 2));
        }
    }

    public Malt(Malt malt){
        this.setItemName(malt.getItemName());
        this.setStockPrice(malt.getStockPrice());
        this.setPackVolume(malt.getPackVolume());
        this.setUnit(malt.getUnit());
    }

    public Malt(){
        this.setUnit(UnitType.KILOGRAM);
    }

    public Malt(String itemName, double stockPrice, int packVolume, double minIncrease, double maxIncrease, double mindDecrease, double maxDecrease){
        this.setItemName(itemName);
        this.setStockPrice(stockPrice);
        this.setPackVolume(packVolume);
        this.setMinIncrease(minIncrease);
        this.setMaxIncrease(maxIncrease);
        this.setMinDecrease(mindDecrease);
        this.setMaxDecrease(maxDecrease);
        this.setUnit(UnitType.KILOGRAM);
        this.setQuantity(1);
    }

}
