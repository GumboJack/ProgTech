package Models;

class HopTest {

    @org.junit.jupiter.api.Test
    void randomizePrice() throws Exception {
        Hop hop = new Hop();
        hop.setStockPrice(100);
        hop.setMaxIncrease(10);
        hop.setMinIncrease(8);
        hop.setMaxDecrease(2);
        hop.setMinIncrease(1);
        hop.randomizePrice();
        System.out.println("--------------------------TEST----------------- \n randomized price is: " + hop.getStockPrice());
    }
}