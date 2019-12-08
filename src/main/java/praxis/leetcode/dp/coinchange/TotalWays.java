package praxis.leetcode.dp.coinchange;

public class TotalWays {
    public static void main(String[] args) {

        int amount = 5;
        int[] coins = {1, 2, 3, 4};

    }

    public static int totalWays(int[] coins, int amount, int index, int total) {

        if (total == amount) {
            return 1;
        } else if (index < 0 || index >= coins.length || total > amount) {
            return 0;
        } else {

            int countWithCoin = totalWays(coins, amount, index, total + coins[index]);
            int countWithoutCoin = totalWays(coins, amount, index + 1, total);

            return countWithCoin + countWithoutCoin;

        }

    }

}
