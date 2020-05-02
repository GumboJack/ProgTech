package Models;

public class Hop extends Ingredient {
    private double alphaAcid;

    public void randomizePrice() {
        if (randomGenerator.nextBoolean()){
            double increase;
            do {
                increase = randomGenerator.nextDouble()*10;
            } while (increase > this.getMaxIncrease() || increase < this.getMinIncrease());
            this.setStockPrice(this.getStockPrice()+increase);
        } else {
            double decrease;
            do {
                decrease = randomGenerator.nextDouble()*10;
            } while (decrease > this.getMaxIncrease() || decrease < this.getMinIncrease());
            this.setStockPrice(this.getStockPrice()-decrease);
        }
    }

    public Hop(){

    }

    public Hop(double alphaAcid, String itemName, double stockPrice, int quantity, double minIncrease, double maxIncrease, double mindDecrease, double maxDecrease) {
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
