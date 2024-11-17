import java.io.IOException;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        find(0, read());
        System.out.println(sb);
    }

    public static void find(int now, int depth) {
        if (depth == 0) {
            sb.append(now).append('\n');
            return;
        }

        for (int i = 0; i < 10; i++) {
            int next = (now << 3) + (now << 1) + i;
            if (!isPrime(next)) continue;
            find(next, depth - 1);
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}