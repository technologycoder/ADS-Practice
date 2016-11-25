package practice.misc;

public class Recursion {

    public static void main(final String[] args) {

        // combinations("", "ABCD");
        permutations("", "ABC");
        // towersOfHanoi(3, "A", "C", "B");
    }

    private static void combinations(final String prefix, final String str) {

        if (str.length() == 0) {
            System.out.println(prefix);
        } else {

            combinations(prefix + str.charAt(0), str.substring(1));
            combinations(prefix, str.substring(1));

        }

    }

    private static void permutations(final String prefix, final String str) {

        if (str.length() == 0) {
            System.out.println(prefix);
        } else {

            for (int i = 0; i < str.length(); ++i) {

                permutations(
                        prefix + str.charAt(i),
                        str.substring(0, i)
                                + str.substring(i + 1, str.length()));
            }

        }

    }

    private static void towersOfHanoi(final int num, final String from, final String to,
            final String aux) {

        if (num == 1) {
            System.out.println(String.format("Move %s from %s to %s", num,
                    from, to));

        } else {

            towersOfHanoi(num - 1, from, aux, to);

            System.out.println(String.format("Move %s from %s to %s", num,
                    from, to));

            towersOfHanoi(num - 1, aux, to, from);

        }

    }

}
