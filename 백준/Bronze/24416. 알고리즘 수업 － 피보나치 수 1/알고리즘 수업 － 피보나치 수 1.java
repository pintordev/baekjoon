import java.io.IOException;

class Main {

    public static int fib = 1;
    public static int fibonacci = 0;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        int n = read();
        fib(n);
        dp = new int[n + 1];
        dp[1] = 1; dp[2] = 1;
        fibonacci(n);
        StringBuilder sb = new StringBuilder();
        sb.append(fib).append(' ').append(fibonacci);
        System.out.println(sb);
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) return 1;
        else {
            fib++;
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int fibonacci(int n) {
        if (n < 3) return dp[n];
        for (int i = 3; i <= n; i++) {
            fibonacci++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}