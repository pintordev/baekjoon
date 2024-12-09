import java.io.IOException;

public class Main {
    public static int n;
    public static double[] rates;
    public static int[] dr = {0, 0, 1, -1};
    public static int[] dc = {1, -1, 0, 0};
    public static boolean[][] visited;
    public static double res;

    public static void main(String[] args) throws IOException {
        n = read();
        rates = new double[]{.01 * read(), .01 * read(), .01 * read(), .01 * read()};

        visited = new boolean[30][30];
        res = 0;
        dfs(15, 15, 0, 1);
        System.out.println(res);
    }

    public static void dfs(int r, int c, int depth, double t) {
        if (depth == n) {
            res += t;
            return;
        }

        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (!canMove(nr, nc)) continue;

            visited[nr][nc] = true;
            dfs(nr, nc, depth + 1, t * rates[i]);
            visited[nr][nc] = false;
        }
    }

    public static boolean canMove(int r, int c) {
        if (r < 0 || r >= 30 || c < 0 || c >= 30) return false;
        if (visited[r][c]) return false;
        return true;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}