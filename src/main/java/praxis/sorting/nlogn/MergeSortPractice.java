package praxis.sorting.nlogn;

import java.util.Arrays;
import java.util.Random;

public class MergeSortPractice {

    public static void main(String[] args) {

        int[] arr = new Random().ints(20, 0, 100)
                                .distinct()
                                .limit(10)
                                .toArray();

        System.out.println(Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] helper) {

        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, helper);
            mergeSort(arr, mid + 1, right, helper);
            merge(arr, left, mid, right, helper);

        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] helper) {

        System.arraycopy(arr, 0, helper, 0, arr.length);

        int current = left;

        int leftHelper = left;
        int rightHelper = mid + 1;

        while (leftHelper <= mid && rightHelper <= right) {

            if (helper[leftHelper] <= helper[rightHelper]) {
                arr[current] = helper[leftHelper];
                leftHelper++;
            } else {
                arr[current] = helper[rightHelper];
                rightHelper++;
            }

            current++;

        }

        if (leftHelper <= mid) {
            int remaining = mid - leftHelper;

            for (int i = 0; i <= remaining; ++i) {
                arr[current + i] = helper[leftHelper + i];
            }
        }

    }

}
