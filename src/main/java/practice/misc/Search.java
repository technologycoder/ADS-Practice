package practice.misc;

public class Search {

	public static void main(String[] args) {

		int[] arr = new int[] { 2, 6, 8, 12, 23, 56, 78 };

		binarySearch(arr, 0, arr.length, 80);
	}

	private static void binarySearch(int[] arr, int start, int end, int num) {

		if (start >= end) {
			System.out.println(String.format("Not found element %s element",
					num));
			return;
		} else {
			int middle = (start + end) / 2;

			// System.out.println("middle: " + middle);

			if (arr[middle] == num) {
				System.out.println(String.format("Found %s element at %s", num,
						middle));
			} else if (arr[middle] > num) {
				binarySearch(arr, start, middle - 1, num);
			} else {
				binarySearch(arr, middle + 1, end, num);
			}
		}

	}
}
