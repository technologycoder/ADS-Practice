package praxis.leetcode.tree;

import praxis.tree.TreePrinter;
import praxis.tree.TreePrinter.PrintableNode;

//Tree node with count of nodes greater than equal to current node.
public class TreeUtil1 {
    public static TreeNode insert(TreeNode root, int val) {

        if (root == null) {
            root = new TreeNode(val);
        } else if (root.val == val) {
            root.count++;
        } else if (root.val > val) {
            root.left = insert(root.left, val);
        } else if (root.val < val) {
            root.count++;
            root.right = insert(root.right, val);
        }
        return root;

    }

    public static int search(TreeNode root, int val) {

        if (root == null) {
            return 0;
        } else if (root.val == val) {
            return root.count;
        } else if (root.val > val) {
            return search(root.left, val) + root.count;
        } else {
            return search(root.right, val);
        }

    }

    public static class TreeNode implements TreePrinter.PrintableNode {
        int val;

        int count;

        TreeNode left, right;

        public TreeNode(int val) {

            this.val = val;
            this.count = 1;
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

            return val + ":" + count;
        }
    }

}
