package praxis.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        // subsets("ABC", "", 0);
        // subsets("ABC");

        // System.out.println(subsets("ABC", 0));

        // System.out.println(subsetsUsingBits("ABC"));

        subsets("ABC", "", 0);
        // subsets("ABC", "", 0, 2);
    }

    public static void subsets(String str, String result, int index) {

        if (index == str.length()) {
            result = "".equals(result) ? "_" : result;
            System.out.println(result);
            return;
        } else {

            subsets(str, result + str.charAt(index), index + 1);
            subsets(str, result, index + 1);

        }

    }

    public static void subsets(String str, String result, int index, int size) {

        if (size == result.length()) {
            System.out.println(result);
            return;
        } else if (index >= str.length()) {
            return;
        } else {
            subsets(str, result + str.charAt(index), index + 1, size);
            subsets(str, result, index + 1, size);

        }

    }

    public static void subsets(String str) {

        List<String> result = new ArrayList<>();
        result.add("");
        for (int i = 0; i < str.length(); ++i) {

            char ch = str.charAt(i);

            List<String> temp = new ArrayList<>();

            for (String s : result) {
                temp.add(s + ch);
            }

            result.addAll(temp);

        }

        System.out.println(result);

    }

    public static List<String> subsets(String str, int index) {

        List<String> result = new ArrayList<>();

        if (index == str.length()) {
            result.add("");
            return result;
        } else {

            List<String> temp = subsets(str, index + 1);
            result.addAll(temp);
            for (String s : temp) {

                char ch = str.charAt(index);
                result.add(s + ch);
            }
            return result;
        }
    }

    public static List<String> subsetsUsingBits(String str) {

        List<String> result = new ArrayList<>();
        result.add("");
        int subsetCount = (int) Math.pow(2, str.length());

        for (int i = 1; i < subsetCount; ++i) {

            int index = 0;

            int temp = i;
            String s = "";
            while (temp != 0) {

                if ((temp & 1) == 1) {
                    s += str.charAt(index);
                }
                index++;
                temp = temp >> 1;
            }

            result.add(s);
        }

        return result;

    }

}
