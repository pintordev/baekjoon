import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int t = read();

        int[] ps = new int[501];
        int[][] memo = new int[501][501];

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int k = read();
            for (int i = 1; i <= k; i++) {
                ps[i] = ps[i - 1] + read();
            }

            for (int len = 1; len <= k; len++) {
                for (int s = 1; s + len <= k; s++) {
                    int e = s + len;
                    memo[s][e] = Integer.MAX_VALUE;
                    for (int i = s; i < e; i++) {
                        memo[s][e] = Math.min(memo[s][e], memo[s][i] + memo[i + 1][e]);
                    }
                    memo[s][e] += ps[e] - ps[s - 1];
                }
            }
            sb.append(memo[1][k]).append('\n');
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