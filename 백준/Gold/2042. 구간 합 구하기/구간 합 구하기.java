import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int limit = read() + read();

        long[] arr = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = readL();
        }

        SegmentTree tree = new SegmentTree(n, arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < limit; i++) {
            int a = read();
            int b = read();
            if (a == 1) {
                long c = readL();
                tree.update(1, 1, n, b, c - tree.arr[b]);
                tree.arr[b] = c;
            } else {
                int c = read();
                sb.append(tree.sum(1, 1, n, b, c)).append('\n');
            }
        }
        System.out.println(sb);
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

    public static long readL() throws IOException {
        long c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }
}

class SegmentTree {
    public long[] tree;
    public long[] arr;

    public SegmentTree(int n, long[] arr) {
        this.arr = arr;
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        tree = new long[(int) Math.pow(2, h + 1)];
        init(1, 1, n);
    }

    public long init(int cur, int s, int e) {
        if (s == e) return tree[cur] = arr[s];
        int next = cur << 1;
        int mdx = (s + e) >> 1;
        return tree[cur] = init(next, s, mdx) + init(next + 1, mdx + 1, e);
    }

    public void update(int cur, int s, int e, int idx, long diff) {
        if (idx < s || idx > e) return;
        tree[cur] += diff;
        if (s == e) return;
        int next = cur << 1;
        int mdx = (s + e) >> 1;
        update(next, s, mdx, idx, diff);
        update(next + 1, mdx + 1, e, idx, diff);
    }

    public long sum(int cur, int s, int e, int l, int r) {
        if (l > e || r < s) return 0;
        if (l <= s && e <= r) return tree[cur];
        int next = cur << 1;
        int mdx = (s + e) >> 1;
        return sum(next, s, mdx, l, r) + sum(next + 1, mdx + 1, e, l, r);
    }
}