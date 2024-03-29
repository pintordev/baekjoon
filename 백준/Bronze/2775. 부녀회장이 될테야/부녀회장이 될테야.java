import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        int t = read();
        while (t-- > 0) {
            int k = read();
            int n = read();

            int dp[][] = new int[k + 1][n];
            for (int i = 1; i <= k; i++) dp[i][0] = 1;
            for (int j = 0; j < n; j++) dp[0][j] = j + 1;

            for (int i = 1; i <= k; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            sb.append(dp[k][n - 1]).append('\n');
        }
        System.out.println(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}