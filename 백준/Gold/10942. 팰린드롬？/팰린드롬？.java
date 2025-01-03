import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int[] arr;
    public static int[][] memo;

    public static void main(String[] args) throws IOException {
        int n = read();

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = read();
        }

        memo = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }

        StringBuilder sb = new StringBuilder();
        int m = read();
        while (m-- > 0) {
            sb.append(check(read(), read())).append('\n');
        }
        System.out.println(sb);
    }

    public static int check(int s, int e) {
        if (s >= e) return 1;
        if (memo[s][e] != -1) return memo[s][e];
        if (arr[s] != arr[e]) return memo[s][e] = 0;
        return memo[s][e] = check(s + 1, e - 1);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}