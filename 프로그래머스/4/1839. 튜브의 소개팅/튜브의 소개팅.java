import java.util.*;

class Solution {
    public static int[] dr = {0, 0, 1, -1};
    public static int[] dc = {1, -1, 0, 0};

    public int[] solution(int m, int n, int s, int[][] time_map) {
        long[][] time = new long[m][n];
        for (long[] t : time) {
            Arrays.fill(t, Long.MAX_VALUE);
        }
        time[0][0] = 0;

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.r == m - 1 && cur.c == n - 1) {
                return new int[]{cur.d, (int) time[cur.r][cur.c]};
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (time_map[nr][nc] == -1) continue;

                long nTime = time[cur.r][cur.c] + time_map[nr][nc];
                if (nTime > s) continue;
                if (time[nr][nc] <= nTime) continue;

                time[nr][nc] = nTime;
                q.add(new Node(nr, nc, cur.d + 1));
            }
        }
        return null;
    }
}

class Node {
    int r;
    int c;
    int d;

    public Node(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}