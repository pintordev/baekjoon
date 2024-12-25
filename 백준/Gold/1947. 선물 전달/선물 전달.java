import java.io.IOException;

public class Main {
    public static int mod = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        int n = read();

        long[] dp = new long[Math.max(3, n + 1)];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % mod;
        }
        System.out.println(dp[n]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}