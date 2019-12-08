package practice.ctci;

import practice.ds.list.LinkedList;
import practice.ds.list.LinkedList.Node;

import java.util.HashSet;
import java.util.Set;

public class LinkedLists {
    public static void removeDups(LinkedList linkedList) {

        Node current = linkedList.getHead();

        while (current != null) {

            Node runner = current;
            while (runner.next != null) {

                if (current.data == runner.next.data) {
                    // duplicate is advanced here
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }

    }

    public static void removeDupsWithBuffer(LinkedList linkedList) {

        Set<Integer> buffer = new HashSet<>();

        Node current = linkedList.getHead();

        Node previous = current;

        while (current != null) {

            if (buffer.contains(current.data)) {
                // previous does not change, just change previous.next
                previous.next = current.next;
            } else {
                buffer.add(current.data);
                previous = current;

            }
            current = current.next;
        }

    }

    public static Node kthToLast(LinkedList linkedList, int k) {

        Node iter = linkedList.getHead();
        Node iterK = null;

        int i = 1;
        while (iter != null) {

            if (i == k) {
                iterK = linkedList.getHead();
            } else if (i > k) {
                iterK = iterK.next;
            }
            iter = iter.next;
            i++;

        }

        if (i >= k) {
            return iterK;
        } else {
            return null;
        }

    }

    public static Node kthToLast_ctci(LinkedList linkedList, int k) {

        Node iter = linkedList.getHead();

        for (int i = 0; i < k; ++i) {
            if (iter == null)
                return null;
            iter = iter.next;

        }

        Node iterK = linkedList.getHead();

        while (iter != null) {

            iter = iter.next;
            iterK = iterK.next;
        }

        return iterK;
    }

}
