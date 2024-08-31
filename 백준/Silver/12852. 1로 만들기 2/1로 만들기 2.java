import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[][] memo = new int[n + 1][2];
        for (int i = 2; i <= n; i++) {
            memo[i][0] = memo[i - 1][0] + 1;
            memo[i][1] = i - 1;

            if (i % 2 == 0 && memo[i][0] > memo[i / 2][0] + 1) {
                memo[i][0] = memo[i / 2][0] + 1;
                memo[i][1] = i / 2;
            }

            if (i % 3 == 0 && memo[i][0] > memo[i / 3][0] + 1) {
                memo[i][0] = memo[i / 3][0] + 1;
                memo[i][1] = i / 3;
            }
        }

        StringBuilder sb = new StringBuilder()
                .append(memo[n][0]).append('\n');
        while (n > 0) {
            sb.append(n).append(' ');
            n = memo[n][1];
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