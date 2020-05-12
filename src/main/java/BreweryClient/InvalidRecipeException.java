package BreweryClient;

public class InvalidRecipeException extends Throwable {
    @Override
    public String getMessage() {
        return "Quantities of ingredients does not match";
    }
}
