import java.io.IOException;

public class Main {
    public static int mod = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        int n = read();
        int k = read();

        int[][] memo = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            memo[i][1] = 1;
        }
        for (int i = 0; i <= k; i++) {
            memo[1][i] = i;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                memo[i][j] = (memo[i - 1][j] + memo[i][j - 1]) % mod;
            }
        }
        System.out.println(memo[n][k]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}