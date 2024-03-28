import java.io.IOException;

class Main {

    public static int[][][] dp;

    public static void main(String[] args) throws IOException {

        dp = new int[21][21][21];
        dp[0][0][0] = 1;

        StringBuilder sb = new StringBuilder();
        while (true) {
            int a = read(), b = read(), c = read();
            if (a == -1 && b == -1 && c == -1) break;
            sb.append("w(").append(a)
                    .append(", ").append(b)
                    .append(", ").append(c)
                    .append(") = ").append(w(a, b, c))
                    .append('\n');
        }
        System.out.println(sb);
    }

    public static int w(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) return dp[0][0][0];
        if (a > 20 || b > 20 || c > 20) {
            a = 20;
            b = 20;
            c = 20;
        }

        if (dp[a][b][c] > 0) return dp[a][b][c];

        if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
        return dp[a][b][c];
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }
}