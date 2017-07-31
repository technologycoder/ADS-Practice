package praxis.leetcode.string;

public class LongestUncommonSubsequence521 {

    public static void main(String[] args) {
        System.out.println(findLUSlength("abc", "defg"));

    }

    public static int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

}
