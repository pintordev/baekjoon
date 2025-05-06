import java.util.*;

class Solution {
    public static int n;
    public static int m;
    public static int[][] maze;
    public static boolean[][][] visited;
    public static int[] dr = {0, 1, 0, -1};
    public static int[] dc = {1, 0, -1, 0};
    public static int cnt;

    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        this.maze = maze;
        visited = new boolean[n][m][2];

        int srr = 0;
        int src = 0;
        int sbr = 0;
        int sbc = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) {
                    srr = i;
                    src = j;
                } else if (maze[i][j] == 2) {
                    sbr = i;
                    sbc = j;
                }
            }
        }

        visited[srr][src][0] = true;
        visited[sbr][sbc][1] = true;
        cnt = Integer.MAX_VALUE;
        dfs(srr, src, sbr, sbc, 0);
        return cnt == Integer.MAX_VALUE ? 0 : cnt;
    }

    public void dfs(int crr, int crc, int cbr, int cbc, int cnt) {
        if (cnt >= this.cnt) return;

        boolean red = maze[crr][crc] == 3;
        boolean blue = maze[cbr][cbc] == 4;

        if (red && blue) {
            this.cnt = Math.min(this.cnt, cnt);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nrr = red ? crr : crr + dr[i];
            int nrc = red ? crc : crc + dc[i];

            if (!red && !canMove(nrr, nrc, 0)) continue;

            for (int j = 0; j < 4; j++) {
                int nbr = blue ? cbr : cbr + dr[j];
                int nbc = blue ? cbc : cbc + dc[j];

                if (!blue && !canMove(nbr, nbc, 1)) continue;
                if (nrr == nbr && nrc == nbc) continue;
                if (crr == nbr && crc == nbc && cbr == nrr && cbc == nrc) continue;

                visited[nrr][nrc][0] = true;
                visited[nbr][nbc][1] = true;
                dfs(nrr, nrc, nbr, nbc, cnt + 1);
                visited[nrr][nrc][0] = false;
                visited[nbr][nbc][1] = false;
            }
        }
    }

    public boolean canMove(int nr, int nc, int color) {
        if (nr < 0 || nr >= n || nc < 0 || nc >= m) return false;
        if (maze[nr][nc] == 5) return false;
        if (visited[nr][nc][color]) return false;
        return true;
    }
}