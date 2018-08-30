package misc;

import java.util.Random;

/**
 * 洗牌算法
 * <a href="https://coolshell.cn/articles/8593.html">如何测试洗牌程序<a/>
 */
public class FisherYatesShuffle {

    public static void main(String[] args) {
        int TIMES = 100;
        int[][] counter = new int[10][10];
        FisherYatesShuffle shuffle = new FisherYatesShuffle();
        int[] array;
        for (int i = 0; i < TIMES; i++) {
            array = shuffle.shuffle(10);
            for (int j = 0; j < array.length; j++) {
                counter[array[j]][j]++;
            }
        }
        double sum = 0;
        for (int[] ints : counter) {
            sum += variance(ints);
        }
        System.out.println(sum / counter[0].length / TIMES);
    }

    private static double variance(int[] numbers) {
        double sum = 0, squareSum = 0, l = numbers.length;
        for (int i : numbers) {
            sum += i;
            squareSum += i * i;
        }
        return (squareSum * l - sum * sum) / (l * l);
    }

    public int[] shuffle(int length) {
        return shuffle(0, length - 1);
    }

    public int[] shuffle(int start, int end) {
        int[] array = new int[end - start + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = start + i;
        }
        shuffle(array);
        return array;
    }

    public void shuffle(int[] array) {
        int r, temp;
        Random random = new Random(System.nanoTime());
        for (int i = array.length - 1; i >= 0; i--) {
            r = random.nextInt(i + 1);
            temp = array[r];
            array[r] = array[i];
            array[i] = temp;
        }
    }

}
