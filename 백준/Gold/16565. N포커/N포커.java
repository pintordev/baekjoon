import java.io.IOException;

public class Main {
    public static int mod = 10_007;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();

        int n = read();
        int cnt = 0;
        for (int i = 1; i <= 13 && n - 4 * i >= 0; i++) {
            int t = dp[52 - 4 * i][n - 4 * i] * dp[13][i] % mod;
            if (i % 2 == 1) cnt = (cnt + t) % mod;
            else cnt = (cnt - t + mod) % mod;
        }
        System.out.println(cnt);
    }

    public static void init() throws IOException {
        dp = new int[53][53];
        for (int i = 0; i < 53; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < 53; i++) {
            for (int j = 1; j < 53; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod;
            }
        }
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}