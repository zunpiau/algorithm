package leetcode;

public class _013_RomanToInteger {

    public int romanToInt(String s) {
        int[] ints = new int[s.length()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = singleRomanToInt(s.charAt(i));
        }
        int count = 0;
        int i;
        for (i = 0; i < ints.length; i++) {
            if (i == ints.length - 1) {
                count += ints[i];
                break;
            }
            if (ints[i] >= ints[i + 1])
                count += ints[i];
            else {
                count += (ints[i + 1] - ints[i]);
                i++;
            }
        }
        return count;
    }

    private int singleRomanToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'M':
                return 1000;
            case 'D':
                return 500;
        }
        return 1;
    }

}
