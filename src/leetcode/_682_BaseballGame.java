package leetcode;

import java.util.ArrayList;

public class _682_BaseballGame {

    public int calPoints(String[] ops) {
        ArrayList<Integer> integers = new ArrayList<>();
        int tail, sum = 0, val;
        for (String op : ops) {
            tail = integers.size() - 1;
            switch (op) {
                case "+":
                    val = integers.get(tail) + integers.get(tail - 1);
                    integers.add(val);
                    sum += val;
                    break;
                case "C":
                    sum -= integers.remove(tail);
                    break;
                case "D":
                    val = integers.get(tail) * 2;
                    integers.add(val);
                    sum += val;
                    break;
                default:
                    val = Integer.parseInt(op);
                    integers.add(val);
                    sum += val;
                    break;
            }
        }
        return sum;
    }

}
