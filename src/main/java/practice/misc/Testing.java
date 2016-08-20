package practice.misc;

public class Testing {

    public static void main(final String[] args) {

        String str = "zsfsdfsdfs";

        System.out.println(str.substring(0, 10000));

        // fizzBuzz();

        // reverseStringUsingStringArray("testing");
        // reverseStringUsingCharacterArray("Madam, I'm Adam");

        // factorial(4);
        // System.out.println(recursiveFactorial(4));

        // fibonnaci(9);
        // System.out.println(recursiveFibonnaci(9));

        // http://stackoverflow.com/questions/4240080/generating-all-permutations-of-a-given-string
        /*
         * Use recursion.
         * 
         * Try each of the letters in turn as the first letter and then find all the permutations of the remaining letters using a recursive
         * call. The base case is when the input is an empty string the only permutation is the empty string.
         */
        // http://introcs.cs.princeton.edu/java/23recursion/Permutations.java.html
        // recursion:
        // http://introcs.cs.princeton.edu/java/23recursion/

        // permutation("ABCD", "");

        // combinations("", "ABCD");
    }

    private static void permutation(final String str, final String prefix) {
        System.out.println("str: " + str + " - prefix: " + prefix);

        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); ++i) {
                System.out.println("-->str: " + str + " - prefix: " + prefix);
                permutation(
                        str.substring(0, i)
                                + str.substring(i + 1, str.length()), prefix
                                + str.charAt(i));
            }
        }

    }

    private static void combinations(final String prefix, final String str) {

        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            combinations(prefix + str.charAt(0), str.substring(1));
            combinations(prefix, str.substring(1));
        }

    }

    private static void permutation1(final char[] arr, final int index) {

        if (index == 1) {
            System.out.println(String.valueOf(arr));
        } else {
            for (int i = 0; i < arr.length; ++i) {

                swap(arr, i, index - 1);
                permutation1(arr, index - 1);
                swap(arr, i, index - 1);

            }
        }

    }

    private static void swap(final char[] arr, final int i, final int j) {

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    private static void reverseStringUsingStringArray(final String str) {

        System.out.println(str);
        String[] arr = str.split("");
        // System.out.println(Arrays.toString(arr));

        for (int i = 0, j = (arr.length - 1); i < j; ++i, --j) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        System.out.println(String.join("", arr));

    }

    private static void reverseStringUsingCharacterArray(final String str) {

        System.out.println(str);

        char[] arr = str.toCharArray();
        // System.out.println(Arrays.toString(arr));

        for (int i = 0, j = (arr.length - 1); i < j; ++i, --j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        System.out.println(String.valueOf(arr));

    }

    private static void fizzBuzz() {

        for (int i = 1; i <= 100; ++i) {

            if ((i % 3 == 0) && (i % 5 == 0)) {

                System.out.println(i + ": FizzBuzz");

            } else if (i % 3 == 0) {
                System.out.println("Fizz");

            } else if (i % 5 == 0) {

                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

    }

    private static void factorial(final int num) {

        int fact = 1;
        for (int i = 1; i <= num; ++i) {
            fact = fact * i;

        }
        System.out.println(fact);

    }

    private static int recursiveFactorial(final int num) {

        if (num <= 1) {
            return 1;
        } else {

            return num * recursiveFactorial(num - 1);
        }
    }

    private static void fibonnaci(final int num) {

        int fib = 0;

        if (num == 0) {
            fib = 0;
        } else if (num == 1) {
            fib = 1;
        } else {

            int fib1 = 0;
            int fib2 = 1;

            for (int i = 2; i <= num; ++i) {

                fib = fib1 + fib2;
                fib1 = fib2;
                fib2 = fib;

            }

        }

        System.out.println(fib);
    }

    private static int recursiveFibonnaci(final int num) {

        if (num <= 0) {
            return 0;
        } else if (num <= 2) {
            return 1;
        } else {
            return recursiveFibonnaci(num - 1) + recursiveFibonnaci(num - 2);
        }

    }
}
