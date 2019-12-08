package practice.algo;

public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = new int[]{2, 5, 8, 10, 23, 45, 76, 78, 100};
        int index = binarySearch(arr, 2);

        System.out.println(index);

    }

    public static int binarySearch(int[] arr, int num) {
        // return binarySearchIterative(arr, num, 0, arr.length);
        return binarySearchRecursive(arr, num, 0, arr.length);
    }

    private static int binarySearchIterative(int[] arr, int num) {

        int start = 0;
        int end = arr.length;
        int mid = 0;

        while (start < end) {
            mid = (start + end) / 2;

            if (num < arr[mid]) {
                end = mid - 1;
            } else if (num > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;

    }

    private static int binarySearchRecursive(int[] arr, int num, int start, int end) {

        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        if (num < arr[mid])
            return binarySearchRecursive(arr, num, start, mid - 1);
        else if (num > arr[mid])
            return binarySearchRecursive(arr, num, mid + 1, end);
        else
            return mid;

    }

}
