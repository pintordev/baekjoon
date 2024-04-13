import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int m;
    public static int n;
    public static int[][] map;
    public static int[][] memo;
    public static int[] dr = {0, 0, 1, -1};
    public static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        init();
        dfs(0, 0);
        System.out.println(memo[0][0]);
    }

    public static void dfs(int r, int c) {
        if (memo[r][c] >= 0) {
            return;
        }

        memo[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (!canMove(r, c, nr, nc)) continue;
            dfs(nr, nc);
            memo[r][c] += memo[nr][nc];
        }
    }

    public static boolean canMove(int r, int c, int nr, int nc) {
        return nr >= 0 && nr < m && nc >= 0 && nc < n && map[r][c] > map[nr][nc];
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        map = new int[m][n];
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                memo[i][j] = -1;
            }
        }
        memo[m - 1][n - 1] = 1;
    }
}