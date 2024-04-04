import java.io.IOException;

class Main {
    public static int[] dp = new int[11];

    public static void main(String[] args) throws IOException {
        int t = read();

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = read();
            sb.append(dp(n)).append('\n');
        }
        System.out.println(sb);
    }

    public static int dp(int n) {

        if (dp[n] > 0) return dp[n];
        dp[n] = dp(n - 1) + dp(n - 2) + dp(n - 3);
        return dp[n];
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}