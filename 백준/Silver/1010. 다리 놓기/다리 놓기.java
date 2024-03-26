import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {

        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = read(), m = read();
            int[] dp = new int[(m + 1) * (m + 2) / 2];
            sb.append(comb(m, n, dp)).append('\n');
        }
        System.out.println(sb);
    }

    public static int comb(int m, int n, int[] dp) {
        int i = m * (m + 1) / 2 + n;
        if (dp[i] > 0) return dp[i];
        if (n == 0 || n == m) dp[i] = 1;
        else dp[i] = comb(m - 1, n - 1, dp) + comb(m - 1, n, dp);
        return dp[i];
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}