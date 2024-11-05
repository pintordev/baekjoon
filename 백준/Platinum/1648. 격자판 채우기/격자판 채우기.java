import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int mod = 9901;
    public static int n;
    public static int m;
    public static int[][] memo;

    public static void main(String[] args) throws IOException {
        n = read();
        m = read();

        memo = new int[n * m][1 << m];
        for (int i = 0; i < n * m; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(fill(0, 0));
    }

    public static int fill(int depth, int status) {
        if (depth == n * m && status == 0) return 1;
        if (depth >= n * m) return 0;
        if (memo[depth][status] != -1) return memo[depth][status];

        memo[depth][status] = 0;
        if ((status & 1) == 1) {
            memo[depth][status] = fill(depth + 1, status >> 1);
        } else {
            memo[depth][status] = fill(depth + 1, (status >> 1) | (1 << (m - 1)));
            if ((depth % m != m - 1) && (status & 2) == 0) memo[depth][status] += fill(depth + 2, status >> 2);
        }
        return memo[depth][status] %= mod;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}