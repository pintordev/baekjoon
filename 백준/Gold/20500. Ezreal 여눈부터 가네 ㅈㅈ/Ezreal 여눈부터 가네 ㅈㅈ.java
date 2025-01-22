import java.io.IOException;

public class Main {
    public static int mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        int n = read();

        if (n == 1) {
            System.out.println(0);
            return;
        }

        long[][] dp = new long[3][n + 1];
        dp[0][2] = dp[1][2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[0][i] = (dp[1][i - 1] + dp[2][i - 1]) % mod;
            dp[1][i] = (dp[0][i - 1] + dp[2][i - 1]) % mod;
            dp[2][i] = (dp[0][i - 1] + dp[1][i - 1]) % mod;
        }
        System.out.println(dp[0][n]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}