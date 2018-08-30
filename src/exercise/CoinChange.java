package exercise;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CoinChange {

    public static int change(int[] coins, int amount) {
        int[][] changes = new int[coins.length][amount + 1];
        for (int i = 1; i <= amount; i++) {
            if (i % coins[0] == 0) {
                changes[0][i] = 1;
            }
        }
        for (int i = 0; i < coins.length; i++) {
            changes[i][0] = 1;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                for (int l = j; l >= 0; l -= coins[i]) {
                    changes[i][j] += changes[i - 1][l];
                }
            }
        }
        return changes[coins.length - 1][amount];
    }

    public static int leastCoinChange(int[] coins, int amount) {
        int[][] count = new int[coins.length][amount + 1];
        for (int i = coins[0]; i <= amount; i++) {
            if (i % coins[0] == 0) {
                count[0][i] = i / coins[0];
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int minCoin = count[i - 1][j];
                for (int k = 1, col = j - coins[i]; col >= 0; k++, col -= coins[i]) {
                    if (col != 0 && count[i - 1][col] == 0)
                        continue;
                    minCoin = Math.min(minCoin, k + count[i - 1][col]);
                }
                count[i][j] = minCoin;
            }
        }
        System.out.println(Arrays.deepToString(count));
        return count[coins.length - 1][amount];
    }

    @Test
    public void testChange() {
        Assert.assertEquals(3, CoinChange.change(new int[]{1, 3, 4}, 5));
        Assert.assertEquals(10, CoinChange.change(new int[]{1, 2, 5}, 10));
    }

    @Test
    public void testLeastCoinChange() {
        Assert.assertEquals(2, CoinChange.leastCoinChange(new int[]{1, 3, 4}, 5));
        Assert.assertEquals(2, CoinChange.leastCoinChange(new int[]{1, 2, 5}, 10));
        Assert.assertEquals(3, CoinChange.leastCoinChange(new int[]{2, 3}, 8));
        Assert.assertEquals(0, CoinChange.leastCoinChange(new int[]{3, 5}, 7));
    }

}
