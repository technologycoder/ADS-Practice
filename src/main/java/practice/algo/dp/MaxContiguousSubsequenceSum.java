package practice.algo.dp;

public class MaxContiguousSubsequenceSum {

    public static void main(final String[] args) {

        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        // iterative(arr);
        System.out.println(recursive(arr, 0));

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

    public static int recursive(final int[] arr, final int index) {

        if (index >= arr.length)
            return 0;

        int withMaxSum = recursive(arr, index + 1) + arr[index];
        int withOutMaxSum = recursive(arr, index + 1);

        return Math.max(withMaxSum, withOutMaxSum);

    }

    public static int recursive1(final int[] arr, final int index) {

        if (index >= arr.length)
            return 0;

        int maxSum = 0;
        int sum = 0;
        for (int i = index; i < arr.length; ++i) {
            sum += recursive(arr, index + 1) + arr[i];

            if (sum > maxSum)
                maxSum = sum;
        }

        return maxSum;

    }

}
