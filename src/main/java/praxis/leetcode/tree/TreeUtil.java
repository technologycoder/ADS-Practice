package praxis.leetcode.tree;

import praxis.tree.TreePrinter;
import praxis.tree.TreePrinter.PrintableNode;

public class TreeUtil {
    public static TreeNode createSampleBST() {

        int[] nums = {4, 2, 6, 1, 3, 5, 7};

        TreeNode root = createBST(nums);

        TreePrinter.print(root);

        return root;
    }

    public static void display(TreeNode root) {

        TreePrinter.print(root);

    }

    public static TreeNode createBST(int[] nums) {

        TreeNode root = null;
        for (int num : nums) {
            root = addNum(root, num);
        }

        return root;
    }

    public static TreeNode addNum(TreeNode node, int num) {

        if (node == null) {
            return new TreeNode(num);
        } else {

            if (node.val > num) {
                node.left = addNum(node.left, num);
            } else {
                node.right = addNum(node.right, num);
            }
            return node;
        }
    }

    public static void inorder(TreeNode node) {

        if (node == null)
            return;

        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);

    }

    public static class TreeNode implements TreePrinter.PrintableNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {

            val = x;
        }

        @Override
        public PrintableNode getLeft() {

            return left;
        }

        @Override
        public PrintableNode getRight() {

            return right;
        }

        @Override
        public String getText() {

            return String.valueOf(val);
        }
    }

}
