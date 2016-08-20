package practice.misc;

public class Misc {
    public static void main(final String[] args) {

        atoi("2764");
    }

    public static void atoi(final String str) {

        int num = 0;

        for (int i = 0; i < str.length(); ++i) {
            int temp = str.charAt(i) - '0';
            int exponent = str.length() - 1 - i;

            num += Math.pow(10, exponent) * temp;

            // int num1 = Character.getNumericValue(str.charAt(i));
            // System.out.println(str.charAt(i) + " - " + num + " - " + num1);
        }

        System.out.println(num);

    }
}
