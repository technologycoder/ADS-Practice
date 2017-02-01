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
        List<List<Integer>> solutions = new ArrayList<>();
        coinChangeRecursiveWithListSolution(amount, coins, 0, new ArrayList<Integer>(), solutions);
        System.out.println(solutions);

        System.out.println("---------");
        solutions.clear();
        coinChangeDuplicatesRecursiveWithListSolution(amount, coins, 0, new ArrayList<Integer>(), solutions);
        System.out.println(solutions);
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

    public static void coinChangeRecursiveWithListSolution(final int amount, final int[] coins, final int index,
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
            coinChangeRecursiveWithListSolution(amount - coin, coins, index + 1, tempSolution, solutions);
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
