package practice.hr;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    private static int n;

    private static int m;

    private static int[] coins;

    public static void main(String[] args) {

        assignSameInputDataSmall();
        // assignSameInputDataBig();
        // assignSameInputDataBig1();
        // readInputUsingScanner();

        // System.out.println(coinChangeRecursive(n, coins));

        // System.out.println(coinChangeRecursiveWithIndex(n, coins, 0));

        // System.out.println(makeChangeRecursive(n, coins, 0));

        // Dynamic Programming
        int[][] cache = new int[n + 1][coins.length];

        // System.out.println(coinChangeDPWithIndex(n, coins, 0, cache));

        // System.out.println(makeChangeDP(n, coins, 0, cache));

        // Iterative DP
        // System.out.println(coinChangeCacheDPIterative(n, coins));

        // System.out.println(coinChangeTotalNumberOfWays(n, coins));
        System.out.println(coinChangeMinNumberOfWays(n, coins));

    }

    public static int coinChangeTotalNumberOfWays(int amount, int[] coins) {

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

    public static int coinChangeMinNumberOfWays(int amount, int[] coins) {

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

    public static long coinChangeCacheDPIterative(int amount, int[] coins) {

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

    public static int coinChangeRecursive(int amount, int[] coins) {

        if (amount == 0) {
            return 1;
        } else if (amount < 0 || coins.length == 0) {
            return 0;
        } else {
            int countAfterUsingCoin = coinChangeRecursive(amount - coins[0], coins);

            int countWithoutUsingCoin = coinChangeRecursive(amount, Arrays.copyOfRange(coins, 1, coins.length));

            return countAfterUsingCoin + countWithoutUsingCoin;
        }

    }

    public static int coinChangeRecursiveWithIndex(int amount, int[] coins, int index) {

        if (amount == 0) {
            return 1;
        } else if (amount < 0 || index >= coins.length) {
            return 0;
        } else {
            int countAfterUsingCoin = coinChangeRecursiveWithIndex(amount - coins[index], coins, index);

            int countWithoutUsingCoin = coinChangeRecursiveWithIndex(amount, coins, index + 1);

            return countAfterUsingCoin + countWithoutUsingCoin;
        }

    }

    public static int coinChangeDPWithIndex(int amount, int[] coins, int index, int cache[][]) {

        if (cache[amount][index] > 0) {
            return cache[amount][index];
        } else if (amount == 0) {
            return 1;
        } else if (amount < 0 || index >= coins.length) {
            return 0;
        } else {
            int countAfterUsingCoin = coinChangeRecursiveWithIndex(amount - coins[index], coins, index);

            int countWithoutUsingCoin = coinChangeRecursiveWithIndex(amount, coins, index + 1);

            cache[amount][index] = countAfterUsingCoin + countWithoutUsingCoin;

            return countAfterUsingCoin + countWithoutUsingCoin;
        }

    }

    public static int makeChangeRecursive(int amount, int[] coins, int index) {

        if (amount == 0)
            return 1;
        else if (amount < 0 || index >= coins.length)
            return 0;
        else {

            int denomAmount = coins[index];
            int ways = 0;

            for (int i = 0; i * denomAmount <= amount; ++i) {
                int amountRemaining = amount - i * denomAmount;
                ways += makeChangeRecursive(amountRemaining, coins, index + 1);
            }

            return ways;
        }

    }

    public static int makeChangeDP(int amount, int[] coins, int index, int[][] cache) {

        if (cache[amount][index] > 0) {
            return cache[amount][index];
        } else if (amount == 0) {
            return 1;
        } else if (amount < 0 || index >= coins.length) {
            return 0;
        } else {

            int denomAmount = coins[index];
            int ways = 0;

            for (int i = 0; i * denomAmount <= amount; ++i) {
                int amountRemaining = amount - i * denomAmount;
                ways += makeChangeRecursive(amountRemaining, coins, index + 1);
            }
            cache[amount][index] = ways;
            return ways;
        }

    }

    public static void assignSameInputDataSmall() {
        // answer: 5
        n = 10;
        m = 4;
        coins = new int[]{2, 5, 3, 6};

    }

    public static void assignSameInputDataBig() {
        // answer: 96190959
        n = 166;
        m = 23;
        coins = new int[]{5, 37, 8, 39, 33, 17, 22, 32, 13, 7, 10, 35, 40, 2, 43, 49, 46, 19, 41, 1, 12, 11, 28};

    }

    public static void assignSameInputDataBig1() {
        // answer: 3542323427
        n = 250;
        m = 26;
        coins = new int[]{8, 47, 13, 24, 25, 31, 32, 35, 3, 19, 40, 48, 1, 4, 17, 38, 22, 30, 33, 15, 44, 46, 36, 9,
                20, 49};

    }

    public static void readInputUsingScanner() {

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        coins = new int[m];

        for (int i = 0; i < m; ++i) {
            coins[i] = in.nextInt();
        }

    }

}
