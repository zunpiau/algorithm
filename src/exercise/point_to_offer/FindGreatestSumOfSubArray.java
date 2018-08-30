package exercise.point_to_offer;

public class FindGreatestSumOfSubArray {

    public int find(int[] array) {
        int maxSum = array[0];
        for (int i = 1, currentSum = array[0]; i < array.length; i++) {
            currentSum = Math.max(currentSum + array[i], array[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

}
