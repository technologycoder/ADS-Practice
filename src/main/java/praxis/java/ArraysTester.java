package praxis.java;

import java.util.Arrays;
import java.util.Random;

public class ArraysTester {
    public static void main(String[] args) {

        copyArray();
    }

    public static void copyArray() {

        int[] arr1 = new Random().ints(5, 0, 20)
                .toArray();

        int[] arr2 = Arrays.copyOf(arr1, arr1.length);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);

        System.out.println(Arrays.toString(arr3));

    }

}
