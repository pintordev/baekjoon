import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int limit = read() + read();

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = read();
        }

        SegmentTree tree = new SegmentTree(n, arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < limit; i++) {
            int a = read();
            int b = read();
            int c = read();
            if (a == 1) {
                tree.arr[b] = c;
                tree.update(1, 1, n, b, c);
            } else {
                sb.append(tree.times(1, 1, n, b, c)).append('\n');
            }
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

class SegmentTree {
    public long[] tree;
    public int[] arr;
    public int mod = 1_000_000_007;

    public SegmentTree(int n, int[] arr) {
        this.arr = arr;
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        tree = new long[(int) Math.pow(2, h + 1)];
        init(1, 1, n);
    }

    public long init(int cur, int s, int e) {
        if (s == e) return tree[cur] = arr[s];
        int next = cur << 1;
        int mdx = (s + e) >> 1;
        return tree[cur] = (init(next, s, mdx) * init(next + 1, mdx + 1, e)) % mod;
    }

    public long update(int cur, int s, int e, int idx, long diff) {
        if (idx < s || idx > e) return tree[cur];
        if (s == e) return tree[cur] = diff;
        int next = cur << 1;
        int mdx = (s + e) >> 1;
        return tree[cur] = (update(next, s, mdx, idx, diff) * update(next + 1, mdx + 1, e, idx, diff)) % mod;
    }

    public long times(int cur, int s, int e, int l, int r) {
        if (l > e || r < s) return 1;
        if (l <= s && e <= r) return tree[cur];
        int next = cur << 1;
        int mdx = (s + e) >> 1;
        return (times(next, s, mdx, l, r) * times(next + 1, mdx + 1, e, l, r)) % mod;
    }
}