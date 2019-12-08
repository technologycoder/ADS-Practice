package practice.ctci.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PowerSet {
    public static void main(String[] args) {

        testPowerSetArray();
        testPowerSetList();
        testPowerSetList_duplicates();
        testPowerSetString();
        testSubsetsUsingBitVector();

        // printAllIndexes();
    }

    public static void testPowerSetArray() {

        int[] arr = {1, 3, 5};
        int[] set = new int[arr.length];
        powerSet(arr, set, 0);

    }

    public static void testPowerSetList() {

        int[] arr = {1, 3, 5};

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<>();
        powerSet(arr, result, results);

        assertEquals("[[1, 3, 5], [1, 3], [1, 5], [1], [3, 5], [3], [5], []]", results.toString());

    }

    public static void testPowerSetList_duplicates() {

        int[] arr = {1, 3, 3};

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<>();
        powerSet(arr, result, results);

        // System.out.println(results);
        assertEquals("[[1, 3, 3], [1, 3], [1, 3], [1], [3, 3], [3], [3], []]", results.toString());

    }

    public static void powerSet(int[] set, int[] arr, int index) {

        if (index == arr.length) {
            System.out.println(Arrays.toString(set));
        } else {

            int[] newSet = Arrays.copyOf(set, set.length);
            newSet[index] = arr[index];

            powerSet(newSet, arr, index + 1);
            powerSet(set, arr, index + 1);

        }

    }

    public static void powerSet(int[] arr, List<Integer> result, List<List<Integer>> results) {

        if (arr.length == 0) {
            results.add(result);
        } else {

            List<Integer> newResult = new ArrayList<>(result);
            newResult.add(arr[0]);

            powerSet(Arrays.copyOfRange(arr, 1, arr.length), newResult, results);
            powerSet(Arrays.copyOfRange(arr, 1, arr.length), result, results);

        }

    }

    public static void testPowerSetString() {

        String str = "ABC";
        String result = "";
        List<String> results = new ArrayList<>();

        powerSetString(str, result, results);

        // System.out.println(results);
        assertEquals("[CBA, BA, CA, A, CB, B, C, ]", results.toString());

    }

    public static void powerSetString(String str, String result, List<String> results) {

        if (str != null && str.length() == 0) {
            results.add(result);
        } else {

            powerSetString(str.substring(1), str.charAt(0) + result, results);
            powerSetString(str.substring(1), result, results);
        }

    }

    public static void testSubsetsUsingBitVector() {

        int[] arr = {1, 2, 3};
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        getSubsetsUsingBitVector(arr, results);

        System.out.println(results);

    }

    public static void getSubsetsUsingBitVector(int[] arr, List<List<Integer>> results) {

        int count = (int) Math.pow(2, arr.length);

        for (int i = 0; i < count; ++i) {

            List<Integer> result = new ArrayList<>();

            int index = 0;
            for (int k = i; k > 0; k >>= 1) {

                if ((k & 1) == 1) {
                    result.add(arr[index]);
                }
                index++;
            }

            results.add(result);
        }
    }

    public static void printAllIndexes() {

        for (int i = 0; i < 4; ++i) {

            System.out.println("----------");
            System.out.println(i);
            int index = 0;
            for (int k = i; k > 0; k >>= 1) {

                if ((k & 1) == 1) {
                    System.out.println(index);
                }
                index++;
            }
        }
    }

}
