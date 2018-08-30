package codewars;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ConsecutiveStrings {

    public static String longestConsec(String[] strarr, int k) {
        if (strarr.length == 0 || k > strarr.length || k <= 0) return "";
        StringBuilder builder = new StringBuilder();
        List<String> strings = Arrays.stream(strarr)
                .distinct()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
        Arrays.sort(strarr, Comparator.comparingInt(String::length).reversed());
        for (int i = 0; i < k; i++) {
            builder.append(strings.get(i));
        }
        return builder.toString();
    }

}
