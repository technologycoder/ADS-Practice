package praxis.string;

public class Permutation {
    public static void main(final String[] args) {

        String str = "ABC";
        // permutationRecursive(str, "");

        permutationRecursiveSwap(str.toCharArray(), str.length());

    }

    public static void permutationRecursive(final String str, final String solution) {

        if (str == null || str.length() == 0) {
            System.out.println(solution);
        } else {

            for (int i = 0; i < str.length(); ++i) {
                permutationRecursive(str.substring(0, i) + str.substring(i + 1),
                        solution + str.charAt(i));
            }
        }
    }

    public static void permutationRecursiveSwap(final char[] str, final int len) {

        if (len == 0) {
            System.out.println(str);
        } else {

            for (int i = 0; i < len; ++i) {
                swap(str, i, len - 1);
                permutationRecursiveSwap(str, len - 1);
                swap(str, i, len - 1);
            }
        }
    }

    public static void swap(final char[] str, final int i1, final int i2) {

        char temp = str[i1];
        str[i1] = str[i2];
        str[i2] = temp;

    }

}
