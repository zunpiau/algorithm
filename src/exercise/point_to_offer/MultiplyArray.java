package exercise.point_to_offer;

public class MultiplyArray {

    public static void main(String[] args) {
        new MultiplyArray().multiply(new int[]{1, 2, 3, 4});
    }

    public int[] multiply(int[] A) {
        int[] n = new int[A.length];
        int[] m = new int[A.length];
        n[0] = 1;
        m[A.length - 1] = 1;
        for (int i = 1; i < A.length; i++) {
            n[i] = A[i - 1] * n[i - 1];
            m[A.length - i - 1] = A[A.length - i] * m[A.length - i];
        }
        int[] target = new int[A.length];
        for (int i = 0; i < target.length; i++) {
            target[i] = n[i] * m[i];
        }
        return target;
    }

}
