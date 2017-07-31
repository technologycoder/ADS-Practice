package praxis.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is
 * defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 * 
 *
 */
public class KDiffPairsInArray532 {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 1, 5 };
        int k = 2;
        // 2
        System.out.println(findPairs1(nums, k));

        nums = new int[] { 1, 2, 3, 4, 5 };
        k = 1;
        // 4
        System.out.println(findPairs1(nums, k));

        nums = new int[] { 1, 3, 1, 5, 4 };
        k = 0;
        // 1
        System.out.println(findPairs1(nums, k));

        nums = new int[] { 1, 2, 3, 4, 5 };
        k = 2;
        // 3
        System.out.println(findPairs1(nums, k));

        nums = new int[] { 1, 1, 1, 1, 1 };
        k = 0;
        // 1
        System.out.println(findPairs1(nums, k));
    }

    public static int findPairs(int[] nums, int k) {

        if (nums == null || nums.length < 2 || k < 0)
            return 0;

        Arrays.sort(nums);

        int cnt = 0;
        for (int i = 0, j = 1; i < nums.length && j < nums.length;) {
            int diff = Math.abs(nums[i] - nums[j]);
            if (diff == k) {
                cnt++;
                i++;

                int num = nums[j];
                j++;
                while (j < nums.length && nums[j] == num)
                    j++;

            } else if (diff < k) {
                j++;
            } else {
                i++;
                if (i == j)
                    j++;
            }
        }

        return cnt;

    }

    public static int findPairs2(int[] nums, int k) {
        Arrays.sort(nums);

        int start = 0, end = 1, result = 0;
        while (start < nums.length && end < nums.length) {
            if (start == end || nums[start] + k > nums[end]) {
                end++;
            } else if (nums[start] + k < nums[end]) {
                start++;
            } else {
                start++;
                result++;
                // start
                // |
                // [1, 1, ...., 8, 8]
                // |
                // end
                while (start < nums.length && nums[start] == nums[start - 1])
                    start++;
                end = Math.max(end + 1, start + 1);
            }
        }
        return result;
    }

    public static int findPairs1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                // count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }

        return count;
    }

}
