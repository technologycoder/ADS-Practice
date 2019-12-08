package praxis.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum523 {
    public static void main(String[] args) {
        // testCheckSubarraySumCubic();
        // testCheckSubarraySumQuadratic();
        testCheckSubarraySumLinear();

    }

    public static void testCheckSubarraySumCubic() {

        int[] nums = {23, 2, 4, 6, 7};
        System.out.println(checkSubarraySumCubic(nums, 6));

        System.out.println(checkSubarraySumCubic(nums, 0));

        nums = new int[]{23, 2, 0, 0, 7};
        System.out.println(checkSubarraySumCubic(nums, 0));

        nums = new int[]{23, 2, -4, 0, 7};
        // System.out.println(checkSubarraySumCubic(nums, 10));
    }

    public static void testCheckSubarraySumQuadratic() {

        int[] nums = {23, 2, 4, 6, 7};
        System.out.println(checkSubarraySumQuadratic(nums, 6));

        System.out.println(checkSubarraySumQuadratic(nums, 0));

        nums = new int[]{23, 2, 0, 0, 7};
        System.out.println(checkSubarraySumQuadratic(nums, 0));

        nums = new int[]{23, 2, -4, 0, 7};
        // System.out.println(checkSubarraySumQuadratic(nums, 10));
    }

    public static boolean checkSubarraySumCubic(int[] nums, int k) {

        // nums is null
        // nums is 0 length
        // k < 0
        // numbers in nums are negative
        // k ==0, can't do sum%k when k ==0, but sum of two numbers could be 0

        if (nums == null || nums.length == 0 || k < 0)
            return false;

        for (int start = 0; start < nums.length; ++start) {
            for (int end = start + 1; end < nums.length; ++end) {

                int sum = 0;
                for (int i = start; i <= end; ++i) {

                    if (nums[i] < 0)
                        throw new IllegalArgumentException("negative numbers not allowed");
                    sum += nums[i];
                }
                if (k == sum || (k != 0 && sum % k == 0))
                    return true;
            }
        }
        return false;
    }

    public static boolean checkSubarraySumQuadratic(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k < 0)
            return false;

        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < 0)
                throw new IllegalArgumentException("negative numbers not allowed");
            sums[i] = sums[i - 1] + nums[i];
        }

        for (int start = 0; start < nums.length; ++start) {
            for (int end = start + 1; end < nums.length; ++end) {

                int sum = sums[end] - sums[start] + nums[start];

                if (k == sum || (k > 0 && sum % k == 0))
                    return true;

            }
        }

        return false;
    }

    public static void testCheckSubarraySumLinear() {

        int[] nums = {23, 2, 4, 6, 7};
        System.out.println(checkSubarraySumQuadratic(nums, 6));

        System.out.println(checkSubarraySumQuadratic(nums, 0));

        nums = new int[]{23, 2, 0, 0, 7};
        System.out.println(checkSubarraySumQuadratic(nums, 0));

        nums = new int[]{23, 2, -4, 0, 7};
        // System.out.println(checkSubarraySumQuadratic(nums, 10));
    }

    public static boolean checkSubarraySumLinear(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k < 0)
            return false;

        Map<Integer, Integer> remainderIndexMap = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {

            sum += nums[i];

            if (k > 0)
                sum = sum % k;

            if (remainderIndexMap.containsKey(sum)) {
                if (i - remainderIndexMap.get(sum) >= 2)
                    return true;
            } else
                remainderIndexMap.put(sum, i);
        }

        return false;
    }

}
