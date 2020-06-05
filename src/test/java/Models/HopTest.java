package Models;

import org.junit.jupiter.api.Test;

class HopTest {

    @org.junit.jupiter.api.Test
    void priceRandomizerTest() throws Exception {
        double startPrice = 100;
        Ingredient hop = new Hop();
        hop.setStockPrice(startPrice);
        hop.setMaxIncrease(10);
        hop.setMinIncrease(8);
        hop.setMaxDecrease(10);
        hop.setMinDecrease(8);
        hop.randomizePrice();
        System.out.println("--------------------------TEST----------------- \n randomized price is: " + hop.getStockPrice());
        if(hop.getStockPrice() > startPrice){
            assert hop.getStockPrice() <= startPrice + hop.getMaxIncrease() &&
                    hop.getStockPrice() >= startPrice + hop.getMinIncrease();
        } else {
            assert hop.getStockPrice() >= startPrice - hop.getMaxDecrease() &&
                    hop.getStockPrice() <= startPrice - hop.getMinDecrease();
        }
    }

    @Test
    void test100Cases() throws Exception {
        for(int i = 0; i < 100; i++){
            priceRandomizerTest();
        }
    }
}