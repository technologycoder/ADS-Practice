package praxis.sorting.nlogn;

import java.util.Arrays;

public class MergeSort {
    public static void main(final String[] args) {

        int[] num = new int[]{38, 27, 43, 3, 9, 82, 10};

        System.out.println(Arrays.toString(num));
        mergeSort(num, 0, num.length - 1);

        System.out.println(Arrays.toString(num));
    }

    public static void mergeSort(final int[] num, final int start, final int end) {

        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(num, start, mid);
            mergeSort(num, mid + 1, end);
            merge(num, start, mid, end);
        }
    }

    public static void merge(final int[] num, final int start, final int mid, final int end) {

        int[] helper = new int[num.length];

        for (int i = 0; i < num.length; ++i) {
            helper[i] = num[i];
        }

        int index = start;
        int firstIndex = start;
        int secondIndex = mid + 1;

        while (firstIndex <= mid && secondIndex <= end) {

            if (helper[firstIndex] <= helper[secondIndex]) {
                num[index++] = helper[firstIndex++];
            } else {
                num[index++] = helper[secondIndex++];
            }
        }

        int remaining = mid - firstIndex;
        for (int i = 0; i <= remaining; ++i) {
            num[index + i] = helper[firstIndex + i];
        }

    }

}
