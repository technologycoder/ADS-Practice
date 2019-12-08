package practice.hr;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t1 = in.nextInt();
        int t2 = in.nextInt();

        int index = in.nextInt();
        BigInteger a = BigInteger.valueOf(t1);
        BigInteger b = BigInteger.valueOf(t2);
        BigInteger num = BigInteger.valueOf(0);

        for (int i = 3; i <= index; ++i) {
            num = a.add(b.multiply(b));
            a = b;
            b = num;
        }

        System.out.println(num);

    }

}
