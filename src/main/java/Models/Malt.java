package Models;

public class Malt extends Ingredient {

    public void randomizePrice() {
        if (randomGenerator.nextBoolean()){
            double increase;
            do {
                increase = randomGenerator.nextDouble()*100;
            } while (increase > this.getMaxIncrease() || increase < this.getMinIncrease());
            this.setStockPrice(this.getStockPrice()+increase);
        } else {
            double decrease;
            do {
                decrease = randomGenerator.nextDouble()*100;
            } while (decrease > this.getMaxIncrease() || decrease < this.getMinIncrease());
            this.setStockPrice(this.getStockPrice()-decrease);
        }
    }

    public Malt(){
        this.setUnit(UnitType.KILOGRAM);
    }

    public Malt(String itemName, double stockPrice, int quantity, double minIncrease, double maxIncrease, double mindDecrease, double maxDecrease){
        this.setItemName(itemName);
        this.setStockPrice(stockPrice);
        this.setQunantity(quantity);
        this.setMinIncrease(minIncrease);
        this.setMaxIncrease(maxIncrease);
        this.setMinDecrease(mindDecrease);
        this.setMaxDecrease(maxDecrease);
        this.setUnit(UnitType.KILOGRAM);
    }

}
