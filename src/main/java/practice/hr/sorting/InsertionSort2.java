package practice.hr.sorting;

import java.util.Scanner;

public class InsertionSort2 {
    private static int size;

    private static int[] arr;

    public static void main(String[] args) {

        readInputUsingScanner();
        // assignSampleInput();
        insertionSort();

    }

    public static void insertionSort() {

        for (int i = 1; i < arr.length; ++i) {
            int k = i;
            int num = arr[k];
            for (int j = k - 1; j >= 0; j--) {
                if (num < arr[j]) {
                    arr[k] = arr[j];
                    k--;
                } else {
                    break;
                }
            }
            arr[k] = num;

            printArr();

        }
    }

    public static void printArr() {

        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void assignSampleInput() {

        size = 6;
        arr = new int[]{10, 4, 3, 5, 6, 2};

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
