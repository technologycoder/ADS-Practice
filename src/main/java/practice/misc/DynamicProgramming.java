package practice.misc;

import java.util.Arrays;

public class DynamicProgramming {

	public static void main(String[] args) {

		// System.out.println(lcs("ABCBDAB", "BDCABA"));
		System.out.println(lcsDP("ABCBDAB", "BDCABA"));
	}

	private static String lcs(String str1, String str2) {

		if (str1.length() == 0 || str2.length() == 0) {
			return "";
		} else {

			if (str1.charAt(0) == str2.charAt(0)) {
				return str1.charAt(0)
						+ lcs(str1.substring(1), str2.substring(1));

			} else {
				String temp1 = lcs(str1.substring(1), str2);
				String temp2 = lcs(str1, str2.substring(1));

				return (temp1.length() > temp2.length()) ? temp1 : temp2;
			}
		}

	}

	private static String lcsDP(String str1, String str2) {

		int[][] table = new int[str1.length() + 1][str2.length() + 1];

		System.out.println(Arrays.deepToString(table).replaceAll("],",
				"]," + System.getProperty("line.separator")));

		for (int i = 0; i < str1.length(); ++i) {
			for (int j = 0; j < str2.length(); ++j) {
				if (str1.charAt(i) == str2.charAt(j)) {
					table[i + 1][j + 1] = table[i][j] + 1;
				} else {
					table[i + 1][j + 1] = Math.max(table[i + 1][j],
							table[i][j + 1]);
				}
			}
		}

		System.out.println(Arrays.deepToString(table).replaceAll("],",
				"]," + System.getProperty("line.separator")));

		return "";
	}
}
