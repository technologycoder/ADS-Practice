package praxis.leetcode.backtracking;

import java.util.ArrayList;

public class PermutationWithoutDuplicates {
    public static ArrayList<String> getPerms(final String str) {

        if (str == null) {
            return null;
        }
        ArrayList<String> permutations = new ArrayList<>();
        if (str.length() == 0) { // base case
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0); // get the first character
        String remainder = str.substring(1); // remove the first character
        ArrayList<String> words = getPerms(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    public static String insertCharAt(final String word, final char c, final int i) {

        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    public static void main(final String[] args) {

        // ArrayList<String> list = getPerms("abcde");
        ArrayList<String> list = getPerms("abc");
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }
    }

}
