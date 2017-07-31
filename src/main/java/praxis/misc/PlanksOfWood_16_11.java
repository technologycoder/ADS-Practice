package praxis.misc;

import java.util.Arrays;

public class PlanksOfWood_16_11 {

    public static void main(String[] args) {

        int[] result = new int[5];
        // planks(5, 4, 1, result, 0);

        planksSum(5, 4, 1, 0, 0);
    }

    public static void planks(int count, int big, int small, int[] result, int index) {

        if (index >= count) {
            System.out.println(Arrays.toString(result));
        } else {
            result[index] = big;
            planks(count, big, small, result, index + 1);

            result[index] = small;
            planks(count, big, small, result, index + 1);

        }

    }

    public static void planksSum(int count, int big, int small, int index, int result) {

        if (index == count) {
            System.out.println(result);
        } else {
            planksSum(count, big, small, index + 1, result + big);

            planksSum(count, big, small, index + 1, result + small);

        }

    }

}
