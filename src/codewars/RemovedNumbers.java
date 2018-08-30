package codewars;

import java.util.ArrayList;
import java.util.List;

public class RemovedNumbers {

    public static void main(String[] args) {
        RemovedNumbers.removNb(260000000).forEach(longs -> System.out.println(longs[0] + " " + longs[1]));
    }

    public static List<long[]> removNb(long n) {
        List<long[]> numbers = new ArrayList<>();
        long total = (1 + n) * n / 2;
        for (long i = 1; i <= n; i++) {
            double a = (0.0 + total - i) / (i + 1);
            if (a <= n && a % 1 == 0)
                numbers.add(new long[]{i, (long) a});
        }
        return numbers;
    }

}
