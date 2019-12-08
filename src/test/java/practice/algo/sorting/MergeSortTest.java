package practice.algo.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {
    @Test
    public void mergeSort() {

        int[] data = new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13};

        int[] sortedData = new int[]{1, 3, 4, 6, 7, 8, 10, 13, 14};

        MergeSort.mergeSort(data);

        System.out.println(Arrays.toString(data));
        System.out.println(Arrays.toString(sortedData));

        Assert.assertArrayEquals(sortedData, data);

    }

}
