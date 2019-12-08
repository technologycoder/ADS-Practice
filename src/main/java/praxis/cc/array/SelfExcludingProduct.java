package praxis.cc.array;

import java.util.Arrays;

/**
 * Implement a method which takes an integer array and returns an integer array (of equal size) in which each element is the product of
 * every number in the input array with the exception of the number at that index.
 * <p>
 * Example: [3, 1, 4, 2] => [8, 24, 6, 12]
 */
public class SelfExcludingProduct {
    public static void main(String[] args) {

        int[] arr = {3, 1, 4, 2};

        System.out.println(Arrays.toString(sep(arr)));

        System.out.println(Arrays.toString(selfExcludingProduct(arr)));

        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    public static int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] rst = new int[len];
        if (len == 0) {
            return rst;
        }
        rst[0] = 1;
        for (int i = 1; i < len; i++) {
            rst[i] = rst[i - 1] * nums[i - 1];
        }
        int p = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rst[i] *= p;
            p *= nums[i];
        }
        return rst;
    }

    public static int[] sep(int[] arr) {

        int[] sol = new int[arr.length];

        for (int i = 0; i < arr.length; ++i) {

            int product = 1;
            for (int j = 0; j < arr.length; ++j) {

                if (i != j)
                    product *= arr[j];
            }

            sol[i] = product;
        }

        return sol;

    }

    public static int[] selfExcludingProduct(int[] input) {

        if (input == null)
            throw new NullPointerException("Null input array!");
        int[] productArray = new int[input.length];
        if (input.length == 0)
            return productArray;
        int product = 1;
        int numOfZeros = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 0)
                product *= input[i];
            else
                numOfZeros++;
            if (numOfZeros >= 2) {
                return productArray;
            }
        }
        for (int i = 0; i < input.length; i++) {
            if (numOfZeros == 0) {
                productArray[i] = product / input[i];
            } else {
                if (input[i] == 0)
                    productArray[i] = product;
                else
                    productArray[i] = 0;
            }

        }

        return productArray;

    }

}
