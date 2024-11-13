import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int t = read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(simulate(read(), read())).append('\n');
        }
        System.out.println(sb);
    }

    public static int simulate(int x, int y) {
        int dist = y - x;
        int n = (int) Math.sqrt(dist);
        if (n == Math.sqrt(dist)) return 2 * n - 1;
        if (dist <= n * n + n) return 2 * n;
        return 2 * n + 1;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}