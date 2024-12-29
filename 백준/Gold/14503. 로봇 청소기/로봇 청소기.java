import java.io.IOException;

public class Main {
    public static int n, m, r, c, d;
    public static int[][] map;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};
    public static int cnt = 1;

    public static void main(String[] args) throws IOException {
        n = read(); m = read();
        r = read(); c = read(); d = read();

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = read();
            }
        }

        run(r, c, d);
        System.out.println(cnt);
    }

    public static void run(int r, int c, int d) {
        map[r][c] = -1;

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (map[nr][nc] != 0) continue;

            cnt++;
            run(nr, nc, d);
            return;
        }

        int bd = (d + 2) % 4;
        int nr = r + dr[bd];
        int nc = c + dc[bd];

        if (nr < 0 || nr >= n || nc < 0 || nc >= m) return;
        if (map[nr][nc] == 1) return;

        run(nr, nc, d);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}