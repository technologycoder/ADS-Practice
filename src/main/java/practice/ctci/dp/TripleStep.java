package practice.ctci.dp;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

public class TripleStep {

	public static void main(String[] args) {
		tripleStepDP();
	}

	public static void tripleStepDP() {
		int n = 3;
		int[] cache = new int[n + 1];
		Arrays.fill(cache, -1);
		int total = tripleStepDP(n, cache);

		assertEquals(4, total);
		System.out.println(total);
	}

	public static int tripleStep(int n) {

		if (n == 0)
			return 1;
		else if (n < 0) {
			return 0;
		} else {

			return tripleStep(n - 1) + tripleStep(n - 2) + tripleStep(n - 3);
		}
	}

	public static int tripleStepDP(int n, int[] cache) {

		if (n == 0)
			return 1;
		else if (n < 0) {
			return 0;
		} else if (cache[n] != -1) {
			return cache[n];
		} else {
			cache[n] = tripleStepDP(n - 1, cache) + tripleStepDP(n - 2, cache) + tripleStepDP(n - 3, cache);

			return cache[n];
		}
	}

}
