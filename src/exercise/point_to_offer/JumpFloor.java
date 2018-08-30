package exercise.point_to_offer;

public class JumpFloor {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new JumpFloor().JumpFloor(i));
        }
    }

    public int JumpFloorII(int target) {
        if (target == 0) return 0;
        return (int) Math.pow(2, target - 1);
    }

    public int JumpFloor(int target) {
        if (target == 0) return 0;
        int n = 1;
        for (int i = 2, t, n2 = 1; i <= target; i++) {
            t = n;
            n += n2;
            n2 = t;
        }
        return n;
    }

}
