import java.io.IOException;

public class Main {
    public static int logN = (int) (Math.log(500000) / Math.log(2)) + 1;

    public static void main(String[] args) throws IOException {
        int m = read();

        int[][] memo = new int[logN + 1][m + 1];
        for (int i = 1; i <= m; i++) {
            memo[0][i] = read();
        }

        for (int i = 1; i <= logN; i++) {
            for (int j = 1; j <= m; j++) {
                memo[i][j] = memo[i - 1][memo[i - 1][j]];
            }
        }

        StringBuilder sb = new StringBuilder();
        int q = read();
        while (q-- > 0) {
            int n = read();
            int x = read();
            for (int i = 0; i <= logN; i++) {
                if ((n & (1 << i)) > 0) x = memo[i][x];
            }
            sb.append(x).append('\n');
        }
        System.out.print(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}