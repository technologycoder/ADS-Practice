package practice.misc;

import java.util.Arrays;

public class Sorting {

	public static void main(String[] args) {

		int[] arr = new int[] { 9, 7, 5, 11, 12, 2, 14, 3, 10, 6 };

		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

	private static void quickSort(int[] arr, int start, int end) {

		if (start < end) {
			int pivot = partition(arr, start, end);
			quickSort(arr, start, pivot - 1);
			quickSort(arr, pivot + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {

		int pivot = start;
		int pivotElement = arr[start];

		int left = start;
		int right = end;

		while (left < right) {

			while (left <= end && arr[left] <= pivotElement) {
				left++;
			}

			while (right >= start && arr[right] > pivotElement) {
				right--;
			}

			if (left < right) {
				swap(arr, left, right);
			}

		}

		swap(arr, pivot, right);

		System.out.println(Arrays.toString(arr));

		return right;

	}

	private static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
}
