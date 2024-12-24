import java.io.IOException;

public class Main {
    public static int mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        int t = read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(count(read())).append('\n');
        }
        System.out.print(sb);
    }

    public static long count(int len) {
        if (len % 2 == 1) return 0;

        long[] dp = new long[len + 1];
        dp[0] = 1;
        for (int i = 2; i <= len; i += 2) {
            for (int j = 2; j <= i; j += 2) {
                dp[i] = (dp[i] + dp[j - 2] * dp[i - j]) % mod;
            }
        }
        return dp[len];
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}