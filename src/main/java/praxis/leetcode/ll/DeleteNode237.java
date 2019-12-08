package praxis.leetcode.ll;

public class DeleteNode237 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        ListNode head = createList(nums);
        display(head);

        ListNode node = find(head, 4);
        deleteNode(node);
        display(head);

        // last node
        node = find(head, 7);
        deleteNode(node);
        display(head);

        // first node
        node = find(head, 1);
        deleteNode(node);
        display(head);
    }

    public static ListNode createList(int[] nums) {

        ListNode head = null;
        ListNode iter = head;
        for (int num : nums) {

            ListNode node = new ListNode(num);
            if (head == null) {
                head = node;
                iter = node;
            } else {
                iter.next = node;
                iter = node;
            }

        }

        return head;

    }

    public static void display(ListNode head) {

        ListNode iter = head;

        while (iter != null) {
            System.out.print(iter.val + " ");
            iter = iter.next;
        }
        System.out.println();

    }

    public static ListNode find(ListNode head, int num) {

        ListNode iter = head;

        while (iter != null) {
            if (iter.val == num)
                return iter;
            iter = iter.next;
        }
        return null;
    }

    public static void deleteNode(ListNode node) {

        if (node == null || node.next == null)
            return;

        node.val = node.next.val;
        node.next = node.next.next;

    }

    public static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {

            val = x;
        }
    }

}
