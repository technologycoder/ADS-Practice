package praxis.searching;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BinarySearch {
    public static void main(String[] args) {

        List<Integer> nums = new Random().ints(20, 0, 100)
                .distinct()
                .limit(10)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(nums);
        nums.sort(null);
        System.out.println(nums);

        int[] arr = nums.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println("index: " + binarySearchRecursive(arr, arr[7], 0, arr.length - 1));
        System.out.println("index: " + binarySearchRecursive(arr, arr[4] - 1, 0, arr.length - 1));

        System.out.println("index: " + binarySearch(arr, arr[7]));
        System.out.println("index: " + binarySearch(arr, arr[4] - 1));

    }

    public static int binarySearchRecursive(int[] arr, int num, int left, int right) {

        if (left > right) {
            return -1;
        }

        int center = (left + right) / 2;

        if (num == arr[center]) {
            return center;
        } else if (num < arr[center]) {
            return binarySearchRecursive(arr, num, left, center - 1);
        } else {
            return binarySearchRecursive(arr, num, center + 1, right);
        }

    }

    public static int binarySearch(int[] arr, int num) {

        int left = 0;
        int right = arr.length;

        while (left <= right) {

            int center = (left + right) / 2;

            if (num == arr[center])
                return center;
            else if (num < arr[center])
                right = center - 1;
            else
                left = center + 1;
        }

        return -1;

    }

    // TODO
    public static <T extends Comparable<T>> int binarySearchRecursiveGenerics(T[] arr, T num, int left, int right) {

        return -1;
    }

}
