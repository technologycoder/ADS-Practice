package praxis.leetcode.dq;

import praxis.leetcode.tree.TreeUtil1;

public class ReversePairsBST493 extends TreeUtil1 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, 3, 5, 1 };

        System.out.println(reversePairs(nums));

        nums = new int[] { 1, 3, 2, 3, 1 };

        System.out.println(reversePairs(nums));

    }

    public static int reversePairs(int[] nums) {

        int res = 0;
        TreeNode root = null;
        for (int num : nums) {
            res += search(root, 2 * num + 1);
            root = insert(root, num);
        }
        return res;
    }

}
