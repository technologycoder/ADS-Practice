package praxis.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum1 {

    public static void main(String[] args) {
        int[] nums = { 2, 15, 7, 11 };
        int target = 9;

        System.out.println(Arrays.toString(twoSumQuadratic(nums, target)));

        System.out.println(Arrays.toString(twoSumLogLinear(nums, target)));

        int[] nums1 = { 3, 2, 4 };
        int target1 = 6;

        System.out.println(Arrays.toString(twoSumQuadratic(nums1, target1)));

        System.out.println(Arrays.toString(twoSum1(nums1, target1)));

    }

    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSumQuadratic(int[] nums, int target) {

        int[] sol = new int[2];

        for (int i = 0; i < nums.length; ++i) {

            for (int j = i + 1; j < nums.length; ++j) {
                if ((nums[i] + nums[j]) == target) {
                    sol[0] = i;
                    sol[1] = j;
                    break;
                }

            }
        }

        return sol;

    }

    public static int[] twoSumLinear(int[] nums, int target) {

        int[] sol = new int[2];

        Map<Integer, Integer> numIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {

            int num = nums[i];

            if (numIndexMap.containsKey(target - num)) {

                sol[0] = numIndexMap.get(target - num);
                sol[1] = i;
                break;
            }
            numIndexMap.put(num, i);

        }

        return sol;

    }

    public static int[] twoSumLogLinear(int[] nums, int target) {

        int[] sol = new int[2];

        // AtomicInteger index = new AtomicInteger();
        // Map<Integer, Integer> numIndexMap = Arrays.stream(nums).boxed()
        // .collect(Collectors.toMap(Function.identity(), i ->
        // index.incrementAndGet() - 1));

        Map<Integer, Integer> numIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            numIndexMap.put(nums[i], i);
        }

        Arrays.sort(nums);

        System.out.println(numIndexMap);

        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {

            int sum = nums[lo] + nums[hi];

            if (sum == target) {
                sol[0] = numIndexMap.get(nums[lo]);
                sol[1] = numIndexMap.get(nums[hi]);
                break;
            } else if (sum > target)
                hi--;
            else
                lo++;

        }

        return sol;

    }

}
