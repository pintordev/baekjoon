import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int INF = 1000 * 1000;

    public static void main(String[] args) throws IOException {
        int n = read();

        int[][] cost = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j] = read();
            }
        }

        int[] dp = new int[3];
        int result = INF;
        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp, INF);
            dp[i] = cost[0][i];

            for (int j = 1; j < n; j++) {
                int a = Math.min(dp[1], dp[2]) + cost[j][0];
                int b = Math.min(dp[0], dp[2]) + cost[j][1];
                int c = Math.min(dp[0], dp[1]) + cost[j][2];

                dp[0] = a;
                dp[1] = b;
                dp[2] = c;
            }

            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                result = Math.min(result, dp[j]);
            }
        }

        System.out.println(result);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}