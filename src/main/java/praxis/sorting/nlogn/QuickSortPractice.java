package praxis.sorting.nlogn;

import java.util.Arrays;
import java.util.Random;

public class QuickSortPractice {
    public static void main(String[] args) {

        int[] arr = new Random().ints(20, 0, 100)
                .distinct()
                .limit(10)
                .toArray();

        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        // quickSort1(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort1(int[] arr, int left, int right) {

        int i = left;
        int j = right;

        int pivot = arr[(left + right) / 2];

        while (i <= j) {

            while (arr[i] < pivot)
                i++;

            while (arr[j] > pivot)
                j--;

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (left < j)
            quickSort1(arr, left, j);

        if (right > i)
            quickSort1(arr, i, right);
    }

    public static void quickSort(int[] arr, int left, int right) {

        int pivotIndex = partition(arr, left, right);

        if (left < pivotIndex - 1) {
            quickSort(arr, left, pivotIndex - 1);
        }

        if (right > pivotIndex) {
            quickSort(arr, pivotIndex, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {

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
