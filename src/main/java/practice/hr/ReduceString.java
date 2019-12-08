package practice.hr;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReduceString {
    public static void main(String[] args) {

        String str = "The quick brown fox jumps over the lazy dog";
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        str = str.toLowerCase();
        for (int i = 0; i < str.length(); ++i) {
            Character c = str.charAt(i);
            if (' ' == c)
                continue;
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        System.out.println(map.keySet().size());
        System.out.println(map.keySet());
    }

    public static void main1(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution.
         */
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String reducedStr = removeAdjacentDuplicateCharacters(str);

        while (!str.equals(reducedStr) && !str.equals("Empty String")) {
            str = reducedStr;
            reducedStr = removeAdjacentDuplicateCharacters(str);
        }

        System.out.println(reducedStr);
    }

    public static String removeAdjacentDuplicateCharacters(String str) {

        String result = str;
        for (int i = 0; i < str.length() - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                result = str.substring(0, i) + str.substring(i + 2);
            }
        }

        if ("".equals(result)) {
            return "Empty String";
        } else {
            return result;
        }
    }

}
