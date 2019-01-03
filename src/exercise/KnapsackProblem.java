package exercise;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * https://www.kancloud.cn/kancloud/pack/70125
 */
public class KnapsackProblem {

    public static int _01Knapsack(int[] value, int[] weight, int W) {
        int[][] values = new int[value.length + 1][W + 1];
        for (int i = 1; i <= value.length; i++) {
            for (int j = 1; j <= W; j++) {
                if (j >= weight[i - 1])
                    values[i][j] = Math.max(values[i - 1][j], values[i - 1][j - weight[i - 1]] + value[i - 1]);
                else
                    values[i][j] = values[i - 1][j];
            }
        }
        return values[value.length][W];
    }

    public static int _01KnapsackII(int[] value, int[] weight, int W) {
        int[] values = new int[W + 1];
        for (int i = 1; i <= value.length; i++) {
            for (int j = W; j > 0; j--) {
                if (j >= weight[i - 1])
                    values[j] = Math.max(values[j], values[j - weight[i - 1]] + value[i - 1]);
            }
        }
        return values[W];
    }

    public static int completeKnapsack(int[] value, int[] weight, int W) {
        ArrayList<Integer> valueList = new ArrayList<>();
        ArrayList<Integer> weightList = new ArrayList<>();
        for (int i = 0; i < weight.length; i++) {
            for (int k = 1; ; k *= 2) {
                int w = weight[i] * k;
                if (w > W) break;
                valueList.add(value[i] * k);
                weightList.add(w);
            }
        }
        return _01KnapsackII(valueList.stream().mapToInt(i -> i).toArray(),
                weightList.stream().mapToInt(i -> i).toArray(),
                W);
    }

    public static int completeKnapsackII(int[] value, int[] weight, int W) {
        int[][] values = new int[value.length + 1][W + 1];
        for (int i = 1; i <= value.length; i++) {
            for (int j = 1; j <= W; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = 0; ; k++) {
                    int w = weight[i - 1] * k;
                    if (w > j) break;
                    max = Math.max(max, values[i - 1][j - w] + value[i - 1] * k);
                }
                values[i][j] = max;
            }
        }
        return values[value.length][W];
    }

    public static int completeKnapsackIII(int[] value, int[] weight, int W) {
        int[][] values = new int[value.length + 1][W + 1];
        for (int i = 1; i <= value.length; i++) {
            for (int j = 1; j <= W; j++) {
                if (j >= weight[i - 1])
                    values[i][j] = Math.max(values[i][j], values[i][j - weight[i - 1]] + value[i - 1]);
                else
                    values[i][j] = values[i - 1][j];
            }
        }
        return values[value.length][W];
    }

    public static int completeKnapsackIV(int[] value, int[] weight, int W) {
        int[] values = new int[W + 1];
        for (int i = 1; i <= value.length; i++) {
            for (int j = 1; j <= W; j++) {
                if (j >= weight[i - 1])
                    values[j] = Math.max(values[j], values[j - weight[i - 1]] + value[i - 1]);
            }
        }
        return values[W];
    }

    @Test
    public void test() {
        assertEquals(37, _01Knapsack(new int[]{12, 10, 20, 15}, new int[]{2, 1, 3, 2}, 5));
        assertEquals(37, _01KnapsackII(new int[]{12, 10, 20, 15}, new int[]{2, 1, 3, 2}, 5));

        assertEquals(50, completeKnapsack(new int[]{12, 5, 20, 15}, new int[]{2, 1, 3, 2}, 7));
        assertEquals(50, completeKnapsackII(new int[]{12, 5, 20, 15}, new int[]{2, 1, 3, 2}, 7));
        assertEquals(50, completeKnapsackIII(new int[]{12, 5, 20, 15}, new int[]{2, 1, 3, 2}, 7));
        assertEquals(50, completeKnapsackIV(new int[]{12, 5, 20, 15}, new int[]{2, 1, 3, 2}, 7));
    }

}
