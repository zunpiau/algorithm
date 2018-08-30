package leetcode;

public class _693_BinaryNumberwithAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        return !s.contains("00") && !s.contains("11");
    }
}
