package practice.ds.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class BinaryTreeMisc {
    private static Node root;

    public static void main(String[] args) {

        testLevelHeight();

        int[] tree = new int[20];
        fillRandom(tree);

        System.out.println(Arrays.toString(tree));

        printTree(tree);

        for (int i = 0; i < tree.length; ++i) {

            insert(tree[i]);
        }

        printPreOrder(root);
        printTree(treeToArray());

    }

    private static void printPreOrder(Node node) {

        if (node == null) {
            return;
        } else {

            System.out.print(node.data + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);

        }

    }

    private static void testLevelHeight() {

        for (int i = 0; i <= 8; ++i) {

            System.out.println(String.format("i: %s, level: %s, height: %s", i, level(i), height(i)));
        }

    }

    public static void insert(int data) {

        if (root == null) {
            root = new Node(data);
        } else {
            insert2(data, root);
        }
    }

    public static void insert(int data, Node node) {

        if (node != null) {

            if (node.left == null) {
                node.left = new Node(data);
            } else if (node.right == null) {
                node.right = new Node(data);
            } else {

                if (node.left.left == null || node.left.right == null) {
                    insert(data, node.left);
                } else {
                    insert(data, node.right);
                }
            }
        }

    }

    public static void insert1(int data, Node node) {

        if (node != null) {

            if (node.left == null) {
                node.left = new Node(data);
            } else if (node.right == null) {
                node.right = new Node(data);
            } else {

                if (node.left.left == null || node.left.right == null) {
                    insert1(data, node.left);
                } else if (node.right.left == null || node.right.right == null) {
                    insert1(data, node.right);
                } else {
                    insert1(data, node.left.left);
                }
            }
        }

    }

    public static void insert2(int data, Node node) {

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(node);

        while (!queue.isEmpty()) {

            // System.out.println("adding data: " + data);
            // printQueue(queue);

            Node temp = queue.poll();
            if (temp.left == null) {
                temp.left = new Node(data);
                break;
            } else if (temp.right == null) {
                temp.right = new Node(data);
                break;
            } else {
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }

    }

    public static void printQueue(Queue<Node> queue) {

        int[] arr = queue.stream().map(n -> n.data).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(arr));

    }

    public static int[] treeToArray() {

        List<Integer> list = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            // int[] arr = queue.stream().map(n ->
            // n.data).mapToInt(Integer::intValue).toArray();
            // System.out.println(Arrays.toString(arr));

            Node node = queue.poll();
            list.add(node.data);

            if (node.left != null) {
                queue.add(node.left);
            } else if (node.data != -1) {
                queue.add(new Node(-1));
            }

            if (node.right != null) {
                queue.add(node.right);

            } else if (node.data != -1) {
                queue.add(new Node(-1));
            }
        }

        return list.stream().mapToInt(i -> i).toArray();

        // list.stream().mapToInt(Integer::intValue).toArray();

    }

    private static void printTree(int[] tree) {

        int height = height(tree.length);

        int nodesOnLevel = nodesOnLevel(height);

        int maxChars = nodesOnLevel * 10;

        int level = -1;

        for (int i = 0; i < tree.length; ++i) {

            int indexLevel = level(i);
            int nodesOnCurrLevel = nodesOnLevel(indexLevel);
            int startCharCount = maxChars / (nodesOnCurrLevel * 2);
            int inBetweenCharCount = startCharCount * 2;

            if (indexLevel > level) {
                // String str = ("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
                // .substring(0, (nodesOnCurrLevel / 2) == 0 ? 1
                // : (nodesOnCurrLevel / 2));
                String str = "\n\n\n";
                System.out.print(str);
                level = indexLevel;
                str = String.format("%1$" + startCharCount + "s", "");
                System.out.print(str);

            }

            String str = String.format("%1$-" + inBetweenCharCount + "s", tree[i]);
            System.out.print(str);

        }

        System.out.println("\n\n\n");

    }

    private static void printLevalAndHeight(int[] tree) {

        System.out.println("[index]\t[level]\t[nodes on level]\t[height]");

        for (int i = 0; i < tree.length; ++i) {

            String message = String.format("%s\t%s\t\t%s\t\t\t%s", i, level(i), nodesOnLevel(level(i)), height(i));
            System.out.println(message);
        }

    }

    private static int level(int index) {

        return (int) ((Math.log(index + 1) / Math.log(2)));

    }

    private static int nodesOnLevel(int level) {

        return (int) Math.pow(2, level);
    }

    private static int height(int size) {

        return size == 0 ? -1 : level(size - 1);

    }

    private static void fillRandom(int[] arr) {

        Random random = new Random();
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = Math.abs(random.nextInt() % 100);
        }

    }

    private static class Node {
        public int data;

        public Node left;

        public Node right;

        public Node(int data) {

            this.data = data;

        }

    }

}
