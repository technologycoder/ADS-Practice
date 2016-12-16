package practice.hr.ds.ll;

public class LinkedList {

	public static void main(String[] args) {

		int[] arr = new int[] { 2, 6, 8, 10 };
		Node root = createList(arr);
		display(root);
		Node reversedList = reverseList(root);
		display(reversedList);
	}

	public static Node reverseList(Node root) {

		Node iter = root;

		Node prev = null;
		Node next = null;

		while (iter != null) {

			next = iter.next;

			iter.next = prev;
			prev = iter;

			iter = next;

		}
		return prev;

	}

	public static Node createList(int[] arr) {

		Node root = null;
		Node iter = root;

		for (Integer i : arr) {

			Node node = new Node();
			node.data = i;

			if (root == null) {
				root = node;
				iter = root;
			} else {

				iter.next = node;
				iter = node;
			}
		}

		return root;

	}

	public static void display(Node node) {

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println(" ");
	}

	public static class Node {

		public int data;
		public Node next;

	}

}
