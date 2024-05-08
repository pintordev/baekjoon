import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] wine = new int[n + 3];
        for (int i = 3; i < n + 3; i++) {
            wine[i] = read();
        }

        int[] memo = new int[n + 3];
        wine[1] = memo[1];
        for (int i = 3; i < n + 3; i++) {
            memo[i] = Math.max(memo[i - 1], Math.max(memo[i - 2] + wine[i], memo[i - 3] + wine[i] + wine[i - 1]));
        }

        System.out.println(memo[n + 2]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}