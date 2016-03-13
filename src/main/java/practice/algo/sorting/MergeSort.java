package practice.algo.sorting;

public class MergeSort {

	public static void mergeSort(int[] arr) {

		int[] helper = new int[arr.length];

		mergeSort(arr, helper, 0, arr.length - 1);

	}

	private static void mergeSort(int[] arr, int[] helper, int start, int end) {

		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, helper, start, mid);
			mergeSort(arr, helper, mid + 1, end);
			merge(arr, helper, start, mid, end);
		}
	}

	private static void merge(int[] arr, int[] helper, int start, int mid, int end) {

		for (int i = start; i <= end; ++i) {
			helper[i] = arr[i];
		}

		int curr = start;
		int helperLeft = start;
		int helperRight = mid + 1;

		while (helperLeft <= mid && helperRight <= end) {
			if (helper[helperLeft] <= helper[helperRight]) {
				arr[curr] = helper[helperLeft];
				helperLeft++;
			} else {
				arr[curr] = helper[helperRight];
				helperRight++;
			}
			curr++;
		}

		int remaining = mid - helperLeft;
		for (int i = 0; i <= remaining; ++i) {
			arr[curr + i] = helper[helperLeft + i];
		}

	}

}
