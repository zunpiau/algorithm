package leetcode;

public class _657_JudgeRouteCircle {

    public boolean judgeCircle(String moves) {
        return (moves.length() - moves.replace("L", "").length()) == (moves.length() - moves.replace("R", "").length()) &&
                (moves.length() - moves.replace("U", "").length()) == (moves.length() - moves.replace("D", "").length());
    }
}
