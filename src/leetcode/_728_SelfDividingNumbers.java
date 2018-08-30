package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _728_SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> integers = new ArrayList<>();
        int j, mod;
        boolean accept;
        for (int i = left; i <= right; i++) {
            j = i;
            accept = true;
            while (j > 0) {
                mod = j % 10;
                if (mod == 0 || i % mod != 0) {
                    accept = false;
                    break;
                }
                j = j / 10;
            }
            if (accept)
                integers.add(i);
        }
        return integers;
    }

    public List<Integer> selfDividingNumbers_stream(int left, int right) {

        return IntStream.rangeClosed(left, right)
                .filter(value -> {
                    for (int i = value; i > 0; i = i / 10) {
                        if (i % 10 == 0 || value % (i % 10) != 0) {
                            return false;
                        }
                    }
                    return true;
                })
                .boxed()
                .collect(Collectors.toList());
    }
}
