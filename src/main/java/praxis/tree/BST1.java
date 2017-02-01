package praxis.tree;

import java.util.Arrays;
import java.util.List;

import praxis.tree.TreePrinter.PrintableNode;

public class BST1 {

    public static void main(final String[] args) {
        // testInsert();
        // testInsertRecursive();
        testRemove();
        // testFindMin();
    }

    public static Node<Integer> setupData() {
        List<Integer> list = Arrays.asList(8, 3, 10, 1, 6, 14, 4, 7, 13);
        Node<Integer> root = null;

        for (Integer data : list) {
            root = insertRecursive(root, data);
        }

        TreePrinter.print(root);

        return root;
    }

    public static void testInsert() {

        Node<Integer> root = setupData();
    }

    public static void testFindMin() {

        Node<Integer> root = setupData();

        System.out.println(findMin(root));
    }

    public static void testInsertRecursive() {
        List<Integer> list = Arrays.asList(8, 3, 10, 1, 6, 14, 4, 7, 13);
        Node<Integer> root = null;

        for (Integer data : list) {
            root = insertRecursive(root, data);
        }

        TreePrinter.print(root);

    }

    public static void testRemove() {
        Node<Integer> root = setupData();

        // no children
        root = remove(root, 4);

        TreePrinter.print(root);

        // with right child
        root = remove(root, 6);

        TreePrinter.print(root);

        // with left child
        root = remove(root, 14);

        TreePrinter.print(root);

        // with both left and right child
        root = remove(root, 8);

        TreePrinter.print(root);
    }

    public static <E extends Comparable<E>> Node<E> remove(final Node<E> node,
            final E data) {

        if (node == null) {
            return null;
        } else if (node.data.compareTo(data) > 0) {
            node.left = remove(node.left, data);
        } else if (node.data.compareTo(data) < 0) {
            node.right = remove(node.right, data);
        } else {

            // no children
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left != null && node.right == null) { // ONLY left child
                return node.left;
            } else if (node.right != null && node.left == null) { // ONLY right child
                return node.right;
            } else if (node.left != null && node.right != null) {

                E minDataOnRight = findMin(node.right);
                node.data = minDataOnRight;
                node.right = remove(node.right, minDataOnRight);
                return node;
            }

        }

        return node;

    }

    public static <E extends Comparable<E>> E findMin(final Node<E> node) {

        if (node.left == null) {
            return node.data;
        } else {
            return findMin(node.left);
        }
    }

    public static <E extends Comparable<E>> Node<E> insert(final Node<E> root, final E data) {

        Node<E> newNode = new Node<>(data);
        if (root == null) {
            return newNode;
        } else {
            Node<E> iter = root;

            while (iter != null) {

                if (iter.data.compareTo(data) > 0) {
                    if (iter.left == null) {
                        iter.left = newNode;
                        break;
                    } else {
                        iter = iter.left;
                    }
                } else {
                    if (iter.right == null) {
                        iter.right = newNode;
                        break;
                    } else {
                        iter = iter.right;
                    }
                }
            }

        }

        return root;
    }

    public static <E extends Comparable<E>> Node<E> insertRecursive(final Node<E> node, final E data) {

        if (node == null) {
            return new Node<>(data);
        } else if (node.data.compareTo(data) > 0) {
            node.left = insertRecursive(node.left, data);
        } else {
            node.right = insertRecursive(node.right, data);
        }

        return node;
    }

    public static class Node<E extends Comparable<E>> implements Comparable<Node<E>>,
            TreePrinter.PrintableNode {

        private E data;
        private Node<E> left;
        private Node<E> right;

        public Node(final E data) {
            this.data = data;

        }

        @Override
        public int compareTo(final Node<E> o) {

            return this.data.compareTo(o.data);
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
            return data.toString();
        }

    }

}
