package praxis.sorting;

import java.util.Arrays;
import java.util.Random;

public class Practice {
    public static void main(String[] args) {

        int[] arr = new Random().ints(20, 0, 100)
                                .distinct()
                                .limit(10)
                                .toArray();

        System.out.println(Arrays.toString(arr));

        // quickSort(arr, 0, arr.length - 1);
        quickSort1(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {

        if (left > right)
            return;

        int pivotIndex = partition(arr, left, right);
        System.out.println(String.format("MAIN: %s %s %s", left, pivotIndex, right));
        if (left < pivotIndex - 1)
            quickSort(arr, left, pivotIndex - 1);

        if (right > pivotIndex)
            quickSort(arr, pivotIndex, right);

    }

    private static int partition(int[] arr, int left, int right) {

        int pivot = arr[(left + right) / 2];

        System.out.println(String.format("\t%s %s %s", left, pivot, right));
        System.out.println("\t" + Arrays.toString(arr));

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
        System.out.println("\t" + Arrays.toString(arr));
        return left;
    }

    public static void quickSort1(int[] numbers, int start, int end) {
        if (start >= end)
            return;
        int index = partition1(numbers, start, end);
        quickSort1(numbers, start, index);
        quickSort1(numbers, index + 1, end);
    }

    private static int partition1(int[] numbers, int start, int end) {
        Random random = new Random();
        int pivot = random.nextInt(end - start + 1) + start;
        swap(numbers, pivot, end);

        int small = start - 1;
        for (int i = start; i <= end; ++i) {
            if (numbers[i] < numbers[end]) {
                ++small;
                if (i != small)
                    swap(numbers, small, i);
            }
        }
        ++small;
        if (small != end)
            swap(numbers, small, end);
        return small;
    }

    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

}
