package leetcode;

public class _069_Sqrt {

    public static void main(String[] args) {
        int[] testCases = new int[]{1, 2, 8, Integer.MAX_VALUE};
        _069_Sqrt sqrt = new _069_Sqrt();
        for (int i : testCases) {
            System.out.println(sqrt.mySqrt(i));
        }
    }

    public int mySqrt(int x) {
        if (x <= 1) return x;
        int h = x / 2;
        long pow = 0;
        for (int l = 1, mid = 0; l <= h; mid = l + (h - l) / 2, pow = (long) mid * mid) {
            if (pow == x) return mid;
            else if (pow > x) h = mid - 1;
            else l = mid + 1;
        }
        return h;
    }

}
