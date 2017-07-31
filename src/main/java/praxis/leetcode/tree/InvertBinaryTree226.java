package praxis.leetcode.tree;

public class InvertBinaryTree226 extends TreeUtil {

    public static void main(String[] args) {
        TreeNode root = createSampleBST();

        root = invertTree(root);
        display(root);

    }

    public static TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;
        else {

            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);

            root.left = right;
            root.right = left;
            return root;
        }

    }

}
