package practice.misc;

public class Search {
    public static void main(String[] args) {

        // int[] arr = new int[] { 2, 6, 8, 12, 23, 56, 78 };

        int[] arr = new int[]{2};

        binarySearchRecursive(arr, 0, arr.length, 2);
    }

    private static void binarySearchRecursive(int[] arr, int start, int end,
                                              int num) {

        if (start >= end) {
            System.out.println(String.format("Not found element: %s ", num));
            return;
        } else {
            int middle = (start + end) / 2;

            // System.out.println("middle: " + middle);

            if (arr[middle] == num) {
                System.out.println(String.format("Found %s element at %s", num,
                        middle));
            } else if (arr[middle] > num) {
                binarySearchRecursive(arr, start, middle - 1, num);
            } else {
                binarySearchRecursive(arr, middle + 1, end, num);
            }
        }

    }
}
