package praxis.leetcode.array;

/**
 * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this
 * single element that appears only once.
 */
public class SingleNonDuplicate540 {
    public static void main(String[] args) {

        // System.out.println(singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));
        // System.out.println(singleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 11, 11 }));
        // System.out.println(singleNonDuplicate(new int[] { 1, 1, 2 }));

        System.out.println(singleNonDuplicate3(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
    }

    public static int singleNonDuplicate3(int[] nums) {

        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >>> 1);
            System.out.println(String.format("%s - %s - %s", lo, mid, hi));
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
                    mid % 2 == 1 && nums[mid] == nums[mid - 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return nums[lo];
    }

    public static int singleNonDuplicate2(int[] nums) {

        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            System.out.println(String.format("%s - %s - %s", lo, mid, hi));
            // XOR even to odd, odd to even
            if (nums[mid] == nums[mid ^ 1])
                lo = mid + 1;
            else
                hi = mid;
        }
        return nums[lo];
    }

    public static int singleNonDuplicate1(int[] nums) {
        // binary search
        int n = nums.length, lo = 0, hi = n / 2;
        while (lo < hi) {
            int m = (lo + hi) / 2;

            System.out.println(String.format("%s - %s - %s", lo, m, hi));
            if (nums[2 * m] != nums[2 * m + 1])
                hi = m;
            else
                lo = m + 1;
        }
        return nums[2 * lo];
    }

    public static int singleNonDuplicate(int[] nums) {

        if (nums == null || nums.length == 0)
            return -1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = (end - start) / 2 + start;

            boolean isEven = false;
            if (mid % 2 == 0) {
                isEven = true;
            }

            if (mid == 0 && nums[mid + 1] != nums[mid])
                return nums[mid];

            if (mid == nums.length - 1 && nums[mid - 1] != nums[mid])
                return nums[mid];

            if ((nums[mid + 1] != nums[mid]) && nums[mid - 1] != nums[mid])
                return nums[mid];

            if (isEven) {
                if (nums[mid] == nums[mid + 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

}
