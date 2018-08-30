package leetcode;

public class _441_ArrangingCoins {

    public static void main(String[] args) {
        int[] testCases = new int[]{0, 1, 2, 5, 8, Integer.MAX_VALUE};
        _441_ArrangingCoins coins = new _441_ArrangingCoins();
        for (int i : testCases) {
            System.out.println(coins.arrangeCoins(i));
        }
    }

    public int arrangeCoins(int n) {
        int h = n;
        long c = 0;
        for (int l = 0, mid = 0; l <= h; mid = l + (h - l) / 2, c = mid * (mid + 1L) / 2) {
            if (c == n) return mid;
            if (c > n) h = mid - 1;
            else l = mid + 1;
        }
        return h;
    }
}
