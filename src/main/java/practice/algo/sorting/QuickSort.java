package practice.algo.sorting;

public class QuickSort {

	public static void quickSort(int[] arr) {

		quickSort(arr, 0, arr.length - 1);

	}

	private static void quickSort(int[] arr, int start, int end) {

		int index = partition(arr, start, end);

		if (start < index - 1)
			quickSort(arr, start, index - 1);

		if (index < end)
			quickSort(arr, index, end);
	}

	private static int partition(int[] arr, int left, int right) {

		int pivot = arr[(left + right) / 2];

		while (left <= right) {

			while (arr[left] < pivot)
				left++;

			while (arr[right] > pivot)
				right--;

			if (left <= right) {

				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}

		}

		return left;
	}

}
