package Models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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
            default:
                return "unit";
        }
    }
}
