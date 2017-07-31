package practice.algo.dp.coinchange;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Recursive {

    // TODO list solution : try returning list
    public static void main(final String[] args) {
        int amount = 5;
        int[] coins = { 1, 2, 3, 4 };

        System.out.println(coinChangeTotalWays(amount, coins, 0));

        System.out.println("---------");
        System.out.println(coinChangeTotalWaysDuplicatesAllowed(amount, coins, 0));

        System.out.println("---------");
        coinChangeRecursiveWithStringSolution(amount, coins, 0, "");

        System.out.println("---------");
        coinChangeDuplicatesRecursiveWithStringSolution(amount, coins, 0, "");

        System.out.println("---------");
        List<String> strSolutions = new ArrayList<>();
        coinChangeRecursiveWithListSolution(amount, coins, 0, new ArrayList<Integer>(), strSolutions);
        System.out.println(strSolutions);

        System.out.println("---------");
        List<List<Integer>> solutions = new ArrayList<>();
        coinChangeDuplicatesRecursiveWithListSolution(amount, coins, 0, new ArrayList<Integer>(), solutions);
        System.out.println(solutions);

        System.out.println("---------");
        int minNumberOfCoins = coinChangeDuplicatesRecursiveWithStringSolutionAndMinNumberOfCoins(amount, coins, 0, "");
        System.out.println("Min number of coins: " + minNumberOfCoins);
    }

    public static int coinChangeTotalWays(final int amount, final int[] coins, final int index) {

        if (amount == 0)
            return 1;
        else if (amount < 0 || index >= coins.length)
            return 0;
        else {

            return coinChangeTotalWays(amount - coins[index], coins, index + 1) +
                    coinChangeTotalWays(amount, coins, index + 1);
        }

    }

    public static int coinChangeTotalWaysDuplicatesAllowed(final int amount, final int[] coins, final int index) {

        if (amount == 0)
            return 1;
        else if (amount < 0 || index >= coins.length)
            return 0;
        else {

            return coinChangeTotalWaysDuplicatesAllowed(amount - coins[index], coins, index) +
                    coinChangeTotalWaysDuplicatesAllowed(amount, coins, index + 1);
        }

    }

    public static void coinChangeRecursiveWithStringSolution(final int amount, final int[] coins, final int index,
            final String solution) {

        if (amount == 0) {
            System.out.println(solution);
        } else if (amount < 0) {
            return;
        } else if (index >= coins.length) {
            return;
        } else {

            coinChangeRecursiveWithStringSolution(amount - coins[index], coins, index + 1,
                    String.format("%s  %s", coins[index], solution));
            coinChangeRecursiveWithStringSolution(amount, coins, index + 1, solution);
        }

    }

    public static void coinChangeDuplicatesRecursiveWithStringSolution(final int amount, final int[] coins,
            final int index, final String solution) {

        if (amount == 0) {
            System.out.println(solution);
        } else if (amount < 0) {
            return;
        } else if (index >= coins.length) {
            return;
        } else {

            coinChangeDuplicatesRecursiveWithStringSolution(amount - coins[index], coins, index,
                    String.format("%s  %s", coins[index], solution));
            coinChangeDuplicatesRecursiveWithStringSolution(amount, coins, index + 1, solution);
        }

    }

    public static int coinChangeDuplicatesRecursiveWithStringSolutionAndMinNumberOfCoins(final int amount, final int[] coins,
            final int index, final String solution) {

        if (amount == 0) {
            System.out.println(solution);
            return solution.replaceAll(" ", "")
                           .length();
        } else if (amount < 0) {
            return Integer.MAX_VALUE;
        } else if (index >= coins.length) {
            return Integer.MAX_VALUE;
        } else {

            int usingCoin = coinChangeDuplicatesRecursiveWithStringSolutionAndMinNumberOfCoins(amount - coins[index], coins, index,
                    String.format("%s  %s", coins[index], solution));
            int withoutUsingCoin = coinChangeDuplicatesRecursiveWithStringSolutionAndMinNumberOfCoins(amount, coins, index + 1, solution);

            return Math.min(usingCoin, withoutUsingCoin);
        }

    }

    public static void coinChangeRecursiveWithListSolution(final int amount, final int[] coins, final int index,
            final List<Integer> solution, final List<String> solutions) {

        if (amount == 0) {
            solutions.add(solution.toString());
            return;
        } else if (amount < 0) {
            return;
        } else if (index >= coins.length) {
            return;
        } else {

            int coin = coins[index];
            // List<Integer> tempSolution = solution.stream()
            // .collect(Collectors.toList());
            // tempSolution.add(coin);

            solution.add(coin);
            coinChangeRecursiveWithListSolution(amount - coin, coins, index + 1, solution, solutions);
            solution.remove(solution.size() - 1);
            coinChangeRecursiveWithListSolution(amount, coins, index + 1, solution, solutions);
        }
    }

    public static void coinChangeDuplicatesRecursiveWithListSolution(final int amount, final int[] coins,
            final int index, final List<Integer> solution, final List<List<Integer>> solutions) {

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
