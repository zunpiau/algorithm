package codewars;

import java.util.TreeSet;

public class IntPart {

    public static void main(String[] args) {
        System.out.println(codewars.IntPart.part(36));
    }

    public static String part(long n) {
        int number = (int) n;
        TreeSet<Integer> products = new TreeSet<>();
        products.add(number);
        int[] last = new int[]{number};
        while (true) {
            int[] ints;
            int lastNotOne = -1;
            for (int i = last.length - 1; i >= 0; i--) {
                if (last[i] != 1) {
                    lastNotOne = i;
                    break;
                }
            }
            if (lastNotOne == -1)
                break;
            int head = last[lastNotOne] - 1;
            int remain = number - sum(last, 0, lastNotOne + 1) + 1;
            int mod = remain % head;
            int q = remain / head;
            ints = new int[(mod == 0 ? q : q + 1) + lastNotOne + 1];
            System.arraycopy(last, 0, ints, 0, lastNotOne);
            ints[lastNotOne] = head;
            for (int i = lastNotOne + 1; i < ints.length - 1; i++) {
                ints[i] = head;
            }
            ints[ints.length - 1] = mod == 0 ? head : mod;
            last = ints;
            int product = product(ints);
            products.add(product);
        }
        Integer[] array = products.toArray(new Integer[0]);
        int mid = array.length / 2;
        long sum = 0;
        for (int i : array) {
            sum += i;
        }
        double median = array.length % 2 == 1 ? array[mid] : (array[mid] + array[mid - 1]) / 2.0;
        return String.format("Range: %d Average: %.2f Median: %.2f",
                products.last() - products.first(),
                (0.0 + sum) / products.size(), median);
    }

    private static int sum(int[] array, int start, int end) {
        int product = 0;
        while (start < end) {
            product += array[start];
            start++;
        }
        return product;
    }

    private static int product(int[] array) {
        int product = 1;
        for (int anArray : array) {
            product *= anArray;
        }
        return product;
    }
}
