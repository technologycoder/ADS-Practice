package practice.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {
    public static void main(final String[] args) {

        int[] num = {1, 2, 3, 4};

        int[] solution = new int[num.length];

        // subsetSumRecursive(num, 0, 0, 5, solution);
        System.out.println(Arrays.toString(solution));

        // subSetSumRecur(num, 3, 5);

        List<String> solutions = new ArrayList<>();
        // subsetSumRecursiveDuplicatesAllowed(num, 0, 0, 5, "", solutions);
        solutions.stream()
                .forEach(System.out::println);

        System.out.println("\nFrom DP: " + subSetExistsDP(num, 5));

        // TODO
        // Add DP solution similar to coin change
    }

    public static boolean subSetSumRecur(final int[] mySet, final int n, final int goal) {

        if (goal == 0)
            return true;
        if ((goal < 0) | (n < 0))
            return false;
        if (subSetSumRecur(mySet, n - 1, goal - mySet[n])) {
            System.out.print(mySet[n] + " ");
            return true;
        }
        return (subSetSumRecur(mySet, n - 1, goal));
    }

    public static void subsetSumRecursive(final int[] num,
                                          int currSum,
                                          final int index,
                                          final int sum,
                                          final int[] solution) {

        if (currSum == sum) {
            System.out.println("\nSum found");
            for (int i = 0; i < solution.length; i++) {
                if (solution[i] == 1) {
                    System.out.print("  " + num[i]);
                }
            }

        } else if (index == num.length) {
            return;
        } else {
            solution[index] = 1;// select the element
            subsetSumRecursive(num, currSum + num[index], index + 1, sum, solution);
            solution[index] = 0;// do not select the element
            subsetSumRecursive(num, currSum, index + 1, sum, solution);
        }

    }

    public static void subsetSumRecursiveDuplicatesAllowed(final int[] num,
                                                           int currSum,
                                                           final int index,
                                                           final int sum,
                                                           String solution,
                                                           List<String> solutions) {

        if (currSum == sum) {

            solutions.add(solution);

        } else if (currSum > sum || index == num.length) {
            return;
        } else {
            subsetSumRecursiveDuplicatesAllowed(num, currSum + num[index], index, sum,
                    String.valueOf(num[index]) + " " + solution, solutions);
            subsetSumRecursiveDuplicatesAllowed(num, currSum, index + 1, sum,
                    solution, solutions);
        }

    }

    public static boolean subSetExistsDP(final int[] num, final int sum) {

        boolean[][] solution = new boolean[num.length + 1][sum + 1];
        // if sum is not zero and subset is 0, we can't make it
        for (int i = 1; i <= sum; i++) {
            solution[0][i] = false;
        }
        // if sum is 0 the we can make the empty subset to make sum 0
        for (int i = 0; i <= num.length; i++) {
            solution[i][0] = true;
        }
        //
        for (int i = 1; i <= num.length; i++) {
            for (int j = 1; j <= sum; j++) {
                // first copy the data from the top
                solution[i][j] = solution[i - 1][j];

                // If solution[i][j]==false check if can be made
                if (solution[i][j] == false && j >= num[i - 1])
                    solution[i][j] = solution[i][j] || solution[i - 1][j - num[i - 1]];
            }
        }
        return solution[num.length][sum];
    }

}
