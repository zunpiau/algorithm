package exercise.point_to_offer;

import java.util.ArrayList;

public class ContinuousSequence {

    public static void main(String[] args) {
        System.out.println(new ContinuousSequence().FindContinuousSequence(100));
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = (int) Math.sqrt(sum * 2); i >= 2; i--) {
            int p = sum / i;
            if ((i % 2 == 1 && p * i == sum) || (i % 2 == 0 && (p * i) + i / 2 == sum)) {
                ArrayList<Integer> numbers = new ArrayList<>(i);
                for (int j = p - (i - 1) / 2, k = 0; k < i; j++, k++) {
                    numbers.add(j);
                }
                lists.add(numbers);
            }
        }
        return lists;
    }
}
