package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _412_FizzBuzz {

    public List<String> fizzBuzz(int n) {
        ArrayList<String> strings = new ArrayList<>(n + 1);
        for (int value = 1; value <= n; value++) {
            if (value % 3 != 0 && value % 5 != 0) {
                strings.add(String.valueOf(value));
            } else if (value % 5 != 0) {
                strings.add("Fizz");
            } else if (value % 3 != 0) {
                strings.add("Buzz");
            } else {
                strings.add("FizzBuzz");
            }
        }
        return strings;
    }

}
