package ModelsTest;


public class OtherIngredient extends Ingredient {
    public void randomizePrice() {
    }

    public OtherIngredient(String itemName, double stockPrice, int packVolume, UnitType unit){
        this.setItemName(itemName);
        this.setStockPrice(stockPrice);
        this.setPackVolume(packVolume);
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
