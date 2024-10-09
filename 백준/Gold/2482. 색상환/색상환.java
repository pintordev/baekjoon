import java.io.IOException;

public class Main {
    public static int MOD = 1_000_000_003;

    public static void main(String[] args) throws IOException {
        int n = read();
        int k = read();

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
        }

        for (int i = 3; i <= n; i++) {
            for (int j = 2; j <= (i + 1) >> 1 && j <= k; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % MOD;
            }
        }

        System.out.println((dp[n - 3][k - 1] + dp[n - 1][k]) % MOD);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}