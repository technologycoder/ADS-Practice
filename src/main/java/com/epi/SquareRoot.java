package com.epi;

import java.util.Random;

public class SquareRoot {
    // @include
    public static double squareRoot(double x) {
        // Decides the search range according to x's value relative to 1.0.
        double left, right;
        if (x < 1.0) {
            left = x;
            right = 1.0;
        } else { // x >= 1.0.
            left = 1.0;
            right = x;
        }

        // Keeps searching if left < right.
        while (compare(left, right) == Ordering.SMALLER) {
            double mid = left + 0.5 * (right - left);
            double midSquared = mid * mid;
            if (compare(midSquared, x) == Ordering.EQUAL) {
                return mid;
            } else if (compare(midSquared, x) == Ordering.LARGER) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private static Ordering compare(double a, double b) {

        final double EPSILON = 0.00001;
        // Uses normalization for precision problem.
        double diff = (a - b) / b;
        return diff < -EPSILON ? Ordering.SMALLER
                : (diff > EPSILON ? Ordering.LARGER : Ordering.EQUAL);
    }

    public static void main(String[] args) {

        Random r = new Random();
        for (int times = 0; times < 100000; ++times) {
            double x;
            if (args.length == 1) {
                x = Double.valueOf(args[0]);
            } else {
                x = r.nextDouble() * 100000000;
            }
            double[] res = new double[2];
            System.out.println("x is " + x);
            System.out.println((res[0] = squareRoot(x)) + " " +
                    (res[1] = Math.sqrt(x)));
            assert (compare(res[0], res[1]) == Ordering.EQUAL);
        }
    }
    // @exclude

    private static enum Ordering {SMALLER, EQUAL, LARGER}
}
