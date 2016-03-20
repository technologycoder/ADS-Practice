package practice.algo.recursion;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PermutationTest {

    @Test
    public void recursivePermute() {

        String str = "ABC";

        List<String> results = new ArrayList<>();

        Permutation.recursivePermute(str, "", results);

        Assert.assertArrayEquals(new String[] { "CBA", "BCA", "CAB", "ACB", "BAC", "ABC" }, results.toArray(new String[] {}));

    }

    @Test
    public void getPermutations() {

        String str = "ABC";

        List<List<String>> results = Permutation.getPermutations(str);
        List<String> permutations = results.get(str.length() - 1);

        System.out.println(permutations);

        System.out.println(results);
    }
}
