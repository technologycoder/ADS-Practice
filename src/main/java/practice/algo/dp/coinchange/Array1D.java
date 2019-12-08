package practice.algo.dp.coinchange;

import java.util.Arrays;

public class Array1D {
    public static void main(final String[] args) {

        int amount = 5;
        int[] coins = {1, 2, 3, 4};
        // -------6-----
        // [1,1,1,1,1]
        // [1,1,1,2]
        // [1,1,3]
        // [1, 4]
        // [2, 3]
        // [2,2,1]
        // --------2------
        // [1, 4]
        // [2, 3]
        System.out.println(coinChangeTotalWaysDuplicatesAllowed(amount, coins));
        System.out.println(coinChangeMinNumberOfCoinsDuplicatesAllowed(amount, coins));
        System.out.println(coinChangeMaxNumberOfCoinsDuplicatesAllowed(amount, coins));

    }

    public static int coinChangeTotalWaysDuplicatesAllowed(final int amount, final int[] coins) {

        int[] cache = new int[amount + 1];

        // there is one way for amount =0 {empty set}
        cache[0] = 1;

        for (int i = 0; i < coins.length; ++i) {
            int coin = coins[i];

            for (int j = coin; j <= amount; ++j) {
                cache[j] += cache[j - coin];
            }

        }
        return cache[amount];
    }

    public static int coinChangeMinNumberOfCoinsDuplicatesAllowed(final int amount, final int[] coins) {

        int[] cache = new int[amount + 1];

        Arrays.fill(cache, Integer.MAX_VALUE);

        // Min number of coins = 0
        cache[0] = 0;

        for (int i = 0; i < coins.length; ++i) {
            int coin = coins[i];

            for (int j = coin; j <= amount; ++j) {
                cache[j] = Math.min(cache[j], cache[j - coin] + 1);
            }

        }
        return cache[amount];
    }

    public static int coinChangeMaxNumberOfCoinsDuplicatesAllowed(final int amount, final int[] coins) {

        int[] cache = new int[amount + 1];

        Arrays.fill(cache, Integer.MIN_VALUE);

        // Max number of coins = 0
        cache[0] = 0;

        for (int i = 0; i < coins.length; ++i) {
            int coin = coins[i];

            for (int j = coin; j <= amount; ++j) {
                cache[j] = Math.max(cache[j], cache[j - coin] + 1);
            }

        }
        return cache[amount];
    }

}
