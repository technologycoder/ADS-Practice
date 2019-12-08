package praxis.string;

import java.util.ArrayList;
import java.util.HashMap;

public class PermutationWithDuplicates {
    public static HashMap<Character, Integer> buildFreqTable(final String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

    public static void printPerms(final HashMap<Character, Integer> map, final String prefix, final int remaining,
                                  final ArrayList<String> result) {

        if (remaining == 0) {
            result.add(prefix);
            return;
        }

        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                printPerms(map, prefix + c, remaining - 1, result);
                map.put(c, count);
            }
        }
    }

    public static ArrayList<String> printPerms(final String s) {

        ArrayList<String> result = new ArrayList<>();
        HashMap<Character, Integer> map = buildFreqTable(s);
        printPerms(map, "", s.length(), result);
        return result;
    }

    public static void main(final String[] args) {
        // String s = "aabbccc";
        // String s = "aabbc"; // 5!/2!*2!
        // String s = "aabbbbc"; // 5!/2!*3!
        String s = "aabb";
        ArrayList<String> result = printPerms(s);
        System.out.println("Count: " + result.size());
        for (String r : result) {
            System.out.println(r);
        }
    }

}
