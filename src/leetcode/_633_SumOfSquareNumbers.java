package leetcode;

public class _633_SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        int sqrt = (int) Math.sqrt(c);
        for (int i = 0, sum, j = sqrt; i <= j; ) {
            sum = i * i + j * j;
            if (sum > c) {
                j--;
            } else if (sum < c) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
