package practice.hr.dp;

import java.util.Arrays;

public class Equal {
    public static void main(String[] args) {

        System.out.println("done");

        int[] arr = new int[]{2, 2, 3, 7};
        int[] chocolateCount = new int[]{1, 3, 5};
        int minCount = equalize(arr, chocolateCount, 0);

        System.out.println(minCount);
    }

    public static int equalize(int[] arr, int[] chocolateCount, int count) {

        System.out.println(count);
        if (checkIfEqual(arr))
            return count;

        int minCount = count;
        for (int i = 0; i < arr.length; ++i) {

            int[] temp = Arrays.copyOf(arr, arr.length);

            for (int j = 0; j < chocolateCount.length; ++j) {

                for (int k = 0; k < arr.length; ++k) {

                    if (k == i)
                        continue;

                    temp[k] += chocolateCount[j];
                }
                int countValue = equalize(temp, chocolateCount, count + 1);
                if (countValue < minCount) {
                    minCount = countValue;
                    System.out.println(Arrays.toString(temp));
                }
            }
        }
        return minCount;

    }

    private static boolean checkIfEqual(int[] arr) {

        if (arr == null || arr.length == 0)
            return false;

        int elem = arr[0];

        for (int i = 1; i < arr.length; ++i) {

            if (arr[i] != elem)
                return false;
        }

        return true;

    }

}
