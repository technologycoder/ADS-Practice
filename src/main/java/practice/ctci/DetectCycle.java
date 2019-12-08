package practice.ctci;

public class DetectCycle {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 3};
        // int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        Node head = buildLinkedList(arr);
        // displayList(head);

        System.out.println(hasCycle(head));
    }

    private static boolean hasCycle(Node head) {

        Node fastIter = head;

        Node slowIter = head;

        int count = 0;

        while (fastIter != null && slowIter != null) {
            fastIter = fastIter.next;
            count++;

            if (count % 2 == 0) {
                slowIter = slowIter.next;
            }

            if (fastIter == slowIter) {
                return true;
            }
        }

        return false;

    }

    private static Node buildLinkedList(int[] arr) {

        Node head = createNode(arr[0]);

        for (int i = 1; i < arr.length; ++i) {
            displayList(head);
            addNode(head, arr[i]);
        }

        return head;

    }

    private static Node buildListWithCycle() {

        Node head = createNode(10);

        return head;

    }

    private static void displayList(Node node) {

        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print("null\n");

    }

    private static void addNode(Node head, int data) {

        Node node = findNode(head, data);
        if (node == null) {
            node = createNode(data);
        }

        Node iter = head;

        while (iter.next != null) {
            iter = iter.next;

        }

        iter.next = node;

    }

    private static Node findNode(Node head, int data) {

        Node iter = head;

        while (iter != null) {
            if (iter.data == data)
                return iter;
            iter = iter.next;
        }

        return null;

    }

    private static Node createNode(int data) {

        Node node = new Node();
        node.data = data;

        return node;

    }

    static class Node {
        int data;

        Node next;
    }

}
