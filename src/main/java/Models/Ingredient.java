package Models;

import java.util.Random;

public abstract class Ingredient {
    private String itemName;
    private double stockPrice;
    private int qunantity;
    private double minIncrease;
    private double maxIncrease;
    private double minDecrease;
    private double maxDecrease;
    private UnitType unit;

    protected Random randomGenerator;

    public abstract void randomizePrice();

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public int getQunantity() {
        return qunantity;
    }

    public void setQunantity(int qunantity) {
        this.qunantity = qunantity;
    }

    public double getMinIncrease() {
        return minIncrease;
    }

    public void setMinIncrease(double minIncrease) {
        this.minIncrease = minIncrease;
    }

    public double getMaxIncrease() {
        return maxIncrease;
    }

    public void setMaxIncrease(double maxIncrease) {
        this.maxIncrease = maxIncrease;
    }

    public double getMinDecrease() {
        return minDecrease;
    }

    public void setMinDecrease(double minDecrease) {
        this.minDecrease = minDecrease;
    }

    public double getMaxDecrease() {
        return maxDecrease;
    }

    public void setMaxDecrease(double maxDecrease) {
        this.maxDecrease = maxDecrease;
    }

    public UnitType getUnit() {
        return unit;
    }

    public void setUnit(UnitType unit) {
        this.unit = unit;
    }

    public Random getRandomGenerator() {
        return randomGenerator;
    }

    public void setRandomGenerator(Random randomGenerator) {
        this.randomGenerator = randomGenerator;
    }
}
