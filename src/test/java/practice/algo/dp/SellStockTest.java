package practice.algo.dp;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SellStockTest {
    @Test
    public void maxProfit() {
        // buy low and sell high
        int[] prices = new int[]{10, 2, 20, 6, 50, 32};
        int profit = SellStock.maxProfit(prices);

        assertEquals(48, profit);

    }

    @Test
    public void maxProfit_1() {

        int[] prices = new int[]{10, 20, 40};
        int profit = SellStock.maxProfit(prices);

        assertEquals(30, profit);

    }

    @Test
    public void maxProfit_2() {

        int[] prices = new int[]{40, 20, 30};
        int profit = SellStock.maxProfit(prices);

        assertEquals(10, profit);

    }

    @Test
    public void maxProfit_atMostSellBuyOnce() {
        // buy low and sell high
        int[] prices = new int[]{10, 2, 20, 6, 50, 32};
        int profit = SellStock.maxProfit_atMostSellBuyOnce(prices);

        assertEquals(48, profit);

    }

    @Test
    public void maxProfit_atMostSellBuyOnce_1() {

        int[] prices = new int[]{10, 20, 40};
        int profit = SellStock.maxProfit_atMostSellBuyOnce(prices);

        assertEquals(30, profit);

    }

    @Test
    public void maxProfit_atMostSellBuyOnce_2() {

        int[] prices = new int[]{40, 20, 30};
        int profit = SellStock.maxProfit_atMostSellBuyOnce(prices);

        assertEquals(10, profit);

    }

    @Ignore
    @Test
    public void maxProfit_buysell_multipletimes() {
        // buy low and sell high
        int[] prices = new int[]{10, 2, 20, 6, 50, 32};
        int profit = SellStock.maxProfit_buysell_multipletimes(prices);

        //TODO: check
        assertEquals(48, profit);

    }

    @Test
    public void maxProfit_buysell_multipletimes_1() {

        int[] prices = new int[]{10, 20, 40};
        int profit = SellStock.maxProfit_buysell_multipletimes(prices);

        assertEquals(30, profit);

    }

    @Test
    public void maxProfit_buysell_multipletimes_2() {

        int[] prices = new int[]{40, 20, 30};
        int profit = SellStock.maxProfit_buysell_multipletimes(prices);

        assertEquals(10, profit);

    }

}
