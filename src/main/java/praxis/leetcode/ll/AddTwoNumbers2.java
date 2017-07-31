package praxis.leetcode.ll;

/**
 * what if number is negative
 * 
 * @author u0076933
 *
 */
public class AddTwoNumbers2 {

	public static void main(String[] args) {

		addNumbersStoredAsReversedList();

	}

	public static void addNumbersStoredAsReversedList() {
		ListNode num1 = createListNumbersReversed(342);
		display(num1);

		ListNode num2 = createListNumbersReversed(564);
		display(num2);

		ListNode result = addListNumbersReversedRecursive(num1, num2);
		display(result);
	}

	public static ListNode addListNumbersReversedRecursive(ListNode l1, ListNode l2) {
		return addListNumbersReversedRecursive(l1, l2, 0);
	}

	public static ListNode addListNumbersReversedRecursive(ListNode l1, ListNode l2, int carry) {

		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}

		int result = carry;
		if (l1 != null) {
			result += l1.val;
		}

		if (l2 != null) {
			result += l2.val;
		}

		int value = result % 10;
		ListNode resultNode = new ListNode(value);

		ListNode nextNode = addListNumbersReversedRecursive(l1 == null ? null : l1.next, l2 == null ? null : l2.next,
				result > 9 ? 1 : 0);
		resultNode.next = nextNode;
		return resultNode;

	}

	public static ListNode addListNumbersReversed(ListNode num1, ListNode num2) {

		ListNode resultHead = null;
		ListNode iter = null;
		int carry = 0;
		while (num1 != null && num2 != null) {

			int sum = num1.val + num2.val + carry;

			if (sum > 9) {
				sum = sum % 10;
				carry = 1;
			} else {
				carry = 0;
			}
			ListNode num = new ListNode(sum);
			if (resultHead == null) {
				resultHead = num;
				iter = num;
			} else {
				iter.next = num;
				iter = num;
			}

			num1 = num1.next;
			num2 = num2.next;
		}

		while (num1 != null) {
			int sum = num1.val + carry;

			if (sum > 9) {
				sum = sum % 10;
				carry = 1;
			} else {
				carry = 0;
			}
			ListNode num = new ListNode(sum);
			if (resultHead == null) {
				resultHead = num;
				iter = num;
			} else {
				iter.next = num;
				iter = num;
			}

			num1 = num1.next;
		}

		while (num2 != null) {
			int sum = num2.val + carry;

			if (sum > 9) {
				sum = sum % 10;
				carry = 1;
			} else {
				carry = 0;
			}
			ListNode num = new ListNode(sum);
			if (resultHead == null) {
				resultHead = num;
				iter = num;
			} else {
				iter.next = num;
				iter = num;
			}

			num2 = num2.next;
		}

		return resultHead;

	}

	public static void display(ListNode node) {

		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}

	private static ListNode createListNumbers(int num) {

		ListNode head = null;
		while (num > 0) {
			int i = num % 10;
			ListNode node = new ListNode(i);
			if (head == null) {
				head = node;
			} else {
				ListNode temp = head;
				head = node;
				node.next = temp;
			}
			num /= 10;
		}

		return head;

	}

	private static ListNode createListNumbersReversed(int num) {

		ListNode head = null;

		while (num > 0) {

			int i = num % 10;
			ListNode node = new ListNode(i);
			if (head == null) {
				head = node;
			} else {
				ListNode iter = head;
				while (iter.next != null)
					iter = iter.next;

				iter.next = node;
			}

			num /= 10;

		}

		return head;

	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
