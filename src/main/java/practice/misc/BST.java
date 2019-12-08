package practice.misc;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private Node root;

    public static void main(String[] args) {

        BST bst = new BST();
        bst.insert(6);
        bst.insert(8);
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);
        bst.insert(5);

        // bst.display(bst.root);
        bst.displayBFS();
    }

    public void display(Node node) {

        if (node != null) {
            display(node.left);
            System.out.println(node.num);
            display(node.right);
        }
    }

    public void displayBFS() {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();

        queue.add(root);

        while (!queue.isEmpty()) {

            Node node = queue.remove();
            System.out.println(node.num);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }

        }

    }

    public void insert(int num) {

        if (root == null) {
            root = new Node(num);
        } else {
            insert(root, num);
        }

    }

    private void insert(Node node, int num) {

        if (node.num < num) {
            if (node.right == null) {
                node.right = new Node(num);
            } else {
                insert(node.right, num);
            }
        } else {
            if (node.left == null) {
                node.left = new Node(num);
            } else {
                insert(node.left, num);
            }
        }

    }

    public class Node {
        public int num;

        public Node left;

        public Node right;

        public Node(int num) {

            this.num = num;
        }
    }

}
