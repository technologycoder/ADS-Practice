package practice.algo.dp;

public class SubsetSum {

    public static void main(final String[] args) {
        int[] num = { 3, 2, 7, 1 };

        int[] solution = new int[num.length];

        subsetSumRecursive(num, 0, 0, 6, solution);

        // System.out.println(Arrays.toString(solution));

        // System.out.println("\nFrom DP: " + subSetDP(num, 6));
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
            currSum += num[index];
            subsetSumRecursive(num, currSum, index + 1, sum, solution);
            currSum -= num[index];
            solution[index] = 0;// do not select the element
            subsetSumRecursive(num, currSum, index + 1, sum, solution);
        }
        return;
    }

    public static boolean subSetDP(final int[] num, final int sum) {

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
