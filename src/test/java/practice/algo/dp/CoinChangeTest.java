package practice.algo.dp;

import org.junit.Test;

public class CoinChangeTest {

    @Test
    public void coinChange() {

        int amount = 5;
        int[] coins = { 1, 2, 3 };

        CoinChange.coinChange(amount, coins, 0, "");

    }

    @Test
    public void coinChangeWithDuplicates() {

        int amount = 5;
        int[] coins = { 1, 2, 3 };

        CoinChange.coinChangeWithDuplicates(amount, coins, 0, "");

    }
}
