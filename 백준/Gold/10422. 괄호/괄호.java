import java.io.IOException;

public class Main {
    public static int mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        long[] memo = new long[5001];
        memo[0] = 1;
        memo[2] = 1;
        for (int i = 4; i <= 5000; i += 2) {
            for (int j = 0; j < i; j += 2) {
                memo[i] += memo[j] * memo[i - j - 2];
                memo[i] %= mod;
            }
        }

        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(memo[read()]).append('\n');
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