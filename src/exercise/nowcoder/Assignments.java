package exercise.nowcoder;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/50ae2573431c45db918797836a40406e
 */
public class Assignments {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int[] ints = new int[3];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
        }
        System.out.println(Assignments.assign(total, ints));
    }

    public static long assign(int total, int[] n) {
        long kind = 1;
        for (int i = 0, remainder = total; i < n.length; i++) {
            if (remainder > 0)
                kind *= c(remainder, n[i]);
            else
                kind *= c(total, n[i]);
            remainder -= n[i];
        }
        return kind % 1000000007;
    }

    private static long c(int n, int m) {
        long ans = 1;
        for (int i = n; i >= (n - m + 1); --i)
            ans *= i;
        while (m > 0)
            ans /= m--;
        return ans;
    }

}
