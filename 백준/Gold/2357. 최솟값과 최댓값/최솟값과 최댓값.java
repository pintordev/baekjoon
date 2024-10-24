import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = read();
        }

        SegmentTree tree = new SegmentTree(n, arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int a = read();
            int b = read();
            sb.append(tree.query(0, 1, 1, n, a, b)).append(' ')
                    .append(tree.query(1, 1, 1, n, a, b)).append('\n');
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
    public static int ul = 1_000_000_000;
    public static int ll = 0;

    public int[] min;
    public int[] max;
    public int[] arr;

    public SegmentTree(int n, int[] arr) {
        this.arr = arr;
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        min = new int[1 << (h + 1)];
        max = new int[1 << (h + 1)];
        init(0,1, 1, n);
        init(1, 1, 1, n);
    }

    public int init(int type, int cur, int s, int e) {
        if (s == e) {
            if (type == 0) return min[cur] = arr[s];
            else return max[cur] = arr[s];
        }
        int next = cur << 1;
        int mid = (s + e) >> 1;
        if (type == 0) return min[cur] = Math.min(init(type, next, s, mid), init(type, next + 1, mid + 1, e));
        else return max[cur] = Math.max(init(type, next, s, mid), init(type, next + 1, mid + 1, e));
    }

    public int query(int type, int cur, int s, int e, int l, int r) {
        if (e < l || r < s) {
            if (type == 0) return ul;
            else return ll;
        }
        if (l <= s && e <= r) {
            if (type == 0) return min[cur];
            else return max[cur];
        }
        int next = cur << 1;
        int mid = (s + e) >> 1;
        if (type == 0) return Math.min(query(type, next, s, mid, l, r), query(type, next + 1, mid + 1, e, l, r));
        else return Math.max(query(type, next, s, mid, l, r), query(type, next + 1, mid + 1, e, l, r));
    }
}