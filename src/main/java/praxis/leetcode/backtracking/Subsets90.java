package praxis.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 
 Given a collection of integers that might contain duplicates, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class Subsets90 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 2};
        // int[] nums = { 1, 2, 3, 2 };
        System.out.println(subsetsWithDup(nums));

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {

        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                System.out.println(start + " - " + i);
                System.out.println(Arrays.toString(nums));
                continue; // skip duplicates
            }
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

}
