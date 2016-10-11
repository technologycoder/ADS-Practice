package practice.hr.sorting;

import java.util.Scanner;

public class InsertionSort1 {

	private static int size;
	private static int[] arr;

	public static void main(String[] args) {

		readInputUsingScanner();
		// assignSampleInput();
		insertionSort();

	}

	public static void insertionSort() {

		int i = arr.length - 1;
		int num = arr[i];

		while (i - 1 >= 0) {

			if (arr[i - 1] > num) {
				arr[i] = arr[i - 1];
				printArr();
			} else {
				break;
			}
			i--;
		}
		arr[i] = num;
		printArr();

	}

	public static void printArr() {

		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}

	public static void assignSampleInput() {

		size = 5;
		arr = new int[] { 2, 4, 6, 8, 1 };

	}

	public static void readInputUsingScanner() {

		Scanner in = new Scanner(System.in);
		size = in.nextInt();

		arr = new int[size];

		for (int i = 0; i < size; ++i) {
			arr[i] = in.nextInt();
		}

	}

}
