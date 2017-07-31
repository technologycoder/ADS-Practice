package praxis.leetcode.tree;

public class MinimumDepthofBinaryTree111 extends TreeUtil {

    public static void main(String[] args) {

        // int[] nums = { 8, 5, 10, 9, 12, 11, 15 };

        int[] nums = { 1, 2 };

        TreeNode root = createBST(nums);

        display(root);

        System.out.println(minDepth(root));

    }

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;

    }

    public static int minDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else if (root.left != null) {
            return minDepth(root.left) + 1;
        } else {
            return minDepth(root.right) + 1;
        }

    }

    // wrong solution
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftTreeDepth = minDepth(root.left) + 1;
        int rightTreeDepth = minDepth(root.right) + 1;

        return Math.min(leftTreeDepth, rightTreeDepth);
    }

}
