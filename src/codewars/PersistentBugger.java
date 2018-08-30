package codewars;

public class PersistentBugger {

    public static void main(String[] args) {
        System.out.println(PersistentBugger.persistence(10));
    }

    public static int persistence(long n) {
        int count = 0;
        for (long num = n; num >= 10; count++) {
            n = num;
            num = 1;
            while (n > 0) {
                num *= n % 10;
                n /= 10;
            }
        }
        return count;
    }
}
