package praxis.ll;

import java.util.Arrays;
import java.util.List;

public class LL {
    public static void main(final String[] args) {

        // testAddRecursive();
        // testRemoveRecursive();
        // testRemove();
        testReverse();

    }

    public static void testAddRecursive() {

        List<Integer> list = Arrays.asList(8, 3, 10, 1, 6, 14, 4, 7, 13);
        Node<Integer> head = null;

        for (Integer data : list) {
            head = addRecursive(head, data);
        }

        display(head);
    }

    public static void testRemoveRecursive() {

        List<Integer> list = Arrays.asList(8, 3, 10, 1, 6, 14, 4, 7, 13);
        Node<Integer> head = null;

        for (Integer data : list) {
            head = add(head, data);
        }

        display(head);

        // remove middle node
        head = removeRecursive(head, 6);
        display(head);

        // remove first node
        head = removeRecursive(head, 8);
        display(head);

        // remove last node
        head = removeRecursive(head, 13);
        display(head);

        // remove node that does not exists
        head = removeRecursive(head, -1);
        display(head);

    }

    public static void testRemove() {

        List<Integer> list = Arrays.asList(8, 3, 10, 1, 6, 14, 4, 7, 13);
        Node<Integer> head = null;

        for (Integer data : list) {
            head = add(head, data);
        }

        display(head);

        // remove middle node
        head = remove(head, 6);
        display(head);

        // remove first node
        head = remove(head, 8);
        display(head);

        // remove last node
        head = remove(head, 13);
        display(head);

        // remove node that does not exists
        head = remove(head, -1);
        display(head);

    }

    public static void testReverse() {

        List<Integer> list = Arrays.asList(8, 3, 10, 1, 6, 14, 4, 7, 13);
        Node<Integer> head = null;

        for (Integer data : list) {
            head = add(head, data);
        }

        display(head);

        head = reverse(head);

        display(head);

        head = reverseRecursive(head);

        display(head);
    }

    public static <E extends Comparable<E>> void display(final Node<E> head) {

        Node<E> iter = head;
        while (iter != null) {
            System.out.print(iter.data + " ");
            iter = iter.next;
        }
        System.out.println("");

    }

    public static <E extends Comparable<E>> Node<E> add(final Node<E> head, final E data) {

        Node<E> temp = new Node<>(data);

        if (head == null) {
            return temp;
        } else {

            Node<E> iter = head;
            while (iter.next != null) {
                iter = iter.next;
            }
            iter.next = temp;
        }
        return head;
    }

    public static <E extends Comparable<E>> Node<E> addRecursive(final Node<E> node, final E data) {

        if (node == null) {
            return new Node<>(data);
        } else {
            node.next = addRecursive(node.next, data);
            return node;
        }

    }

    //remove recursive all nodes in the list
    public static <E extends Comparable<E>> Node<E> removeRecursive(final Node<E> node,
                                                                    final E data) {

        if (node == null) {
            return null;
        } else if (node.data.compareTo(data) == 0) {
            return node.next;
        } else {
            node.next = removeRecursive(node.next, data);
            return node;
        }
    }

    public static <E extends Comparable<E>> Node<E> remove(final Node<E> head,
                                                           final E data) {

        // list is empty
        if (head == null)
            return null;

        // remove first node
        if (head.data.compareTo(data) == 0) {
            return head.next;
        }

        Node<E> iter = head.next;
        Node<E> previous = head;

        while (iter != null) {

            if (iter.data.compareTo(data) == 0) {
                previous.next = iter.next;
                break;
            } else {
                previous = iter;
                iter = iter.next;
            }
        }
        return head;

    }

    private static <E extends Comparable<E>> Node<E> reverse(final Node<E> node) {

        if (node == null)
            return null;

        Node<E> head = node;
        Node<E> iter = head.next;

        head.next = null;

        while (iter != null) {
            Node<E> temp = iter.next;

            iter.next = head;
            head = iter;

            iter = temp;
        }
        return head;

    }

    private static <E extends Comparable<E>> Node<E> reverse1(final Node<E> node) {

        if (node == null)
            return null;

        Node<E> iter = node.next;
        Node<E> prev = node;

        while (iter != null) {
            Node<E> next = iter.next;

            iter.next = prev;
            prev = iter;
            iter = next;
        }
        return prev;

    }

    private static <E extends Comparable<E>> Node<E> reverseRecursive(final Node<E> node) {

        if (node == null || node.next == null)
            return node;

        Node<E> first = node;
        Node<E> second = node.next;
        first.next = null;

        Node<E> head = reverseRecursive(second);

        second.next = first;

        return head;

    }

    static class Node<E extends Comparable<E>> implements Comparable<Node<E>> {
        private E data;

        private Node<E> next;

        public Node(final Node<E> next) {

            this.next = next;

        }

        public Node(final E data) {

            this.data = data;
            this.next = null;
        }

        public Node(final E data, final Node<E> next) {

            this.data = data;
            this.next = next;
        }

        @Override
        public int compareTo(final Node<E> o) {

            return this.data.compareTo(o.data);
        }

        @Override
        public String toString() {

            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(data) + " ");
            if (this.next != null) {
                sb.append(String.valueOf(this.next.toString()));
            }
            return sb.toString();
        }

        public E getData() {

            return data;
        }

        public Node<E> getNext() {

            return next;
        }

    }

}
