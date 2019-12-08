package practice.maths;

public class BitManipulation {
    public static void main(String[] args) {
        // getBit(10, 2);

        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(-4));

        int num = 4;
        System.out.println(Integer.toBinaryString(num));
        num = (1 << 4) | num;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(num);
    }

    private static void getBit(int num, int n) {

        int value = -28;

        System.out.println(Integer.toBinaryString(value));

        System.out.println(Integer.toString(value, 2));

    }

    static String convertToBinaryBuiltIn(int num) {

        return Integer.toBinaryString(num);

    }

    static String convertToBinaryUsingMask(int num) {

        StringBuffer sb = new StringBuffer();

        for (int i = 31; i >= 0; --i) {

            int mask = (1 << i);

            if (((num & mask) != 0))
                sb.append("1");
            else
                sb.append("0");
        }
        return sb.toString();

    }

    // set a bit

    // get a bit

    // clear bit

    // IntToBinaryStr : postive and nagitive 2's complement
    // BinaryStr to Int: positive and 2's complement

}