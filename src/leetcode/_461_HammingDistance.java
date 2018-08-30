package leetcode;

public class _461_HammingDistance {

    public int hammingDistance(int x, int y) {
        int a = x ^ y, result;
        for (result = 0; a != 0; a = a & (a - 1))
            result++;
        return result;
    }
}
