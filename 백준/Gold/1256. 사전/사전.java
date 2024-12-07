import java.io.IOException;

public class Main {
    public static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();
        int k = read();

        int len = n + m;
        long[][] memo = new long[len + 1][len + 1];
        memo[0][0] = 1;

        for (int i = 1; i <= len; i++) {
            memo[i][0] = 1;
            memo[i][i] = 1;
            for (int j = 1; j < i; j++) {
                memo[i][j] = memo[i - 1][j - 1] + memo[i - 1][j];
                if (memo[i][j] > INF) memo[i][j] = INF;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (memo[len][n] < k) sb.append(-1);
        else {
            while (!(n == 0 && m == 0)) {
                if (memo[len - 1][m] >= k) {
                    sb.append('a');
                    n--;
                } else {
                    sb.append('z');
                    k -= memo[len - 1][m];
                    m--;
                }
                len--;
            }
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