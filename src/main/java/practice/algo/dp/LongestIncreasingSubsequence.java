package practice.algo.dp;

public class LongestIncreasingSubsequence {

    public static void main(final String[] args) {
        int[] A = { 1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2 };
        LongestIncreasingSubsequence i = new LongestIncreasingSubsequence();
        i.findSubsequence(A);

        // ------------

        int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 }; // 2, 3, 7, 101
        System.out.println(lengthOfLIS(arr));

        // TODO: print all subsequences
    }

    public static int lengthOfLIS(final int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] max = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            max[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max[i] = Math.max(max[i], max[j] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < max.length; i++) {
            if (max[i] > result)
                result = max[i];
        }
        return result;
    }

    public void findSubsequence(final int[] arrA) {
        int[] LIS = new int[arrA.length];
        for (int i = 0; i < arrA.length; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                // check if previous elements > current element
                if (arrA[i] > arrA[j]) {
                    // update the max from the previous entries
                    if (max == -1 || max < LIS[j] + 1) {
                        max = 1 + LIS[j];
                    }
                }
            }
            if (max == -1) {
                // means none of the previous element has smaller than arrA[i]
                max = 1;
            }
            LIS[i] = max;
        }
        // find the max in the LIS[]
        int result = -1;
        int index = -1;
        for (int i = 0; i < LIS.length; i++) {
            if (result < LIS[i]) {
                result = LIS[i];
                index = i;
            }
        }
        // Print the result
        // Start moving backwards from the end and
        String path = arrA[index] + " ";
        int res = result - 1;
        for (int i = index - 1; i >= 0; i--) {
            if (LIS[i] == res) {
                path = arrA[i] + " " + path;
                res--;
            }
        }
        System.out.println("Longest Increasing subsequence: " + result);
        System.out.println("Actual Elements: " + path);
    }

}
