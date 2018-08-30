package codewars;

public class PrimeDecomp {

    public static void main(String[] args) {
        System.out.println(PrimeDecomp.factors(342217392));
    }

    public static String factors(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            if (!isPrime(i)) continue;
            int count = 0;
            for (double q = 1.0 * n / i; q % 1.0 == 0; n /= i, q = 1.0 * n / i)
                count++;
            if (count == 0) continue;
            builder.append('(')
                    .append(i)
                    .append(count == 1 ? "" : "**" + count)
                    .append(')');
        }
        System.out.println();
        return builder.toString();
    }

    private static boolean isPrime(int n) {
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
