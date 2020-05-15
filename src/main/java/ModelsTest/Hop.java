package ModelsTest;

import java.util.Random;

public class Hop extends Ingredient {
    private double alphaAcid;

    public void randomizePrice() {
        Random randomGenerator = new Random();
        if (randomGenerator.nextBoolean()){
            double increase;
            increase = getMinIncrease() + (getMaxIncrease() - getMinIncrease()) * randomGenerator.nextDouble();
            this.setStockPrice(Ingredient.round(this.getStockPrice()+increase,2));
        } else {
            double decrease;
            decrease = getMinDecrease() + (getMaxDecrease() - getMinDecrease()) * randomGenerator.nextDouble();
            this.setStockPrice(Ingredient.round(this.getStockPrice()-decrease,2));
        }
    }

    public Hop(){
        this.setUnit(UnitType.GRAM);
    }

    public Hop(double alphaAcid, String itemName, double stockPrice, int quantity, double minIncrease,
               double maxIncrease, double mindDecrease, double maxDecrease) {
        this.alphaAcid = alphaAcid;
        this.setItemName(itemName);
        this.setStockPrice(stockPrice);
        this.setQunantity(quantity);
        this.setMinIncrease(minIncrease);
        this.setMaxIncrease(maxIncrease);
        this.setMinDecrease(mindDecrease);
        this.setMaxDecrease(maxDecrease);
        this.setUnit(UnitType.GRAM);
    }

    public double getAlphaAcid() {
        return alphaAcid;
    }

    public void setAlphaAcid(double alphaAcid) {
        this.alphaAcid = alphaAcid;
    }

}
