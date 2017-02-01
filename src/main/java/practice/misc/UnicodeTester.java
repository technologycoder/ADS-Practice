package practice.misc;

public class UnicodeTester {
    public static void main(final String[] args) {

        String t = "\uD801\uDC00";

        System.out.println(t);

        char[] arr = Character.toChars(0x10400);

        for (char c : arr) {
            System.out.print(c + " " + Character.getNumericValue(c));
            System.out.println();
        }

        String hex = "00a5";
        int intValue = Integer.parseInt(hex, 16);
        System.out.println((char) intValue);

        int x = 0x10400;
        System.out.println(newString(x));

    }

    public static String newString(final int codePoint) {
        return new String(Character.toChars(codePoint));
    }
}
