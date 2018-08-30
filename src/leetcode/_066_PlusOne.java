package leetcode;

public class _066_PlusOne {

    static public int[] plusOne(int[] digits) {
        int l = digits.length;
        for (int i = l - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                break;
            }
        }
        if (digits[0] == 0) {
            int[] carry = new int[digits.length + 1];
            carry[0] = 1;
            return carry;
        } else
            return digits;
    }

}
