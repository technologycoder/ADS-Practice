package practice.maths.bits;

public class BitManipuations {
    public static void main(final String[] args) throws Exception {

        // System.out.println(Integer.toBinaryString(-3));
        // itoBits(13);

        bitsToI_builtIn_with_2sComplement();
    }

    public static void bitsToI_builtIn_with_2sComplement() {

        System.out.println(Integer.parseInt("11", 2));

        System.out.println(Byte.parseByte("1111111", 2));

        // for byte it needs 8 bits - this works
        System.out.println((byte) Integer.parseInt("11111101", 2));

        // for byte it needs 8 bits - this DOES NOT work - print out 13
        System.out.println((byte) Integer.parseInt("1101", 2));

        // for short it needs 16 bits - this works
        System.out.println((short) Integer.parseInt("1111111111111101", 2));

        // for short it needs 16 bits - this DOES NOT work - print out 4093
        System.out.println((short) Integer.parseInt("111111111101", 2));

        // for int we need 32 bits and we need to parse as LONG - this works
        System.out.println((int) Long.parseLong("11111111111111111111111111111101", 2));

        // for int we need 32 bits and we need to parse as LONG - this throws
        // exception
        // System.out.println(Integer.parseInt("11111111111111111111111111111101",
        // 2));

    }

    public static void itoBits_2sComplement_builtIn() {

        // 3
        assert "11".equals(Integer.toBinaryString(3));

        // -3
        assert "11111111111111111111111111111101".equals(Integer.toBinaryString(-3));

    }

    public static void itoBits_builtIn() {

        // 3
        assert "11".equals(Integer.toString(3, 2));

        // -3
        assert "-11".equals(Integer.toString(-3, 2));

    }

    public static void itoBits(final int num) {

        System.out.println(Integer.toBinaryString(num));

        StringBuilder sb = new StringBuilder();

        for (int i = 31; i >= 0; i--) {

            int mask = 1 << i;

            if ((num & mask) == mask) {
                sb.append("1");
            } else {
                sb.append("0");
            }

        }

        String str = sb.toString();

        System.out.println(str);

        // fails
        // int result = Integer.parseInt(str.substring(25), 2);

        int result = (int) Long.parseLong(str, 2);

        // both of the following works
        // byte result = (byte) Integer.parseInt(str.substring(1), 2);
        // short result = (short) Integer.parseInt(str.substring(1), 2);

        if (num != result) {
            System.out.println("ERROR: " + result);
        }

        System.out.println(result);

    }

}
