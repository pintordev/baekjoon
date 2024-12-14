import java.io.IOException;

public class Main {
    public static int mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        int n = read();
        int l = read();
        int r = read();

        long[][][] memo = new long[n + 1][n + 1][n + 1];
        memo[1][1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= l; j++) {
                for (int k = 1; k <= r; k++) {
                    memo[i][j][k] = (memo[i - 1][j - 1][k] + memo[i - 1][j][k - 1] + (i - 2) * memo[i - 1][j][k]) % mod;
                }
            }
        }
        System.out.println(memo[n][l][r]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}