package practice.algo;

//http://stackoverflow.com/questions/19479371/common-substring-of-two-strings
public class LongestCommonPrefixSuffix {
    // Given two Strings S1 and S2. Find the longest Substring which is a Prefix of S1 and suffix of S2.
    public static void main(final String[] args) {

        System.out.println("done");
    }

    public static String findLongestPrefixSuffix_backward(final String s1, final String s2) {

        for (int i = Math.min(s1.length(), s2.length()); i >= 0; i--) {
            if (s2.endsWith(s1.substring(0, i))) {
                return s1.substring(0, i);
            }
        }

        return "";
    }

    /*
     * Counting forward is somewhat more involved and easier to get wrong.
     */
    public static String findLongestPrefixSuffix_forward(final String s1, final String s2) {

        if (s1.equals(s2)) { //
            return s1; // a shortcut, not even needed
        } //

        int max = 0;
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s2.endsWith(s1.substring(0, i))) {
                max = i;
            }
        }
        return s1.substring(0, max);
    }

}
