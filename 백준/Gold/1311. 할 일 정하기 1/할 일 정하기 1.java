import java.io.IOException;

public class Main {
    public static int n;
    public static int[][] d;
    public static int[][] memo;

    public static void main(String[] args) throws IOException {
        n = read();

        d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = read();
            }
        }

        memo = new int[n][1 << n];
        System.out.println(dp(0, 0));
    }

    public static int dp(int depth, int status) {
        if (depth == n) return 0;
        if (memo[depth][status] != 0) return memo[depth][status];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if ((status & (1 << i)) == 0) {
                min = Math.min(min, dp(depth + 1, status | (1 << i)) + d[depth][i]);
            }
        }
        return memo[depth][status] = min;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}