package practice.misc;

public class PermutationCombination {

	public static void main(String[] args) {

		permute("", "123");

	}

	private static void permute(String prefix, String str) {

		if (str.length() == 0) {
			System.out.println(prefix);
		} else {

			for (int i = 0; i < str.length(); ++i) {

				permute(prefix + str.charAt(i),
						str.substring(0, i)
								+ str.substring(i + 1, str.length()));

			}

		}

	}

}
