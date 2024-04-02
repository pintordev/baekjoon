import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        int mod = 15746;

        int n = read();
        if (n < 3) {
            System.out.println(n);
            return;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) dp[i] = (dp[i - 1] % mod + dp[i - 2] % mod) % mod;
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