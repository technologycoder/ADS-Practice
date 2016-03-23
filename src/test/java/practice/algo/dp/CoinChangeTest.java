package practice.algo.dp;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CoinChangeTest {

	@Test
	public void coinChangeRecursiveWithStringSolution() {

		int amount = 5;
		int[] coins = { 1, 2, 3 };

		CoinChange.coinChangeRecursiveWithStringSolution(amount, coins, 0, "");

	}

	@Test
	public void coinChangeDuplicatesRecursiveWithStringSolution() {

		int amount = 5;
		int[] coins = { 1, 2, 3 };

		CoinChange.coinChangeDuplicatesRecursiveWithStringSolution(amount, coins, 0, "");

	}

	@Test
	public void coinChangeRecursiveWithListSolution() {

		int amount = 5;
		int[] coins = { 1, 2, 3 };

		List<List<Integer>> solutions = new ArrayList<>();
		CoinChange.coinChangeRecursiveWithListSolution(amount, coins, 0, new ArrayList<Integer>(), solutions);

		System.out.println(solutions);
		assertEquals("[[2, 3]]", solutions.toString());

	}

	@Test
	public void coinChangeDuplicatesRecursiveWithListSolution() {

		int amount = 5;
		int[] coins = { 1, 2, 3 };

		List<List<Integer>> solutions = new ArrayList<>();
		CoinChange.coinChangeDuplicatesRecursiveWithListSolution(amount, coins, 0, new ArrayList<Integer>(), solutions);

		System.out.println(solutions);
		assertEquals("[[1, 1, 1, 1, 1], [1, 1, 1, 2], [1, 1, 3], [1, 2, 2], [2, 3]]", solutions.toString());

	}
}
