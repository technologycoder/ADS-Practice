package practice.maths.bits;

public class BitTester {

    public static void main(final String[] args) {

        // testBytePositive();
        // testByteNegative();
        // System.out.println(Integer.toBinaryString(0xFF));

        testByteAssignTwosComplement_success();

    }

    private static void testBytePositive() {

        byte num = 0b0011;
        display(num);
    }

    private static void testByteNegative() {

        byte num = -0b0011;
        display(num);
    }

    private static void testByteAssignTwosComplement_fail() {

        // cannot assign more than 7 bits because the 8th bit is for sign
        // 2's complement for -3 = 1111_1101
        byte num = 0b111_1101;
        // does not work, prints 125
        display(num);
    }

    private static void testByteAssignTwosComplement_success() {

        // 2's complement for -3 = 1111_1101
        byte num = (byte) Integer.parseInt("11111101", 2);
        // works, prints -3
        display(num);
    }

    private static void display(final byte value) {

        System.out.println(value);

        // print as 8 bit byte. Prints 2's complement for negative numbers.
        // performs AND with 11111111 and thus removes all bits above index 7
        System.out.println(Integer.toBinaryString(value & 0xFF));

        // only the bits that form the number are displayed. Does not print 2's
        // complement
        System.out.println(Integer.toString(value, 2));
        System.out.println("-----------------------------");

    }

    private static void display(final short value) {

        System.out.println(value);

        // print as 8 bit byte. Prints 2's complement for negative numbers.
        System.out.println(Integer.toBinaryString(value & 0xFFFF));

        // only the bits that form the number are displayed. Does not print 2's
        // complement
        System.out.println(Integer.toString(value, 2));
        System.out.println("-----------------------------");

    }

    private static void display(final int value) {
        System.out.println(value);
        // print as 32 bit integer. Prints 2's complement for negative numbers.
        System.out.println(Integer.toBinaryString(value));

        // only the bits that form the number are displayed. Does not print 2's
        // complement
        System.out.println(Integer.toString(value, 2));
        System.out.println("-----------------------------");
    }

}
