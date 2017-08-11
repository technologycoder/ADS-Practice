package praxis.leetcode.topics.circulararray;

public class Tester {

    public static void main(String[] args) {

        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        // System.out.println(a);
        // System.out.println(a + b);
        // System.out.println((-1) >>> 1);
        testCircularArray();

    }

    public static void testCircularArray() {
        int size = 10;
        CircularArray<String> array = new CircularArray<>(size);
        for (int i = 0; i < size; i++) {
            array.set(i, String.valueOf(i));
        }

        array.rotate(3);

        for (int i = 0; i < size; i++) {
            System.out.println(array.get(i));
        }

        System.out.println("");

        array.rotate(2);
        for (String s : array) {
            System.out.println(s);
        }

        System.out.println(array.get(-10));
    }

}
