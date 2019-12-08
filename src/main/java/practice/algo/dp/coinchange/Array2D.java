package practice.algo.dp.coinchange;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Array2D {
    public static void main(final String[] args) {

        int amount = 5;
        int[] coins = {1, 2, 3, 4};

        System.out.println(coinChangeTotalWays(amount, coins));
        System.out.println(coinChangeTotalWaysDuplicatesAllowed(amount, coins));

        System.out.println("-------------------------------------------------");
        System.out.println(coinChangeMinNumberOfCoins(amount, coins));
        System.out.println(coinChangeMinNumberOfCoinsDuplicatesAllowed(amount, coins));

        System.out.println("-------------------------------------------------");
        System.out.println(coinChangeMaxNumberOfCoins(amount, coins));
        System.out.println(coinChangeMaxNumberOfCoinsDuplicatesAllowed(amount, coins));

    }

    public static int coinChangeTotalWays(final int amount, final int[] coins) {

        int[][] cache = new int[coins.length + 1][amount + 1];

        // when no coins are avaliable then there is 0 ways of creating amount
        for (int i = 0; i <= amount; ++i) {
            cache[0][i] = 0;
        }

        // when amount is 0 then return empty set
        for (int i = 0; i <= coins.length; ++i) {
            cache[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; ++i) {
            for (int j = 1; j <= amount; ++j) {

                if (coins[i - 1] > j) {
                    cache[i][j] = cache[i - 1][j];
                } else {
                    cache[i][j] = cache[i - 1][j] + cache[i - 1][j - coins[i - 1]];
                }
            }
        }

        System.out.println(Arrays.deepToString(cache)
                .replaceAll("],", "]\n"));

        return cache[coins.length][amount];

    }

    public static int coinChangeTotalWaysDuplicatesAllowed(final int amount, final int[] coins) {

        int[][] cache = new int[coins.length + 1][amount + 1];

        // when no coins are avaliable then there is 0 ways of creating amount
        for (int i = 0; i <= amount; ++i) {
            cache[0][i] = 0;
        }

        // when amount is 0 then return empty set
        for (int i = 0; i <= coins.length; ++i) {
            cache[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; ++i) {
            for (int j = 1; j <= amount; ++j) {

                if (coins[i - 1] > j) {
                    cache[i][j] = cache[i - 1][j];
                } else {
                    cache[i][j] = cache[i - 1][j] + cache[i][j - coins[i - 1]];
                }
            }
        }

        System.out.println(Arrays.deepToString(cache)
                .replaceAll("],", "]\n"));

        return cache[coins.length][amount];

    }

    // does not work
    public static int coinChangeMinNumberOfCoins(final int amount, final int[] coins) {

        int[][] cache = new int[coins.length + 1][amount + 1];

        IntStream.range(0, cache.length)
                .forEach(x -> Arrays.setAll(cache[x], y -> Integer.MAX_VALUE));

        // System.out.println(Arrays.deepToString(cache));

        // when no coins are avaliable then min number of coins is 0
        for (int i = 0; i <= amount; ++i) {
            cache[0][i] = 0;
        }

        // when amount is 0 then min number of coins is 0
        for (int i = 0; i <= coins.length; ++i) {
            cache[i][0] = 0;
        }

        for (int i = 1; i <= coins.length; ++i) {
            for (int j = 1; j <= amount; ++j) {

                if (coins[i - 1] > j) {
                    cache[i][j] = cache[i - 1][j];
                } else {

                    if (cache[i - 1][j] > 0)
                        cache[i][j] = Math.min(cache[i - 1][j], cache[i - 1][j - coins[i - 1]] + 1);
                    else
                        cache[i][j] = cache[i - 1][j - coins[i - 1]] + 1;

                }
            }
        }

        System.out.println(Arrays.deepToString(cache)
                .replaceAll("],", "]\n"));

        return cache[coins.length][amount];

    }

    // does not work
    public static int coinChangeMinNumberOfCoinsDuplicatesAllowed(final int amount, final int[] coins) {

        int[][] cache = new int[coins.length + 1][amount + 1];

        IntStream.range(0, cache.length)
                .forEach(x -> Arrays.setAll(cache[x], y -> Integer.MAX_VALUE));

        // System.out.println(Arrays.deepToString(cache));

        // when no coins are avaliable then min number of coins is 0
        for (int i = 0; i <= amount; ++i) {
            cache[0][i] = 0;
        }

        // when amount is 0 then min number of coins is 0
        for (int i = 0; i <= coins.length; ++i) {
            cache[i][0] = 0;
        }

        for (int i = 1; i <= coins.length; ++i) {
            for (int j = 1; j <= amount; ++j) {

                if (coins[i - 1] > j) {
                    cache[i][j] = cache[i - 1][j];
                } else {
                    cache[i][j] = Math.min(cache[i - 1][j], cache[i][j - coins[i - 1]] + 1);
                }
            }
        }

        System.out.println(Arrays.deepToString(cache)
                .replaceAll("],", "]\n"));

        return cache[coins.length][amount];

    }

    public static int coinChangeMaxNumberOfCoins(final int amount, final int[] coins) {

        int[][] cache = new int[coins.length + 1][amount + 1];

        IntStream.range(0, cache.length)
                .forEach(x -> Arrays.setAll(cache[x], y -> Integer.MIN_VALUE));

        // System.out.println(Arrays.deepToString(cache));

        // when no coins are avaliable then min number of coins is 0
        for (int i = 0; i <= amount; ++i) {
            cache[0][i] = 0;
        }

        // when amount is 0 then min number of coins is 0
        for (int i = 0; i <= coins.length; ++i) {
            cache[i][0] = 0;
        }

        for (int i = 1; i <= coins.length; ++i) {
            for (int j = 1; j <= amount; ++j) {

                if (coins[i - 1] > j) {
                    cache[i][j] = cache[i - 1][j];
                } else {
                    cache[i][j] = Math.max(cache[i - 1][j], cache[i - 1][j - coins[i - 1]] + 1);
                }
            }
        }

        System.out.println(Arrays.deepToString(cache)
                .replaceAll("],", "]\n"));

        return cache[coins.length][amount];

    }

    public static int coinChangeMaxNumberOfCoinsDuplicatesAllowed(final int amount, final int[] coins) {

        int[][] cache = new int[coins.length + 1][amount + 1];

        IntStream.range(0, cache.length)
                .forEach(x -> Arrays.setAll(cache[x], y -> Integer.MIN_VALUE));

        // System.out.println(Arrays.deepToString(cache));

        // when no coins are avaliable then min number of coins is 0
        for (int i = 0; i <= amount; ++i) {
            cache[0][i] = 0;
        }

        // when amount is 0 then min number of coins is 0
        for (int i = 0; i <= coins.length; ++i) {
            cache[i][0] = 0;
        }

        for (int i = 1; i <= coins.length; ++i) {
            for (int j = 1; j <= amount; ++j) {

                if (coins[i - 1] > j) {
                    cache[i][j] = cache[i - 1][j];
                } else {
                    cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - coins[i - 1]] + 1);
                }
            }
        }

        System.out.println(Arrays.deepToString(cache)
                .replaceAll("],", "]\n"));

        return cache[coins.length][amount];

    }

}
