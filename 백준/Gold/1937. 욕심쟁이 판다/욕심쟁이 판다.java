import java.io.IOException;

public class Main {
    public static int n;
    public static int[][] map;
    public static int[][] memo;
    public static int[] dr = {0, 0, 1, -1};
    public static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        n = read();

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = read();
            }
        }

        int max = 0;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }
        System.out.println(max);
    }

    public static int dfs(int r, int c) {
        if (memo[r][c] != 0) return memo[r][c];

        memo[r][c] = 1;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            if (map[nr][nc] <= map[r][c]) continue;

            memo[r][c] = Math.max(memo[r][c], dfs(nr, nc) + 1);
        }
        return memo[r][c];
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}