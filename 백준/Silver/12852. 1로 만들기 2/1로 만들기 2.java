import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] memo = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + 1;
            if (i % 2 == 0) memo[i] = Math.min(memo[i], memo[i / 2] + 1);
            if (i % 3 == 0) memo[i] = Math.min(memo[i], memo[i / 3] + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(memo[n]).append('\n');
        while (n > 0) {
            sb.append(n).append(' ');
            if (n % 3 == 0 && memo[n] == memo[n / 3] + 1) n /= 3;
            else if (n % 2 == 0 && memo[n] == memo[n / 2] + 1) n /= 2;
            else n--;
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