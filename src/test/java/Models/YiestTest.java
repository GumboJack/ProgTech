package Models;

import org.junit.jupiter.api.Test;

class YiestTest {

    @Test
    void priceRandomizerTest() throws Exception {
        double startPrice = 100;
        Ingredient yiest = new Yiest();
        yiest.setStockPrice(startPrice);
        yiest.setMaxIncrease(20.11);
        yiest.setMinIncrease(4.643);
        yiest.setMaxDecrease(10.1021);
        yiest.setMinDecrease(5.21321);
        yiest.randomizePrice();
        System.out.println("--------------------------TEST----------------- \n randomized price is: " + yiest.getStockPrice());
        if(yiest.getStockPrice() > startPrice){
            assert yiest.getStockPrice() <= startPrice + yiest.getMaxIncrease() &&
                    yiest.getStockPrice() >= startPrice + yiest.getMinIncrease();
        } else {
            assert yiest.getStockPrice() >= startPrice - yiest.getMaxDecrease() &&
                    yiest.getStockPrice() <= startPrice - yiest.getMinDecrease();
        }
    }

    @Test
    void test100Cases() throws Exception {
        for(int i = 0; i < 100; i++){
            priceRandomizerTest();
        }
    }
}