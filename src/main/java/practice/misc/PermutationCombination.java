package practice.misc;

public class PermutationCombination {

	public static void main(String[] args) {

		String str = "ABC";
		// testPermutation(str);

		testCombination(str);

	}

	private static void testCombination(String str) {

		// combination("", str);
		// combinationUnordered("", str);

	}

	private static void combination(String prefix, String str) {

		if (str.length() == 0) {
			System.out.println(prefix);
		} else {

			combination(prefix + str.charAt(0), str.substring(1));
			combination(prefix, str.substring(1));
		}

	}

	// the for statement is same as permutation
	private static void combinationUnordered(String prefix, String str) {

		System.out.println(prefix);
		for (int i = 0; i < str.length(); ++i) {
			combinationUnordered(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));

		}

	}

	private static void testPermutation(String str) {

		// permute("", str);

		permuteUsingSwap(str);

	}

	private static void permute(String prefix, String str) {

		if (str.length() == 0) {
			System.out.println(prefix);
		} else {

			for (int i = 0; i < str.length(); ++i) {

				permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, str.length()));

			}

		}

	}

	private static void permuteUsingSwap(String str) {

		char[] arr = str.toCharArray();
		permuteUsingSwap(arr, arr.length);
	}

	private static void permuteUsingSwap(char[] arr, int n) {

		if (n == 1) {
			System.out.println(arr);
		} else {

			for (int i = 0; i < n; ++i) {

				swap(arr, i, n - 1);
				permuteUsingSwap(arr, n - 1);
				swap(arr, i, n - 1);
			}
		}
	}

	private static void swap(char[] arr, int i, int j) {

		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
