package Models;

import org.junit.jupiter.api.Test;

class MaltTest {

    @Test
    void priceRandomizerTest() throws Exception {
        double startPrice = 100;
        Ingredient malt = new Malt();
        malt.setStockPrice(startPrice);
        malt.setMaxIncrease(100.12310);
        malt.setMinIncrease(55.01231023);
        malt.setMaxDecrease(44.123120);
        malt.setMinDecrease(22.12023);
        malt.randomizePrice();
        System.out.println("--------------------------TEST----------------- \n randomized price is: " + malt.getStockPrice());
        if(malt.getStockPrice() > startPrice){
            assert malt.getStockPrice() <= startPrice + malt.getMaxIncrease() &&
                    malt.getStockPrice() >= startPrice + malt.getMinIncrease();
        } else {
            assert malt.getStockPrice() >= startPrice - malt.getMaxDecrease() &&
                    malt.getStockPrice() <= startPrice - malt.getMinDecrease();
        }
    }

    @Test
    void test100Cases() throws Exception {
        for(int i = 0; i < 100; i++){
            priceRandomizerTest();
        }
    }
}