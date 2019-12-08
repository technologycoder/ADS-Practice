package practice.algo.dp;

public class MaxContiguousSubsequenceSum {
    public static void main(final String[] args) {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        iterative(arr);

    }

    public static void iterative(final int[] arr) {

        int maxSum = 0;
        for (int i = 0; i < arr.length - 1; ++i) {

            int start = i;
            for (int end = start + 1; end < arr.length; ++end) {
                int sum = 0;
                for (int j = start; j <= end; ++j) {

                    sum += arr[j];
                    if (maxSum < sum) {
                        maxSum = sum;
                    }
                }
            }

        }

        System.out.println(maxSum);

    }

}
