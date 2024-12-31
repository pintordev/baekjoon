import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read(), k = read();

        int[] coin = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            coin[i] = read();
        }

        int[] memo = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            memo[i] = 100000;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                memo[j] = Math.min(memo[j], memo[j - coin[i]] + 1);
            }
        }

        if (memo[k] == 100000) System.out.println(-1);
        else System.out.println(memo[k]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}