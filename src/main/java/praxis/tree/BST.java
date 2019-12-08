package praxis.tree;

import java.util.Arrays;
import java.util.List;

public class BST {
    public static void main(final String[] args) {

        List<Integer> list = Arrays.asList(8, 3, 10, 1, 6, 14, 4, 7, 13);
        Node<Integer> root = null;

        for (Integer data : list) {
            root = insert(root, data);
        }

        TreePrinter.print(root);

        System.out.println("InOrder Traversal: " + inOrder(root));
        System.out.println("PreOrder Traversal: " + preOrder(root));
        System.out.println("PostOrder Traversal: " + postOrder(root));

        System.out.println("MIN node: " + findMin(root).getData());
        System.out.println("MAX node: " + findMax(root).getData());

        // remove node with NO children
        // removeNode(root, 4);

        // remove node with only LEFT children
        // removeNode(root, 14);

        // remove node with only RIGHT children
        // removeNode(root, 10);

        // remove node with BOTH children
        removeNode(root, 3);

    }

    private static <E extends Comparable<E>> void removeNode(final Node<E> root, final E data) {

        Node<E> temp = remove(root, null, data);
        TreePrinter.print(temp);

    }

    public static <E extends Comparable<E>> Node<E> findMin(final Node<E> node) {

        if (node == null) {
            return null;
        } else {
            if (node.left != null) {
                return findMin(node.left);
            } else {
                return node;
            }
        }

    }

    public static <E extends Comparable<E>> Node<E> findMax(final Node<E> node) {

        if (node == null) {
            return null;
        } else {
            if (node.right != null) {
                return findMax(node.right);
            } else {
                return node;
            }
        }

    }

    public static <E extends Comparable<E>> Node<E> insert(final Node<E> node, final E data) {

        Node<E> temp = node;
        if (temp == null) {
            temp = new Node<>(data);
        } else if (data
                .compareTo(node.getData()) <= 0) {
            temp.left = insert(node.getLeft(), data);
        } else {
            temp.right = insert(node.getRight(), data);
        }

        return temp;

    }

    public static <E extends Comparable<E>> Node<E> remove(final Node<E> node, final Node<E> parent, final E data) {

        Node<E> temp = node;

        if (node == null) {
            return null;
        } else if (node.data.compareTo(data) > 0) {
            temp.left = remove(node.left, node, data);
        } else if (node.data.compareTo(data) < 0) {
            temp.right = remove(node.right, node, data);
        } else if (node.data.compareTo(data) == 0) {

            if (parent == null) {
                return null;
            } else if (node.getLeft() == null && node.getRight() == null) {
                // NO children
                if (parent.left != null && (parent.left.compareTo(node) == 0)) {
                    parent.left = null;
                    temp = parent.left;

                } else if (parent.right != null && (parent.right.compareTo(node) == 0)) {
                    parent.right = null;
                    temp = parent.right;
                }

            } else if (node.getLeft() != null && node.getRight() == null) {
                // Only LEFT child exists
                if (parent.left != null && (parent.left.compareTo(node) == 0)) {
                    parent.left = node.left;
                    temp = parent.left;

                } else if (parent.right != null && (parent.right.compareTo(node) == 0)) {
                    parent.right = node.left;
                    temp = parent.right;
                }
            } else if (node.getLeft() == null && node.getRight() != null) {
                // Only RIGHT child exists
                if (parent.left != null && (parent.left.compareTo(node) == 0)) {
                    parent.left = node.right;
                    temp = parent.left;

                } else if (parent.right != null && (parent.right.compareTo(node) == 0)) {
                    parent.right = node.right;
                    temp = parent.right;
                }
            } else if (node.getLeft() != null && node.getRight() != null) {
                // BOTH children exists

                // find min element in right subtree
                Node<E> minElement = findMin(node.right);
                node.data = minElement.getData();

                remove(node.right, node, node.data);
            }

        }

        return temp;

    }

    public static <E extends Comparable<E>> String inOrder(final Node<E> node) {

        if (node == null)
            return "";
        return inOrder(node.left) + " " + node.data + inOrder(node.right);

    }

    public static <E extends Comparable<E>> String preOrder(final Node<E> node) {

        if (node == null)
            return "";
        return node.data + " " + preOrder(node.left) + preOrder(node.right);

    }

    public static <E extends Comparable<E>> String postOrder(final Node<E> node) {

        if (node == null)
            return "";
        return postOrder(node.left) + postOrder(node.right) + node.data + " ";

    }

    static class Node<E extends Comparable<E>> implements Comparable<Node<E>>, TreePrinter.PrintableNode {
        private E data;

        private Node<E> left;

        private Node<E> right;

        public Node(final E data) {

            this.data = data;
            this.left = null;
            this.right = null;

        }

        public Node(final E data, final Node<E> left, final Node<E> right) {

            this.data = data;
            this.left = left;
            this.right = right;

        }

        @Override
        public int compareTo(final Node<E> o) {

            return data.compareTo(o.getData());
        }

        public E getData() {

            return data;
        }

        @Override
        public Node<E> getLeft() {

            return left;
        }

        @Override
        public Node<E> getRight() {

            return right;
        }

        @Override
        public String getText() {

            return data.toString();
        }

    }

}
