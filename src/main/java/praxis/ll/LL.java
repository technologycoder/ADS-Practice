package praxis.ll;

import java.util.Arrays;
import java.util.List;

public class LL {

    public static void main(final String[] args) {

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

    public static <E extends Comparable<E>> void display(final Node<E> node) {

        if (node != null) {

            Node<E> iter = node;
            while (iter != null) {
                System.out.print(iter.data + " ");
                iter = iter.next;
            }
            System.out.println("");
        }

    }

    public static <E extends Comparable<E>> Node<E> add(final Node<E> node, final E data) {

        Node<E> head = node;

        Node<E> temp = new Node<>(data);

        if (head == null) {
            head = temp;
        } else {

            Node<E> iter = head;

            while (iter.next != null) {
                iter = iter.next;
            }

            iter.next = temp;

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

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

    }

}
