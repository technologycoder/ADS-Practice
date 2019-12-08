package praxis.leetcode.dq;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf315 {
    public static void main(String[] args) {

        int[] nums = {5, 2, 6, 1};

        System.out.println(countSmallerQuadratic(nums));

    }

    public static List<Integer> countSmallerQuadratic(int[] nums) {

        List<Integer> sol = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {

            int count = 0;
            for (int j = i + 1; j < nums.length; ++j) {

                if (nums[i] > nums[j])
                    count++;
            }

            sol.add(count);
        }
        return sol;

    }

}
