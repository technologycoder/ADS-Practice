package praxis.leetcode.ll;

public class LinkedListUtil {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void display(ListNode head) {

        ListNode iter = head;

        while (iter != null) {
            System.out.print(iter.val + " ");
            iter = iter.next;
        }
        System.out.println();

    }

    public static void displayReverse(ListNode node) {

        if (node == null)
            return;
        displayReverse(node.next);
        System.out.print(node.val + " ");

    }

    public static ListNode createList(int[] nums) {

        ListNode root = createList(nums, 0);

        return root;

    }

    private static ListNode createList(int[] nums, int index) {

        if (nums == null || nums.length == 0 || index == nums.length || index < 0) {
            return null;
        }

        ListNode node = new ListNode(nums[index]);

        node.next = createList(nums, index + 1);

        return node;
    }

    public static ListNode createList1(int[] nums) {

        ListNode head = null;
        ListNode iter = head;

        for (int num : nums) {
            ListNode node = new ListNode(num);
            if (head == null) {
                head = node;
                iter = head;
            } else {
                iter.next = node;
                iter = iter.next;
            }
        }

        display(head);
        return head;

    }

}
