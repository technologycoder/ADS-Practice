package practice.ctci.sort;

public class BubbleSort {

	public static void main(String[] args) {

		// int[] arr = { 6, 5, 3, 1, 8, 7, 2, 4 };
		int[] arr = { 3, 2, 1 };

		bubbleSort(arr);

	}

	public static void bubbleSort(int[] arr) {

		int totalSwapCount = 0;

		for (int i = 0; i < arr.length; ++i) {

			int end = arr.length - 1 - i;
			int swapCount = 0;
			for (int j = 0; j < end; ++j) {

				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapCount++;
				}
			}

			if (swapCount == 0) {
				break;
			}

			totalSwapCount += swapCount;

			// System.out.println(Arrays.toString(arr));
		}

		System.out.println(String.format("Array is sorted in %d swaps.", totalSwapCount));
		System.out.println(String.format("First Element: %d", arr[0]));
		System.out.println(String.format("Last Element: %d", arr[arr.length - 1]));

	}

}
