package practice.algo.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KnapsackTest {

	@Test
	public void knapsackRecursive() {

		int size = 15;
		int weight[] = { 1, 1, 2, 4, 12 };
		int value[] = { 1, 2, 2, 10, 4 };

		int maxValue = Knapsack.knapsackRecursive(size, weight, value, 0);

		System.out.println(maxValue);

		assertEquals(15, maxValue);

	}

}
