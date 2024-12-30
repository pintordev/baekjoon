import java.io.IOException;

public class Main {
    public static int n, m, max = 0;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dr = {0, 0, 1, -1};
    public static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        n = read(); m = read();

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = read();
            }
        }

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
                check(i, j);
            }
        }
        System.out.println(max);
    }

    public static void dfs(int r, int c, int cnt, int sum) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (visited[nr][nc]) continue;

            visited[nr][nc] = true;
            dfs(nr, nc, cnt + 1, sum + map[nr][nc]);
            visited[nr][nc] = false;
        }
    }

    public static void check(int r, int c) {
        if (r + 2 < n && c + 1 < m) max = Math.max(max, map[r][c] + map[r + 1][c] + map[r + 2][c] + map[r + 1][c + 1]);
        if (r + 2 < n && c > 0) max = Math.max(max, map[r][c] + map[r + 1][c] + map[r + 2][c] + map[r + 1][c - 1]);
        if (r + 1 < n && c + 2 < m) max = Math.max(max, map[r][c] + map[r][c + 1] + map[r][c + 2] + map[r + 1][c + 1]);
        if (r > 0 && c + 2 < m) max = Math.max(max, map[r][c] + map[r][c + 1] + map[r][c + 2] + map[r - 1][c + 1]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}