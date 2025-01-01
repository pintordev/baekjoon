import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = read();
            }
        }

        int[][][] memo = new int[n][n][3];
        memo[0][1][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 2; j < n; j++) {
                if (i >= 1 && map[i][j] == 0) memo[i][j][1] = memo[i - 1][j][1] + memo[i - 1][j][2];
                if (j >= 1 && map[i][j] == 0) memo[i][j][0] = memo[i][j - 1][0] + memo[i][j - 1][2];
                if (i >= 1 && j >= 1 && map[i][j] == 0 && map[i - 1][j] == 0 && map[i][j - 1] == 0) memo[i][j][2] = memo[i - 1][j - 1][0] + memo[i - 1][j - 1][1] + memo[i - 1][j - 1][2];
            }
        }
        System.out.println(memo[n - 1][n - 1][0] + memo[n - 1][n - 1][1] + memo[n - 1][n - 1][2]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}