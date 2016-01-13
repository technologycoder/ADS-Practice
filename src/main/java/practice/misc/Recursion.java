package practice.misc;

public class Recursion {

	public static void main(String[] args) {

		combinations("", "ABCD");
		// permutations("", "ABC");
		// towersOfHanoi(3, "A", "C", "B");
	}

	private static void combinations(String prefix, String str) {

		if (str.length() == 0) {
			System.out.println(prefix);
		} else {

			combinations(prefix + str.charAt(0), str.substring(1));
			combinations(prefix, str.substring(1));

		}

	}

	private static void permutations(String prefix, String str) {

		if (str.length() == 0) {
			System.out.println(prefix);
		} else {

			for (int i = 0; i < str.length(); ++i) {

				permutations(
						prefix + str.charAt(i),
						str.substring(0, i)
								+ str.substring(i + 1, str.length()));
			}

		}

	}

	private static void towersOfHanoi(int num, String from, String to,
			String aux) {

		if (num == 1) {
			System.out.println(String.format("Move %s from %s to %s", num,
					from, to));

		} else {

			towersOfHanoi(num - 1, from, aux, to);

			System.out.println(String.format("Move %s from %s to %s", num,
					from, to));

			towersOfHanoi(num - 1, aux, to, from);

		}

	}

}
