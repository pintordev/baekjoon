import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = read();
            }
        }

        int[][] memo = new int[n][m];
        memo[0][0] = map[0][0];
        for (int i = 1; i < m; i++) {
            memo[0][i] = memo[0][i - 1] + map[0][i];
        }

        int[][] sub = new int[2][m];
        for (int i = 1; i < n; i++) {
            sub[0][0] = memo[i - 1][0] + map[i][0];
            for (int j = 1; j < m; j++) {
                sub[0][j] = Math.max(sub[0][j - 1], memo[i - 1][j]) + map[i][j];
            }

            sub[1][m - 1] = memo[i - 1][m - 1] + map[i][m - 1];
            for (int j = m - 2; j >= 0; j--) {
                sub[1][j] = Math.max(sub[1][j + 1], memo[i - 1][j]) + map[i][j];
            }

            for (int j = 0; j < m; j++) {
                memo[i][j] = Math.max(sub[0][j], sub[1][j]);
            }
        }
        System.out.println(memo[n - 1][m - 1]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }
}