package praxis.sorting.nlogn;

import java.util.Arrays;

public class QuickSort {

    public static void main(final String[] args) {
        int[] num = new int[] { 38, 27, 43, 3, 9, 82, 10 };

        System.out.println(Arrays.toString(num));
        // quickSort(num, 0, num.length - 1);
        quickSort(0, num.length - 1, num);

        System.out.println(Arrays.toString(num));
    }

    public static void quickSort(final int[] arr, final int start, final int end) {

        // pivot Index is one greater than left index.
        // left index could be 0, so leat value of pivot index will always be 1
        int pivotIndex = partition(arr, start, end);
        if (start < pivotIndex - 1)
            quickSort(arr, start, pivotIndex - 1);

        if (end > pivotIndex)
            quickSort(arr, pivotIndex, end);

    }

    public static int partition(int[] arr, int left, int right) {

        int pivot = arr[(left + right) / 2];

        while (left <= right) {

            System.out.println(String.format("%s - %s - (%s, %s)", Arrays.toString(arr),
                    pivot, left, right));

            while (arr[left] < pivot && left < right)
                left++;

            while (arr[right] > pivot && left < right)
                right--;

            System.out.println(String.format("%s - %s - (%s, %s)", Arrays.toString(arr),
                    pivot, left, right));
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

            System.out.println(String.format("%s - %s - (%s, %s)", Arrays.toString(arr),
                    pivot, left, right));

        }

        return left;

    }

    private static void quickSort(int low, int high, int[] numbers) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j, numbers);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quickSort(low, j, numbers);
        if (i < high)
            quickSort(i, high, numbers);
    }

    private static void exchange(int i, int j, int[] numbers) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

}
