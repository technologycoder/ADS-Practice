package praxis.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContiguousArray525 {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0 };

        // System.out.println(findMaxLength(nums));

        nums = new int[] { 0, 0, 0, 0, 1, 0 };

        System.out.println(findMaxLength(nums));

    }

    public static int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
        }

        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;
        System.out.print(max + " ");
        System.out.println(sumToIndex);
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }

            System.out.print(max + " ");
            System.out.println(sumToIndex);
        }

        return max;
    }

    public static int findMaxLength1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        map.get(0)
           .add(0);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }

            if (!map.containsKey(sum)) {
                map.put(sum, new ArrayList<>());
            }

            map.get(sum)
               .add(i + 1);
        }

        int maxLength = 0;
        for (List<Integer> val : map.values()) {
            maxLength = Math.max(maxLength, val.get(val.size() - 1) - val.get(0));
        }

        return maxLength;
    }

    public int findMaxLengthDP(int[] nums) {
        int n = nums.length, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[n + 1][2];
        for (int i = 1; i < dp.length; i++) {
            if (nums[i - 1] == 0) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
            }
            if (dp[i][0] == dp[i][1])
                res = Math.max(res, dp[i][0] * 2);
            else {
                int dif = dp[i][1] - dp[i][0];
                if (map.containsKey(dif))
                    res = Math.max(res, 2 * (dp[i][0] - dp[map.get(dif)][0]));
                else
                    map.put(dif, i);
            }
        }
        return res;
    }

}
