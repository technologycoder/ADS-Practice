package praxis.leetcode.ll;

//https://leetcode.com/articles/reverse-linked-list/
public class ReverseLinkedList206 extends LinkedListUtil {
    public static void main(String[] args) {

        int[] nums = {7, 3, 8, 1, 4, 9, 2};

        ListNode head = createList(nums);

        display(head);

        head = reverseList(head);

        display(head);

    }

    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode first = head;
        ListNode second = head.next;
        first.next = null;

        head = reverseList(second);
        second.next = first;

        return head;

    }

    public static ListNode reverseList1(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static ListNode reverseListIterative(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode iter = head.next;
        head.next = null;

        while (iter != null) {
            ListNode temp = iter.next;
            iter.next = head;
            head = iter;

            iter = temp;

        }

        return head;

    }

}
