package praxis.leetcode.dp.coinchange;

public class Recursive {

    public static void main(String[] args) {
        int[] coins = { 1, 2, 3, 4 };
        int amount = 5;

        System.out.println(totalWays(coins, amount, 0, 0));
    }

    public static int totalWays(int[] coins, int amount, int sum, int index) {

        if (amount == sum)
            return 1;
        if (sum > amount || index >= coins.length)
            return 0;

        int withCoin = totalWays(coins, amount, coins[index] + sum, index);
        int withOutCoin = totalWays(coins, amount, sum, index + 1);

        return withCoin + withOutCoin;
    }

}
