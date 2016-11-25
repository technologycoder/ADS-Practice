package practice.hr.ds.tree;

public class PreorderTraversal {

    public static void main(final String[] args) {

        int[] arr = new int[] { 3, 5, 2, 1, 4, 6 };
        Node root = createTree(arr, 0, null);

        preOrder(root);

        System.out.println("height:" + height(root));

    }

    public static Node createTree(final int[] arr, final int index, final Node n) {

        if (index >= arr.length) {
            return null;
        }

        Node node = new Node();
        node.data = arr[index];
        node.left = createTree(arr, 2 * index + 1, node);
        node.right = createTree(arr, 2 * index + 2, node);

        return node;

    }

    public static void preOrder(final Node root) {

        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static void postOrder(final Node root) {

        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }

    public static void inOrder(final Node root) {

        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }

    public static int height(final Node root) {
        if (root == null)
            return -1;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    static void top_view(final Node root)
    {
        top_view(root, true, true);
    }

    static void top_view(final Node root, final boolean left, final boolean right) {

        if (root == null)
            return;
        if (left)
            top_view(root.left, true, false);
        System.out.print(root.data + " ");
        if (right)
            top_view(root.right, false, true);
    }

    public static class Node {
        int data;
        Node left;
        Node right;
    }

}
