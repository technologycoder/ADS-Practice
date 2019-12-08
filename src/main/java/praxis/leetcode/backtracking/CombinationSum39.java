package praxis.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
 */
public class CombinationSum39 {
    public static void main(String[] args) {

        int[] nums = {2, 3, 6, 7};

        System.out.println(combinationSum(nums, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> solutions = new ArrayList<>();
        combinationSum(candidates, target, 0, 0, new ArrayList<Integer>(), solutions);

        return solutions;
    }

    public static void combinationSum(int[] candidates, int target, int index, int sum, List<Integer> solution,
                                      List<List<Integer>> solutions) {

        if (sum == target) {
            solutions.add(new ArrayList<Integer>(solution));
            return;
        } else if (index >= candidates.length || sum > target) {
            return;
        }

        solution.add(candidates[index]);
        combinationSum(candidates, target, index, sum + candidates[index], solution, solutions);
        solution.remove(solution.size() - 1);
        combinationSum(candidates, target, index + 1, sum, solution, solutions);

    }

}
