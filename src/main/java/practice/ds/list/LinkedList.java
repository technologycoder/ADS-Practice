package practice.ds.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedList {

    private Node head;

    public LinkedList() {

    }

    public LinkedList(final int[] data) {

        for (int i = 0; i < data.length; ++i) {
            this.addNode(data[i]);
        }

    }

    public Node getHead() {
        return this.head;
    }

    public void addNode(final int data) {

        if (head == null) {
            head = new Node(data);
        } else {

            Node iter = head;

            while (iter.next != null) {
                iter = iter.next;
            }

            Node newNode = new Node(data);
            iter.next = newNode;
        }
    }

    @Override
    public String toString() {

        if (head != null) {

            List<Integer> list = new ArrayList<>();

            Node iter = head;

            while (iter != null) {
                list.add(iter.data);
                iter = iter.next;
            }

            return list.stream()
                       .map(String::valueOf)
                       .collect(Collectors.joining(" -> "));
        } else {
            return "EMPTY";
        }

    }

    public int[] toArray() {

        List<Integer> list = new ArrayList<>();

        Node iter = head;

        while (iter != null) {
            list.add(iter.data);
            iter = iter.next;
        }

        return list.stream()
                   .mapToInt(Integer::intValue)
                   .toArray();

    }

    public void removeHead() {

        if (head != null) {
            head = head.next;
        }
    }

    public void removeTail() {

        Node iter = head;

        while (iter != null && iter.next != null && iter.next.next != null) {
            iter = iter.next;
        }

        if (iter != null) {
            if (iter.next != null) {
                iter.next = iter.next.next;
            } else {
                // Only one element in the list
                head = iter.next;

            }
        }
    }

    public void reverseList() {

        if (this.head == null)
            return;

        Node iter = this.head.next;

        this.head.next = null;

        while (iter != null) {
            Node temp = iter.next;
            iter.next = head;
            head = iter;
            iter = temp;
        }

    }

    public void reverseListRecursive() {

        if (this.head == null || head.next == null)
            return;

        this.head = this.reverseListRecursive(this.head);

    }

    public Node reverseListRecursive(final Node node) {

        if (node == null || node.next == null)
            return node;

        Node second = node.next;
        node.next = null;

        Node rest = reverseListRecursive(second);
        second.next = node;

        return rest;

    }

    public static class Node {

        public int data;
        public Node next;

        public Node(final int data) {
            this.data = data;
        }

    }

}
