package practice.algo;

public class StringMatching {
    public static void main(String[] args) {

        // System.out.println(subString("abcde", "be"));

        System.out.println(subStringContiguous("abcde", "bc"));

    }

    public static boolean subString(String str, String match) {

        int j = 0;
        for (int i = 0; i < str.length() && j < match.length(); ++i) {

            if (str.charAt(i) == match.charAt(j)) {
                j++;
            }
        }

        if (j == match.length())
            return true;

        return false;

    }

    public static boolean subStringContiguous(String str, String match) {

        for (int i = 0; i < str.length(); ++i) {

            int j = 0;
            for (; j < match.length(); ++j) {

                if (str.charAt(i + j) != match.charAt(j)) {
                    break;
                }
            }

            if (j == match.length()) {
                return true;
            }

        }

        return false;

    }

}
