package practice.ds.pq;

import java.util.Arrays;

public class MinHeap {

	private int[] arr;
	private int size = 0;

	public MinHeap(int length) {
		arr = new int[length];
		Arrays.fill(arr, -1);
	}

	public void insert(int[] data) throws Exception {

		for (int d : data) {

			this.insert(d);
		}
	}

	public int[] toArray() {

		return Arrays.copyOf(this.arr, size);
	}

	public void insert(int data) throws Exception {

		// Double the size and copy all the elements
		if (arr.length < (size + 1)) {
			throw new Exception("increase array size");
		}

		arr[size] = data;
		percolateUp(size);
		size++;

	}

	private void percolateUp(int index) {

		// <= 0?
		if (index < 0) {
			return;
		}

		int parent = (index - 1) / 2;
		if (arr[parent] > arr[index]) {
			int temp = arr[parent];
			arr[parent] = arr[index];
			arr[index] = temp;
			percolateUp(parent);
		}

	}

	public int min() throws Exception {

		if (size == 0) {
			throw new Exception("heap empty");
		}

		int min = arr[0];

		arr[0] = arr[size - 1];
		arr[size - 1] = -1;
		size--;

		int left = arr[1];
		int right = arr[2];
		if (arr[0] > left || arr[0] > right) {
			percolateDown(0);
		}

		return min;
	}

	private void percolateDown(int index) {

		int left = arr[index * 2 + 1];
		int right = arr[index * 2 + 2];

		int min = left < right ? left : right;

	}

}
