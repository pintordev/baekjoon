import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int[][] p = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            p[i][0] = read();
            p[i][1] = read();
        }

        int[][] memo = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i + j <= n; j++) {
                int k = i + j;
                memo[j][k] = Integer.MAX_VALUE;
                for (int l = j; l < k; l++) {
                    memo[j][k] = Math.min(memo[j][k], memo[j][l] + memo[l + 1][k] + p[j][0] * p[l][1] * p[k][1]);
                }
            }
        }
        System.out.println(memo[1][n]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}