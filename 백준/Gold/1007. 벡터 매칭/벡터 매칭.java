import java.io.IOException;

public class Main {
    public static int n;
    public static Node[] nodes;
    public static double min;

    public static void main(String[] args) throws IOException {
        int t = read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            n = read();

            int x = 0;
            int y = 0;
            nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(read(), read());
                x += nodes[i].x;
                y += nodes[i].y;
            }

            min = Double.MAX_VALUE;
            comb(0, n >> 1, x, y);
            sb.append(min).append('\n');

        }
        System.out.println(sb);
    }

    public static void comb(int prev, int cnt, int x, int y) {
        if (cnt == 0) {
            min = Math.min(min, Math.sqrt((double) x * x + (double) y * y));
            return;
        }

        for (int i = prev; i < n; i++) {
            comb(i + 1, cnt - 1, x - nodes[i].x * 2, y - nodes[i].y * 2);
        }
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}