package practice.algo.dp;

public class Knapsack {
    // max value that could be packed in knapsack without exceeding size
    public static int knapsackRecursive(final int size, final int[] weight, final int[] value, final int index) {

        if (size <= 0 || index == weight.length) {
            return 0;
        } else {

            int val1 = 0;
            if (size - weight[index] >= 0) {
                val1 = knapsackRecursive(size - weight[index], weight, value, index + 1) + value[index];
            }
            int val2 = knapsackRecursive(size, weight, value, index + 1);

            return (val1 > val2) ? val1 : val2;

        }
    }

    public static int knapsackRecursiveDuplicatesAllowed(final int size, final int[] weight, final int[] value, final int index) {

        if (size <= 0 || index == weight.length) {
            return 0;
        } else {

            int val1 = 0;
            if (size - weight[index] >= 0) {
                val1 = knapsackRecursive(size - weight[index], weight, value, index) + value[index];
            }
            int val2 = knapsackRecursive(size, weight, value, index + 1);

            return (val1 > val2) ? val1 : val2;

        }

    }

    public static int knapsackFractionalGreedy(final int size, final int[] weight, final int[] value, final int index) {

        return 0;

    }

}
