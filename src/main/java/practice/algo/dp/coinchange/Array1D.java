package practice.algo.dp.coinchange;

public class Array1D {

    public static void main(final String[] args) {

        int amount = 5;
        int[] coins = { 1, 2, 3, 4 };

    }

    public static int coinChangeTotalWaysDuplicatesAllowed(final int amount, final int[] coins) {

        int[] cache = new int[amount + 1];

        cache[0] = 1;

        for (int i = 0; i < coins.length; ++i) {
            int coin = coins[i];

        }
        return 0;
    }

}
