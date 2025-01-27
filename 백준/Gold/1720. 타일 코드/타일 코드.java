import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        long[][] memo = new long[2][31];
        memo[0][0] = memo[0][1] = 1;
        memo[0][2] = 3;
        for (int i = 3; i <= n; i++) {
            memo[0][i] = memo[0][i - 1] + (memo[0][i - 2] << 1);

            if ((i & 1) == 0) memo[1][i] = (memo[0][i] + memo[0][i >> 1] + (memo[0][(i >> 1) - 1] << 1))>> 1;
            else memo[1][i] = (memo[0][i] + memo[0][i >> 1]) >> 1;
        }

        System.out.println(n < 3 ? memo[0][n] : memo[1][n]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}