package practice.algo.dp;

public class SellStock {
    public static int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1)
            return 0;

        int min = prices[0]; // min so far
        int result = 0;

        // counter starts from 1
        for (int i = 1; i < prices.length; i++) {
            result = Math.max(result, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return result;
    }

    // If you were only permitted to complete at most one transaction (ie, buy
    // one and sell one share of the stock),
    public static int maxProfit_atMostSellBuyOnce(int[] prices) {

        if (prices == null || prices.length <= 1)
            return 0;

        // cannot set max to first price.
        int max = prices[1];
        int min = prices[0];

        for (int i = 1; i < prices.length; ++i) {

            int price = prices[i];
            if (price > max) {
                max = price;
            } else if (price < min) {
                min = price;
            }
        }

        return max - min;

    }

    public static int maxProfit_buysell_multipletimes(int[] prices) {

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }

}
