package practice.ds.generic.list;

public class LinkedList<T> {

	private Node head;

	public LinkedList() {

		head = new Node(null);
	}

	public void addNode(T item) {

		Node iter = head;

		while (iter.getNext() != null) {
			iter = iter.getNext();
		}

		Node newNode = new Node(item);
		iter.setNext(newNode);
	}

	public void displayList() {

		Node iter = head.getNext();
		while (iter != null && iter.getNext() != null) {
			System.out.println(iter.getItem());
			iter = iter.getNext();
		}

	}

	public class Node {

		private T item;
		private Node next;

		public Node(T item) {
			this.item = item;
		}

		public T getItem() {
			return item;
		}

		public void setItem(T item) {
			this.item = item;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

}
