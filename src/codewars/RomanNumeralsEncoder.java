package codewars;

public class RomanNumeralsEncoder {

    public static void main(String[] args) {
        RomanNumeralsEncoder encoder = new RomanNumeralsEncoder();
        System.out.println(encoder.solution(9));

    }

    public String solution(int n) {
        StringBuilder builder = new StringBuilder();
        int[] numbers = {1, 5, 10, 50, 100, 500, 1000};
        char[] romanNumbers = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        for (int i = numbers.length - 1; n > 0 && i >= 0; i--) {
            int quotient = n / numbers[i];
            int mod = n % numbers[i];
            if (i - 1 >= 0 && mod / numbers[i - 1] > 3 && quotient == 1) {
                builder.append(romanNumbers[i - 1]);
                builder.append(romanNumbers[i + 1]);
                n -= numbers[i + 1] - numbers[i - 1];
            } else if (quotient > 3) {
                builder.append(romanNumbers[i]);
                builder.append(romanNumbers[i + 1]);
                n = mod;
            } else {
                for (int j = 0; j < quotient; j++) {
                    builder.append(romanNumbers[i]);
                }
                n = mod;
            }
        }
        return builder.toString();
    }

}
