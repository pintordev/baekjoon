import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int[][] memo = new int[10001][4];
        memo[1][1] = 1;
        memo[2][1] = 1;
        memo[2][2] = 1;
        memo[3][1] = 1;
        memo[3][2] = 1;
        memo[3][3] = 1;

        for (int i = 4; i <= 10000; i++) {
            memo[i][1] = memo[i - 1][1];
            memo[i][2] = memo[i - 2][1] + memo[i - 2][2];
            memo[i][3] = memo[i - 3][1] + memo[i - 3][2] + memo[i - 3][3];
        }

        int t = read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = read();
            sb.append(memo[n][1] + memo[n][2] + memo[n][3]).append('\n');
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