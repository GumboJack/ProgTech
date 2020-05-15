package ModelsTest;

public class UnitHelper {

    public static String unitConverter(UnitType unitType){
        switch(unitType){
            case GRAM:
                return "g";
            case KILOGRAM:
                return "kg";
            case DECAGRAM:
                return "dkg";
            case MILLILITER:
                return "ml";
            case DECILITER:
                return "dl";
            case LITER:
                return "l";
            case DRAM:
                return "dr";
            case GILL:
                return "gill";
            case PINT:
                return "pint";
            case OUNCE:
                return "oz";
            case POUND:
                return "pound";
            case QUART:
                return "quart";
            case STONE:
                return "stone";
            case GALLON:
                return "gallon";
            case BARREL:
                return "barrel";
            default:
                return "unit";
        }
    }
}
