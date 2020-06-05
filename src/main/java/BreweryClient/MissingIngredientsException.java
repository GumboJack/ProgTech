package BreweryClient;

public class MissingIngredientsException extends Throwable {
    @Override
    public String getMessage() {
        return "Some of hte main ingredients are missing (malt, hop, yiest)";
    }
}
