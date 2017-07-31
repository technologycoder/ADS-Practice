package praxis.leetcode.backtracking;

public class Combination {

    public static void main(final String[] args) {

        combination("ABC", "");

    }

    public static void combination(final String str, final String prefix) {

        if (str == null || str.length() == 0) {
            System.out.println(prefix);
        } else {
            combination(str.substring(1), prefix + str.charAt(0));
            combination(str.substring(1), prefix);
        }

    }

}
