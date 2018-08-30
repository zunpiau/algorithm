package exercise.point_to_offer;

public class SpecialAddition {

    public int Add(int num1, int num2) {
        int sum, carry;
        for (sum = num1 ^ num2, carry = (num1 & num2) << 1; carry != 0; ) {
            int a = sum, b = carry;
            sum = a ^ b;
            carry = (a & b) << 1;
        }
        return sum;
    }
}
