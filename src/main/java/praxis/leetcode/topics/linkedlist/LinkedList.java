package praxis.leetcode.topics.linkedlist;

public class LinkedList<E extends Comparable<E>> {

    private Node<E> head;

    public void add(E data) {

        Node<E> node = new Node<>(data, null);
        if (head == null) {
            head = node;
        } else {
            Node<E> iter = head;
            while (iter.next != null) {
                iter = iter.next;
            }
            iter.next = node;
        }

    }

    public void reverseList() {
        Node<E> curr = head;

        Node<E> prev = null;

        while (curr != null) {
            Node<E> next = curr.next;

            curr.next = prev;
            prev = curr;

            curr = next;
        }

        head = prev;

    }

    public void reverseListRecursive() {

        Node<E> iter = head;
        head = reverseListRecursive(iter);
    }

    private Node<E> reverseListRecursive(Node<E> node) {

        if (node == null || node.next == null)
            return node;

        Node<E> second = node.next;
        node.next = null;

        Node<E> rest = reverseListRecursive(second);
        second.next = node;

        return rest;

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        Node<E> iter = head;

        while (iter != null) {
            sb.append(iter.toString() + " ");
            iter = iter.next;
        }

        return sb.toString();

    }

    public static class Node<E extends Comparable<E>> implements Comparable<Node<E>> {

        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;

        }

        @Override
        public String toString() {
            return String.format("[%s]", data.toString());
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((data == null) ? 0 : data.hashCode());
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;

            Node<E> other = (Node<E>) obj;
            if (data == null) {
                if (other.data != null)
                    return false;
            } else if (!data.equals(other.data))
                return false;
            return true;
        }

        @Override
        public int compareTo(Node<E> o) {

            return this.data.compareTo(o.data);
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

    }

}
