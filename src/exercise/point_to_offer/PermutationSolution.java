package exercise.point_to_offer;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationSolution {

    public static void main(String[] args) {
        PermutationSolution solution = new PermutationSolution();
        System.out.println(solution.Permutation("aabb"));
        System.out.println(solution.Permutation("abcd"));
        System.out.println(solution.Permutation("abccd"));
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> strings = new ArrayList<>();
        if (str.length() == 0) return strings;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        strings.add(new String(chars));
        while (true) {
            int smallerThanRight = -1;
            for (int i = chars.length - 2; i >= 0; i--) {
                if (chars[i] < chars[i + 1]) {
                    smallerThanRight = i;
                    break;
                }
            }
            if (smallerThanRight == -1) break;
            int smallestBigger = smallerThanRight + 1;
            for (int i = smallerThanRight + 2; i < chars.length; i++) {
                if (chars[i] > chars[smallerThanRight] && chars[i] <= chars[smallestBigger])
                    smallestBigger = i;
            }
            swap(chars, smallerThanRight, smallestBigger);
            reverse(chars, smallerThanRight + 1, chars.length - 1);
            strings.add(new String(chars));
        }
        return strings;
    }

    private void swap(char[] array, int a, int b) {
        char t = array[a];
        array[a] = array[b];
        array[b] = t;
    }

    private void reverse(char[] chars, int start, int end) {
        for (; start < end; start++, end--) {
            swap(chars, start, end);
        }
    }

}
