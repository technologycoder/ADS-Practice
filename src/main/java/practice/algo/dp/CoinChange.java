package practice.algo.dp;

public class CoinChange {

    public static void coinChange(int amount, int[] coins, int index, String solution) {

        if (amount == 0) {
            System.out.println(solution);
        } else if (amount < 0) {
            return;
        } else if (index >= coins.length) {
            return;
        } else {

            coinChange(amount - coins[index], coins, index + 1, String.format("%s , %s", coins[index], solution));
            coinChange(amount, coins, index + 1, solution);
        }

    }

    public static void coinChangeWithDuplicates(int amount, int[] coins, int index, String solution) {

        if (amount == 0) {
            System.out.println(solution);
        } else if (amount < 0) {
            return;
        } else if (index >= coins.length) {
            return;
        } else {

            coinChange(amount - coins[index], coins, index, String.format("%s , %s", coins[index], solution));
            coinChange(amount, coins, index + 1, solution);
        }

    }
}
