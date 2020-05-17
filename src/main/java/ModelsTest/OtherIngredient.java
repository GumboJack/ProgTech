package ModelsTest;


public class OtherIngredient extends Ingredient {
    public void randomizePrice() {
    }

    public OtherIngredient(String itemName, double stockPrice, int quantity, UnitType unit){
        this.setItemName(itemName);
        this.setStockPrice(stockPrice);
        this.setQunantity(quantity);
        this.setUnit(unit);
    }

    public OtherIngredient(OtherIngredient ingredient){
        this.setItemName(ingredient.getItemName());
        this.setStockPrice(ingredient.getStockPrice());
        this.setQunantity(ingredient.getQunantity());
        this.setUnit(ingredient.getUnit());
    }

    public OtherIngredient() {
    }
}
