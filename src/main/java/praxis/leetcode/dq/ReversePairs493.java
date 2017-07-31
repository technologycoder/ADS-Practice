package praxis.leetcode.dq;

import java.util.Arrays;

public class ReversePairs493 {

    public static void main(String[] args) {
        // int[] nums = { 2, 4, 3, 5, 1 };

        int[] nums = { 20, 40, 3, 50, 5 };

        // System.out.println(reversePairsBruteForce(nums));

        System.out.println(reversePairsUsingBIT(nums));

        // test1();

        // System.out.println(reversePairsSubMergeSort(nums, 0, nums.length - 1));
        // System.out.println(Arrays.toString(nums));
    }

    public static int reversePairsSubMergeSort(int[] nums, int l, int r) {
        if (l >= r)
            return 0;

        int m = l + ((r - l) >> 1);
        int res = reversePairsSubMergeSort(nums, l, m) + reversePairsSubMergeSort(nums, m + 1, r);

        int i = l, j = m + 1, k = 0, p = m + 1;
        int[] merge = new int[r - l + 1];

        while (i <= m) {
            while (p <= r && nums[i] > 2L * nums[p])
                p++;
            res += p - (m + 1);

            while (j <= r && nums[i] >= nums[j])
                merge[k++] = nums[j++];
            merge[k++] = nums[i++];
        }

        while (j <= r)
            merge[k++] = nums[j++];

        System.arraycopy(merge, 0, nums, l, merge.length);

        return res;
    }

    public static void test1() {

        for (int i = 0; i < 100; ++i) {
            // System.out.println(i + " - " + Integer.toBinaryString(i) + " - " + Integer.toBinaryString(-i));
            System.out.println(i + " - " + (i & -i));
        }

        int[] bits = new int[11];

        for (int i = 1; i <= 10; ++i) {
            insert(bits, i);
            System.out.println(Arrays.toString(bits));
        }

        System.out.println(Arrays.toString(bits));

        System.out.println(search(bits, 5));

    }

    public static void test() {
        int i = 5;
        System.out.println(i + " - " + Integer.toBinaryString(i));
        while (i < 100) {
            i += i & -i;

            System.out.println(i + " - " + Integer.toBinaryString(i));
        }

        System.out.println("---------------");

        i = 15;
        System.out.println(i);
        while (i > 0) {
            i -= i & -i;

            System.out.println(i);
        }
    }

    public static int reversePairsBruteForce(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {

                if (nums[i] > nums[j] * 2L) {
                    res++;

                }
            }
        }
        return res;
    }

    // Binary Indexed Trees
    public static int reversePairsUsingBIT(int[] nums) {

        int res = 0;
        int[] copy = Arrays.copyOf(nums, nums.length);
        int[] bit = new int[copy.length + 1];

        Arrays.sort(copy);

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(copy));
        System.out.println(Arrays.toString(bit));

        for (int ele : nums) {

            int index = index(copy, 2L * ele + 1);
            System.out.println(index);

            res += search(bit, index);
            System.out.println(res);

            index = index(copy, ele);
            System.out.println(index);

            insert(bit, index);

            System.out.println(Arrays.toString(bit));
            System.out.println("------------------------------------");
        }

        return res;
    }

    private static int search(int[] bit, int i) {
        int sum = 0;

        while (i < bit.length) {
            sum += bit[i];

            i += i & -i;
        }

        return sum;
    }

    private static void insert(int[] bit, int i) {
        while (i > 0) {
            bit[i] += 1;
            i -= i & -i;
        }
    }

    private static int index(int[] arr, long val) {
        int l = 0, r = arr.length - 1, m = 0;

        while (l <= r) {
            m = l + ((r - l) >> 1);

            if (arr[m] >= val) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l + 1;
    }

}
