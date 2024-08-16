import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int t = read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(simulate()).append('\n');
        }
        System.out.println(sb);
    }

    public static int[] ps;
    public static int[][] memo;

    public static int simulate() throws IOException {
        int k = read();
        ps = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            ps[i] = ps[i - 1] + read();
        }

        memo = new int[k + 1][k + 1];
        return dp(1, k);
    }

    public static int dp(int s, int e) {
        if (s == e) return 0;
        if (memo[s][e] != 0) return memo[s][e];

        int min = Integer.MAX_VALUE;
        for (int i = s; i < e; i++) {
            min = Math.min(min, dp(s, i) + dp(i + 1, e));
        }
        return memo[s][e] = min + ps[e] - ps[s - 1];
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}