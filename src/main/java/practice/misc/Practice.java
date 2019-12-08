package practice.misc;

public class Practice {
    public static void main(String[] args) {

        // permutation("", "ABCD");
        // combination("", "ABCD");

        towersOfHanoi(3, "A", "C", "B");
    }

    private static void permutation(String prefix, String str) {

        System.out.println(prefix + " - " + str);

        if (str.length() == 0) {
            System.out.println("=>" + prefix);
        } else {

            for (int i = 0; i < str.length(); ++i) {

                permutation(
                        prefix + str.charAt(i),
                        str.substring(0, i)
                                + str.substring(i + 1, str.length()));

            }
        }
    }

    private static void combination(String prefix, String str) {

        if (str.length() == 0) {
            System.out.println(prefix);
        } else {

            combination(prefix + str.charAt(0), str.substring(1));
            combination(prefix, str.substring(1));
        }

    }

    private static void towersOfHanoi(int num, String from, String to,
                                      String aux) {

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
