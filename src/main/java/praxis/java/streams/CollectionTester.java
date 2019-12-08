package praxis.java.streams;

import java.util.Arrays;
import java.util.Random;

public class CollectionTester {
    public static void main(String[] args) {

        int[] array = new Random().ints(10, 0, 100)
                .distinct()
                .toArray();

        System.out.println(Arrays.toString(array));

    }

}
