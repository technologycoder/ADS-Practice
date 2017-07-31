package praxis.leetcode.string;

import java.util.Scanner;

/**
 * 
 * Given an input string, reverse the string word by word.
 *
 * remove extra spaces in between string
 * 
 */
public class ReverseWords151 {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords(" "));
    }

    public static String reverseWords1(String s) {
        String[] parts = s.trim()
                          .split("\\s+");
        String out = "";
        for (int i = parts.length - 1; i > 0; i--) {
            out += parts[i] + " ";
        }
        return out + parts[0];
    }

    public String reverseWords2(String s) {
        Scanner parts = new Scanner(s);

        String result = "";

        while (parts.hasNext()) {
            result = parts.next() + " " + result;
        }

        return result.trim();
    }

    public static String reverseWords(String s) {

        if (s == null)
            throw new IllegalArgumentException("String cannot be null");

        char[] reversedStr = reverse(s.toCharArray(), 0, s.length() - 1);

        int start = 0;
        int end = reversedStr.length - 1;

        for (int i = 0; i < reversedStr.length; ++i) {
            if (reversedStr[i] == ' ') {

                reverse(reversedStr, start, i - 1);
                start = i + 1;
            }

        }

        // last word
        reverse(reversedStr, start, end);

        return String.valueOf(reversedStr);
    }

    private static char[] reverse(char[] wordArr, int start, int end) {

        while (start < end) {
            char temp = wordArr[start];
            wordArr[start] = wordArr[end];
            wordArr[end] = temp;
            start++;
            end--;
        }

        return wordArr;

    }

}
