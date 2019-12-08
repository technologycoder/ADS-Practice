package practice.misc;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Interview {
    public static void main(String[] args) throws Exception {

        permute("ABC", "");

    }

    public static void permute(String str, String prefix) {

        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); ++i) {

                permute(str.substring(0, i) + str.substring(i + 1), prefix + str.charAt(i));
            }
        }

    }

    public static void main1(String[] args) throws Exception {

        Stream<String> stream = Files.lines(Paths.get("sample.txt"));

        final Map<String, Long> letterToCount = stream.map(w -> w.split("")).flatMap(Arrays::stream)
                .collect(groupingBy(identity(), counting()));

        System.out.println(letterToCount);

        String txt = "abcdefghijklmnopqrstuvwxyz_";

        List<String> str = Arrays.asList(txt.split(""));

        System.out.println(str);

        str.sort((String a, String b) -> (int) (letterToCount.get(a) - letterToCount.get(b)));

        System.out.println(str);

    }

}
