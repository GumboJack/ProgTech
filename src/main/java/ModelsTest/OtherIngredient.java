package ModelsTest;


public class OtherIngredient extends Ingredient {
    public void randomizePrice() {
    }

    public OtherIngredient(String itemName, double stockPrice, int quantity, UnitType unit){
        this.setItemName(itemName);
        this.setStockPrice(stockPrice);
        this.setPackVolume(quantity);
        this.setUnit(unit);
    }

    public OtherIngredient(OtherIngredient ingredient){
        this.setItemName(ingredient.getItemName());
        this.setStockPrice(ingredient.getStockPrice());
        this.setPackVolume(ingredient.getPackVolume());
        this.setUnit(ingredient.getUnit());
        this.setQuantity(1);
    }

    public OtherIngredient() {
    }
}
