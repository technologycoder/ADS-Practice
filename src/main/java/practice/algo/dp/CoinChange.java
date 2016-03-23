package practice.algo.dp;

import java.util.List;
import java.util.stream.Collectors;

//(1)All the different ways we can create change using the available coins.
//(2) minimum number of coins required to create change
public class CoinChange {

	public static void coinChangeRecursiveWithStringSolution(int amount, int[] coins, int index, String solution) {

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

	public static void coinChangeDuplicatesRecursiveWithStringSolution(int amount, int[] coins, int index,
			String solution) {

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

	public static void coinChangeRecursiveWithListSolution(int amount, int[] coins, int index, List<Integer> solution,
			List<List<Integer>> solutions) {

		if (amount == 0) {
			solutions.add(solution);
			return;
		} else if (amount < 0) {
			return;
		} else if (index >= coins.length) {
			return;
		} else {

			int coin = coins[index];
			List<Integer> tempSolution = solution.stream().collect(Collectors.toList());
			tempSolution.add(coin);
			coinChangeRecursiveWithListSolution(amount - coin, coins, index + 1, tempSolution, solutions);
			coinChangeRecursiveWithListSolution(amount, coins, index + 1, solution, solutions);
		}
	}

	public static void coinChangeDuplicatesRecursiveWithListSolution(int amount, int[] coins, int index,
			List<Integer> solution, List<List<Integer>> solutions) {

		if (amount == 0) {
			solutions.add(solution);
			return;
		} else if (amount < 0) {
			return;
		} else if (index >= coins.length) {
			return;
		} else {

			int coin = coins[index];
			List<Integer> tempSolution = solution.stream().collect(Collectors.toList());
			tempSolution.add(coin);
			coinChangeDuplicatesRecursiveWithListSolution(amount - coin, coins, index, tempSolution, solutions);
			coinChangeDuplicatesRecursiveWithListSolution(amount, coins, index + 1, solution, solutions);
		}
	}
}
