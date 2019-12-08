package practice.algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void recursivePermute(String str, String temp, List<String> results) {

        if (str.isEmpty()) {
            results.add(temp);

        } else {

            for (int i = 0; i < str.length(); ++i) {

                recursivePermute(str.substring(0, i) + str.substring(i + 1), str.charAt(i) + temp, results);
            }
        }

    }

    public static List<List<String>> getPermutations(String str) {

        List<List<String>> results = new ArrayList<>();

        for (int i = 0; i < str.length(); ++i) {

            List<String> result = new ArrayList<String>();

            String character = str.substring(i, i + 1);
            if (i == 0) {
                result.add(character);

            } else {
                List<String> list = results.get(i - 1);

                for (String s : list) {

                    result.add(character + s);
                    for (int j = 0; j < s.length(); ++j) {

                        String temp = s.substring(0, j + 1) + character + s.substring(j + 1);
                        result.add(temp);
                    }
                }

            }

            results.add(result);

        }

        return results;

    }
}
