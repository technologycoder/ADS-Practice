package practice.misc;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        // System.out
        // .println(coinChangeAllSolutionCount(5, new int[] { 1, 2, 3 }));

        coinChangeAllSolutions(5, new int[]{1, 2, 3}, "");
    }

    private static int coinChangeAllSolutionCount(int amount,
                                                  int[] denominations) {

        // System.out.println(String.format("[%s]  %s", amount,
        // Arrays.toString(denominations)));

        if (amount == 0) {
            return 1;
        } else if (amount < 0) {
            return 0;
        } else if (denominations.length == 0 && amount > 0) {
            return 0;

        } else {

            return coinChangeAllSolutionCount(amount - denominations[0],
                    denominations)
                    + coinChangeAllSolutionCount(amount, Arrays.copyOfRange(
                    denominations, 1, denominations.length));

        }

    }

    private static void coinChangeAllSolutions(int amount, int[] denominations,
                                               String solution) {

        // System.out.println(String.format("[%s]  %s", amount,
        // Arrays.toString(denominations)));

        if (amount == 0) {
            System.out.println(solution);
            return;
        } else if (amount < 0) {
            return;
        } else if (denominations.length == 0 && amount > 0) {
            return;

        } else {

            coinChangeAllSolutions(amount - denominations[0], denominations,
                    solution + denominations[0] + ", ");

            coinChangeAllSolutions(amount,
                    Arrays.copyOfRange(denominations, 1, denominations.length),
                    solution);

        }

    }

}
