package exercise.point_to_offer;

public class RectCover {

    public int cover(int target) {
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
