import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        long[] memo = new long[31];
        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 2;

        for (int i = 3; i < 31; i++) {
            long cnt = 0;
            for (int j = 0; j < i; j++) {
                cnt += memo[j] * memo[i - j - 1];
            }
            memo[i] = cnt;
        }

        StringBuilder sb = new StringBuilder();
        int n;
        while ((n = read()) != 0) {
            sb.append(memo[n]).append('\n');
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