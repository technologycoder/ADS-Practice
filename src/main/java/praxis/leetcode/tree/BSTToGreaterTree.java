package praxis.leetcode.tree;

public class BSTToGreaterTree extends TreeUtil {
    static int sum = 0;

    public static void main(String[] args) {

        TreeNode tree = createBST(new int[]{5, 2, 13});
        inorder(tree);
        System.out.println();
        System.out.println(treeSum(tree));

        // convertBST(tree, 0);
        convertBSTGlobalSum(tree);
        inorder(tree);
        System.out.println();
    }

    public static int convertBST(TreeNode node, int sum) {

        if (node == null)
            return 0;

        int rightSum = convertBST(node.right, sum);
        node.val += rightSum;

        int leftSum = convertBST(node.left, node.val);

        return leftSum > node.val ? leftSum : node.val;

    }

    public static TreeNode convertBSTGlobalSum(TreeNode node) {

        if (node == null)
            return null;

        convertBSTGlobalSum(node.right);

        node.val += sum;
        sum = node.val;

        convertBSTGlobalSum(node.left);

        return node;

    }

    public static int treeSum(TreeNode node) {

        if (node == null)
            return 0;
        else {
            int leftSum = treeSum(node.left);
            int rightSum = treeSum(node.right);
            return (node.val + leftSum + rightSum);
        }
    }

    public static void inorder(TreeNode node) {

        if (node == null)
            return;

        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);

    }

}
