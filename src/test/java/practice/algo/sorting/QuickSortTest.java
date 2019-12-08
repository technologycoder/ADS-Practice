package practice.algo.sorting;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {
    @Test
    public void quickSort() {

        int[] data = new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13};

        int[] sortedData = new int[]{1, 3, 4, 6, 7, 8, 10, 13, 14};

        QuickSort.quickSort(data);

        Assert.assertArrayEquals(sortedData, data);

    }

}
