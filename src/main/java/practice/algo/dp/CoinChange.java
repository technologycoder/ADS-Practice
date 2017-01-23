package practice.algo.dp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//(1)All the different ways we can create change using the available coins.
//(2) minimum number of coins required to create change
public class CoinChange {

    public static long coinChangeTotalNumberOfWaysCacheDPIterative(final int amount, final int[] coins) {

        long[] cache = new long[amount + 1];
        // base case
        cache[0] = 1;

        for (int i = 0; i < coins.length; ++i) {

            int denomination = coins[i];
            for (int j = denomination; j <= amount; j++) {
                cache[j] += cache[j - denomination];
            }
        }

        System.out.println(Arrays.toString(cache));

        return cache[amount];
    }

    public static int coinChangeWithMaxNumberOfCoins(final int amount, final int[] coins) {

        int[] cache = new int[amount + 1];

        for (int i = 0; i <= amount; ++i) {

            for (int j = 0; j < coins.length; ++j) {
                int coin = coins[j];

                if ((i + coin) <= amount) {
                    cache[i + coin] = cache[i] + 1;
                }
            }
        }

        System.out.println(Arrays.toString(cache));

        return cache[amount];

    }

    public static int coinChangeMinNumberOfWays(final int amount, final int[] coins) {

        int[] cache = new int[amount + 1];

        for (int i = 0; i < cache.length; ++i) {
            cache[i] = Integer.MAX_VALUE;
        }

        cache[0] = 0;

        for (int i = 0; i <= amount; ++i) {

            for (int j = 0; j < coins.length; ++j) {
                int coin = coins[j];

                if (cache[i] == Integer.MAX_VALUE)
                    continue;

                if ((i + coin) <= amount) {
                    cache[i + coin] = Math.min(cache[i] + 1, cache[i + coin]);
                }
            }
        }

        System.out.println(Arrays.toString(cache));

        return cache[amount];

    }

    public static void coinChangeRecursiveWithStringSolution(final int amount, final int[] coins, final int index, final String solution) {

        if (amount == 0) {
            System.out.println(solution);
        } else if (amount < 0) {
            return;
        } else if (index >= coins.length) {
            return;
        } else {

            coinChangeRecursiveWithStringSolution(amount - coins[index], coins, index + 1,
                    String.format("%s , %s", coins[index], solution));
            coinChangeRecursiveWithStringSolution(amount, coins, index + 1, solution);
        }

    }

    public static void coinChangeDuplicatesRecursiveWithStringSolution(final int amount, final int[] coins, final int index,
            final String solution) {

        if (amount == 0) {
            System.out.println(solution);
        } else if (amount < 0) {
            return;
        } else if (index >= coins.length) {
            return;
        } else {

            coinChangeDuplicatesRecursiveWithStringSolution(amount - coins[index], coins, index,
                    String.format("%s , %s", coins[index], solution));
            coinChangeDuplicatesRecursiveWithStringSolution(amount, coins, index + 1, solution);
        }

    }

    public static void coinChangeRecursiveWithListSolution(final int amount, final int[] coins, final int index,
            final List<Integer> solution,
            final List<List<Integer>> solutions) {

        if (amount == 0) {
            solutions.add(solution);
            return;
        } else if (amount < 0) {
            return;
        } else if (index >= coins.length) {
            return;
        } else {

            int coin = coins[index];
            List<Integer> tempSolution = solution.stream()
                                                 .collect(Collectors.toList());
            tempSolution.add(coin);
            coinChangeRecursiveWithListSolution(amount - coin, coins, index + 1, tempSolution, solutions);
            coinChangeRecursiveWithListSolution(amount, coins, index + 1, solution, solutions);
        }
    }

    public static void coinChangeDuplicatesRecursiveWithListSolution(final int amount, final int[] coins, final int index,
            final List<Integer> solution, final List<List<Integer>> solutions) {

        if (amount == 0) {
            solutions.add(solution);
            return;
        } else if (amount < 0) {
            return;
        } else if (index >= coins.length) {
            return;
        } else {

            int coin = coins[index];
            List<Integer> tempSolution = solution.stream()
                                                 .collect(Collectors.toList());
            tempSolution.add(coin);
            coinChangeDuplicatesRecursiveWithListSolution(amount - coin, coins, index, tempSolution, solutions);
            coinChangeDuplicatesRecursiveWithListSolution(amount, coins, index + 1, solution, solutions);
        }
    }
}
