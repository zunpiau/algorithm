package exercise.dsa;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.dreamxu.com/books/dsa/dp/edit-distance.html
 */
public class EditDistance {

    public static int editDistance(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        int[][] distances = new int[lengthA + 1][lengthB + 1];
        for (int i = 0; i <= lengthA; i++) {
            distances[i][0] = i;
        }
        for (int j = 0; j <= lengthB; j++) {
            distances[0][j] = j;
        }
        for (int i = 1; i <= lengthA; i++) {
            for (int j = 1; j <= lengthB; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    distances[i][j] = distances[i - 1][j - 1];
                } else {
                    distances[i][j] = Math.min(distances[i - 1][j - 1], Math.min(distances[i - 1][j], distances[i][j - 1])) + 1;
                }
            }
        }
        return distances[lengthA][lengthB];
    }

    @Test
    public void test() {
        assertEquals(2, EditDistance.editDistance("fxyh", "fay"));
    }

}
