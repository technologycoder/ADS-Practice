package praxis.misc;

public class SmallestDifference_16_6 {

    public static void main(String[] args) {
        smallestDifference();
    }

    public static void smallestDifference() {

        int[] arr1 = { 1, 3, 15, 11, 2 };
        int[] arr2 = { 23, 127, 235, 19, 8 };

        int elem1 = 0;
        int elem2 = 0;

        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr1.length; ++i) {
            for (int j = 0; j < arr2.length; ++j) {

                int difference = Math.abs(arr1[i] - arr2[j]);

                if (difference < minDifference) {
                    minDifference = difference;
                    elem1 = arr1[i];
                    elem2 = arr2[j];
                }
            }
        }

        System.out.println(String.format("%s %s %s", minDifference, elem1, elem2));

    }

}
