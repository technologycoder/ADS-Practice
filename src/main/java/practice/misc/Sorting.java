package practice.misc;

import java.util.Arrays;

public class Sorting {
    public static void main(final String[] args) {

        int[] arr = new int[]{9, 7, 5, 11, 12, 2, 14, 3, 10, 6};

        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(final int[] arr, final int start, final int end) {

        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private static int partition(final int[] arr, final int start, final int end) {

        int pivot = start;
        int pivotElement = arr[start];

        System.out.println(String.format("pivot: %s, element: %s", pivot, pivotElement));

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
                System.out.println(Arrays.toString(arr));
            }

        }

        swap(arr, pivot, right);
        System.out.println(String.format("pivot: %s, element: %s", right, arr[right]));
        System.out.println(Arrays.toString(arr));

        return right;

    }

    private static void swap(final int[] arr, final int i, final int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
