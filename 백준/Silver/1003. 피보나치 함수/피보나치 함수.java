import java.io.IOException;

class Main {

    public static int[][] dp = new int[41][2];

    public static void main(String[] args) throws IOException {

        dp[0] = new int[]{1, 0};
        dp[1] = new int[]{0, 1};

        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = read();
            fibonacci(n);
            sb.append(dp[n][0]).append(' ').append(dp[n][1]).append('\n');
        }
        System.out.println(sb);
    }

    public static void fibonacci(int n) {
        if (n < 2) return;
        if (dp[n][0] > 0 && dp[n][1] > 0) return;
        fibonacci(n - 1);
        fibonacci(n - 2);
        dp[n] = new int[]{dp[n - 1][0] + dp[n - 2][0], dp[n - 1][1] + dp[n - 2][1]};
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}