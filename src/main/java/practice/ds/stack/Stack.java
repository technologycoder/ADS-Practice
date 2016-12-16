package practice.ds.stack;

import java.util.Arrays;

public class Stack<E> {

	public static void main(String[] args) {

		Stack<String> stack = new Stack<String>(11);
		stack.push("hello");
		stack.push("world");

		System.out.println(stack);

		stack.pop();
		System.out.println(stack);

		stack.pop();
		System.out.println(stack);
		System.out.println("Done");
	}

	private E[] arr;
	private int capacity;
	private int size = 0;
	private int top = -1;

	// http://stackoverflow.com/questions/529085/how-to-create-a-generic-array-in-java
	@SuppressWarnings("unchecked")
	public Stack(int capacity) {
		this.arr = (E[]) new Object[capacity];
		this.capacity = capacity;

	}

	public String toString() {
		return Arrays.toString(this.arr);
	}

	public boolean push(E elem) {

		if (!isFull()) {
			arr[++top] = elem;
			size++;
			return true;
		} else {
			return false;
		}

	}

	public E peek() {

		if (!isEmpty()) {
			return arr[top];
		} else {
			return null;
		}
	}

	public E pop() {

		if (!isEmpty()) {
			size--;
			E result = arr[top];
			arr[top--] = null;

			return result;
		} else {

			return null;
		}
	}

	public boolean isFull() {

		return size == capacity;
	}

	public boolean isEmpty() {

		return size == 0;
	}

}
