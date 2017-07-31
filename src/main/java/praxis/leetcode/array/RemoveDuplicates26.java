package praxis.leetcode.array;

import java.util.Arrays;

public class RemoveDuplicates26 {

    public static void main(String[] args) {

        int[] nums = { 1, 1, 2 };
        System.out.println(removeDuplicates(nums) + " - " + Arrays.toString(nums));

        nums = new int[] { 4, 5, 5, 6, 6, 6, 7, 8, 9, 10 };
        System.out.println(removeDuplicates(nums) + " - " + Arrays.toString(nums));

        nums = new int[] { 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(removeDuplicates(nums) + " - " + Arrays.toString(nums));

    }

    public static int removeDuplicates(int[] nums) {

        if (nums == null)
            throw new IllegalArgumentException("array is null");

        int current = 0;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[current]) {
                current++;
                if (current != i)
                    nums[current] = nums[i];

            }
        }

        return current + 1;

    }

    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
