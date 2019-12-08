package practice.algo.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        //System.out.println(lcs("ABCBDAB", "BDCABA"));

        lcsDP("ABCBDAB", "BDCABA");
    }

    public static String lcs(final String x, final String y) {

        if (x == null || x.length() == 0 || y == null || y.length() == 0) {
            return "";
        }

        if (x.charAt(0) == y.charAt(0)) {
            return x.charAt(0) + lcs(x.substring(1), y.substring(1));
        } else {

            String temp1 = lcs(x, y.substring(1));
            String temp2 = lcs(x.substring(1), y);

            return temp1.length() > temp2.length() ? temp1 : temp2;
        }

    }

    public static void lcsDP(final String x, final String y) {

        int m = x.length();
        int n = y.length();

        int[][] table = new int[m + 1][n + 1];

        System.out.println(Arrays.deepToString(table)
                .replaceAll("],", "]," + System.lineSeparator()));

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {

                if (x.charAt(i - 1) == y.charAt(j - 1)) {

                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
                }

            }
        }

        System.out.println(Arrays.deepToString(table)
                .replaceAll("],", "]," + System.lineSeparator()));

        allLCS(table, m, n, x, "");

    }

    public static void lcsDP1(final String x, final String y) {

        int m = x.length();
        int n = y.length();

        int[][] table = new int[m + 1][n + 1];

        System.out.println(Arrays.deepToString(table)
                .replaceAll("],", "]," + System.getProperty("line.separator")));

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {

                if (x.charAt(i) == y.charAt(j)) {

                    table[i + 1][j + 1] = table[i][j] + 1;
                } else {
                    table[i + 1][j + 1] = Math.max(table[i][j + 1], table[i + 1][j]);
                }

            }
        }

        System.out.println(Arrays.deepToString(table)
                .replaceAll("],", "]," + System.getProperty("line.separator")));

        allLCS(table, m, n, x, "");

    }

    private static void allLCS(final int[][] table, final int row, final int col, final String x, final String str) {

        if (row == 0 || col == 0) {
            System.out.println(str);
        } else {
            if (table[row][col] == table[row - 1][col] || table[row][col] == table[row][col - 1]) {

                if (table[row][col] == table[row - 1][col])
                    allLCS(table, row - 1, col, x, str);

                if (table[row][col] == table[row][col - 1])
                    allLCS(table, row, col - 1, x, str);

            } else if (table[row][col] - 1 == table[row - 1][col - 1]) {
                allLCS(table, row - 1, col - 1, x, x.charAt(row - 1) + str);
            }
        }
    }

}
