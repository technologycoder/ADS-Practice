package practice.algo.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubstring {

    // http://algs4.cs.princeton.edu/63suffix/LongestCommonSubstring.java.html
    // https://karussell.wordpress.com/2011/04/14/longest-common-substring-algorithm-in-java/
    // http://stackoverflow.com/questions/34805488/finding-all-the-common-substrings-of-given-two-strings

    // http://www.geeksforgeeks.org/longest-common-substring/

    // https://github.com/shawnfan/LintCode/blob/master/Java/Longest%20Common%20Substring.java

    // https://modernpathshala.com/Article/4126/given-two-strings-write-a-program-to-find-longest-common-substring-in-given-string

    // http://algorithms.tutorialhorizon.com/dynamic-programming-longest-common-substring/
    public static void main(final String[] args) {

        // String x = "tutorialgramm";
        // String y = "thetutorialProgramming";

        String x = "adogboatcat";
        String y = "tdogcat";
        // System.out.println(lcsRecursive(x, y));
        // lcsRecursive(x, y, "");

        Set<String> results = new HashSet<>();
        // System.out.println(lcsRecursive(x, y, "", 0, results));
        // System.out.println(results);

        lcsDP(x, y);

    }

    public static void allSubstrings(final String s) {

    }

    public static int bruteForce(final String x, final String y) {

        return 0;

    }

    public static int lcsRecursive(final String x, final String y, final String str, final int maxLength, final Set<String> solutions) {

        int newMaxLength = maxLength;
        if (x == null || x.length() == 0 || y == null || y.length() == 0) {
            if (str.length() >= maxLength) {

                if (str.length() > maxLength) {
                    solutions.clear();
                    newMaxLength = str.length();
                }
                solutions.add(str);
            }
            return newMaxLength;
        }

        if (x.charAt(0) == y.charAt(0)) {
            String temp = str + x.charAt(0);
            return lcsRecursive(x.substring(1), y.substring(1), temp, maxLength, solutions);

        } else {

            if (str.length() >= maxLength) {

                if (str.length() > maxLength) {
                    solutions.clear();
                    newMaxLength = str.length();
                }
                solutions.add(str);
            }

            int m = lcsRecursive(x, y.substring(1), "", newMaxLength, solutions);
            if (m > newMaxLength)
                newMaxLength = m;
            int n = lcsRecursive(x.substring(1), y, "", newMaxLength, solutions);

            return newMaxLength > n ? newMaxLength : n;

        }

    }

    public static void lcsDP(String x, String y) {

        int m = x.length();
        int n = y.length();

        int[][] cache = new int[m + 1][n + 1];

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {

                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    cache[i][j] = cache[i - 1][j - 1] + 1;
                }

            }
        }

        System.out.println(Arrays.deepToString(cache)
                .replaceAll("],", "]\n"));

    }

}
