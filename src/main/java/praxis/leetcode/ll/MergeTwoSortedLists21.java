package praxis.leetcode.ll;

public class MergeTwoSortedLists21 extends LinkedListUtil {

    public static void main(String[] args) {

        int[] nums1 = { 2, 8, 10, 15, 34 };

        int[] nums2 = { 1, 4, 6, 12, 20, 89 };

        ListNode l1 = createList(nums1);
        ListNode l2 = createList(nums2);

        ListNode result = mergeTwoLists(l1, l2);
        display(result);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode mergeHead;
        if (l1.val < l2.val) {
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        } else {
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }

    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

        ListNode root = null;
        ListNode iter = root;

        while (l1 != null && l2 != null) {
            ListNode node = null;
            if (l1.val < l2.val) {
                node = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node = new ListNode(l2.val);
                l2 = l2.next;
            }

            if (root == null) {
                root = node;
                iter = root;
            } else {
                iter.next = node;
                iter = iter.next;
            }

        }

        while (l1 != null) {
            ListNode node = new ListNode(l1.val);
            if (root == null) {
                root = node;
                iter = root;
            } else {
                iter.next = node;
                iter = iter.next;
            }

            l1 = l1.next;

        }

        while (l2 != null) {
            ListNode node = new ListNode(l2.val);
            if (root == null) {
                root = node;
                iter = root;
            } else {
                iter.next = node;
                iter = iter.next;
            }

            l2 = l2.next;

        }

        return root;

    }

}
