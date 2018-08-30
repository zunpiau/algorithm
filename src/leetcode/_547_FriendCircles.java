package leetcode;

public class _547_FriendCircles {

    public int findCircleNum(int[][] M) {
        boolean[] booleans = new boolean[M.length];
        int circle = 0;
        for (int i = 0; i < M.length; i++) {
            if (!booleans[i]) {
                circle++;
                dfs(M, booleans, i);
            }
        }
        return circle;
    }

    private void dfs(int[][] M, boolean[] booleans, int i) {
        booleans[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !booleans[j]) {
                dfs(M, booleans, j);
            }
        }
    }

}
