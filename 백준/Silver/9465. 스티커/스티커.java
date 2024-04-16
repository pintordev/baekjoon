import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int t = read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = read();

            int[][] sticker = new int[2][n];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    sticker[i][j] = read();
                }
            }

            if (n == 1) {
                sb.append(Math.max(sticker[0][0], sticker[1][0])).append('\n');
                continue;
            }

            int[][] memo = new int[2][n];
            memo[0][0] = sticker[0][0];
            memo[1][0] = sticker[1][0];
            memo[0][1] = memo[1][0] + sticker[0][1];
            memo[1][1] = memo[0][0] + sticker[1][1];
            for (int i = 2; i < n; i++) {
                memo[0][i] = Math.max(memo[1][i - 2], memo[1][i - 1]) + sticker[0][i];
                memo[1][i] = Math.max(memo[0][i - 2], memo[0][i - 1]) + sticker[1][i];
            }
            sb.append(Math.max(memo[0][n - 1], memo[1][n - 1])).append('\n');
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