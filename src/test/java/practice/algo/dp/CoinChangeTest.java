package practice.algo.dp;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CoinChangeTest {

	@Test
	public void coinChangeRecursiveWithListSolution1() {

		int amount = 10;
		int[] coins = { 2, 3, 4, 5, 6 };

		List<List<Integer>> solutions = new ArrayList<>();
		CoinChange.coinChangeRecursiveWithListSolution(amount, coins, 0, new ArrayList<Integer>(), solutions);

		System.out.println(solutions);
		assertEquals("[[2, 3, 5], [4, 6]]", solutions.toString());

	}

	@Test
	public void coinChangeDuplicatesRecursiveWithListSolution1() {

		int amount = 10;
		int[] coins = { 2, 3, 4, 5, 6 };

		List<List<Integer>> solutions = new ArrayList<>();
		CoinChange.coinChangeDuplicatesRecursiveWithListSolution(amount, coins, 0, new ArrayList<Integer>(), solutions);

		System.out.println(solutions);
		assertEquals(
				"[[2, 2, 2, 2, 2], [2, 2, 2, 4], [2, 2, 3, 3], [2, 2, 6], [2, 3, 5], [2, 4, 4], [3, 3, 4], [4, 6], [5, 5]]",
				solutions.toString());

	}

	@Test
	public void coinChangeTotalNumberOfWaysCacheDPIterative_duplicatesAllowed() {
		int amount = 10;
		int[] coins = { 2, 3, 4, 5, 6 };

		assertEquals(9, CoinChange.coinChangeTotalNumberOfWaysCacheDPIterative(amount, coins));

	}

	@Test
	public void coinChangeWithMaxNumberOfCoins_duplicatesAllowed() {
		int amount = 10;
		int[] coins = { 2, 3, 4, 5, 6 };

		assertEquals(5, CoinChange.coinChangeWithMaxNumberOfCoins(amount, coins));

	}

	@Test
	public void coinChangeMinNumberOfWays_duplicatesAllowed() {
		int amount = 10;
		int[] coins = { 2, 3, 4, 5, 6 };

		assertEquals(2, CoinChange.coinChangeMinNumberOfWays(amount, coins));

	}

	@Test
	public void coinChangeTotalNumberOfWaysCacheDPIterative1() {
		int amount = 7;
		int[] coins = { 2, 3, 5, 6 };

		CoinChange.coinChangeTotalNumberOfWaysCacheDPIterative(amount, coins);

	}

	@Test
	public void coinChangeWithMaxNumberOfCoins1() {
		int amount = 7;
		int[] coins = { 2, 3, 5, 6 };

		CoinChange.coinChangeWithMaxNumberOfCoins(amount, coins);

	}

	@Test
	public void coinChangeMinNumberOfWays() {
		int amount = 5;
		int[] coins = { 1, 2 };

		CoinChange.coinChangeMinNumberOfWays(amount, coins);

	}

	@Test
	public void coinChangeDuplicatesRecursiveWithStringSolution1() {

		int amount = 10;
		int[] coins = { 2, 3, 4, 5, 6 };

		CoinChange.coinChangeDuplicatesRecursiveWithStringSolution(amount, coins, 0, "");

	}

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
