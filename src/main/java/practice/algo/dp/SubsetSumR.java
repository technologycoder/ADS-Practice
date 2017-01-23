package practice.algo.dp;

public class SubsetSumR {
    // Solving Subset sum recursion
    // Programmed by Olac Fuentes
    // Last modified November 17, 2011
    // Subset sum consists of finding a subset of mySet whose elements add up to goal
    // It is a well-know NP-complete problem

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

    public static void main(final String[] args) {

        int[] mySet = { 2, 5, 8, 9, 12, 21, 33 };

        // Try multiple values of goal, print subset if it exists
        for (int goal = 0; goal < 100; goal++) {
            System.out.println("The Goal is : " + goal);
            System.out.println(subSetSumRecur(mySet, mySet.length - 1, goal));
        }
    }
}
