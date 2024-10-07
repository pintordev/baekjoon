import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int INF = 16 * 1000000;
    public static int n;
    public static int[][] map;
    public static int[][] memo;

    public static void main(String[] args) throws IOException {
        n = read();

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = read();
            }
        }

        memo = new int[n][(1 << n) - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(tsp(0, 1));
    }

    public static int tsp(int depth, int status) {
        if (status == (1 << n) - 1) {
            return map[depth][0] == 0 ? INF : map[depth][0];
        }

        if (memo[depth][status] != -1) return memo[depth][status];

        int min = INF;
        for (int i = 0; i < n; i++) {
            if ((status & (1 << i)) == 0 && map[depth][i] != 0) {
                min = Math.min(min, tsp(i, status | (1 << i)) + map[depth][i]);
            }
        }

        return memo[depth][status] = min;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}