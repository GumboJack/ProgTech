package Models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Ingredient {
    private String itemName;
    private double stockPrice;
    private int packVolume;
    private int quantity;
    private double minIncrease;
    private double maxIncrease;
    private double minDecrease;
    private double maxDecrease;
    private UnitType unit;

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

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

    public int getPackVolume() {
        return packVolume;
    }

    public void setPackVolume(int packVolume) {
        this.packVolume = packVolume;
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
}
