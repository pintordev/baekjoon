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
            sb.append(tree.min(1, 1, n, a, b)).append(' ')
                    .append(tree.max(1, 1, n, a, b)).append('\n');
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

    public int[] minTree;
    public int[] maxTree;
    public int[] arr;

    public SegmentTree(int n, int[] arr) {
        this.arr = arr;
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        minTree = new int[1 << (h + 1)];
        minInit(1, 1, n);
        maxTree = new int[1 << (h + 1)];
        maxInit(1, 1, n);
    }

    public int minInit(int cur, int s, int e) {
        if (s == e) return minTree[cur] = arr[s];
        int next = cur << 1;
        int mid = (s + e) >> 1;
        return minTree[cur] = Math.min(minInit(next, s, mid), minInit(next + 1, mid + 1, e));
    }

    public int maxInit(int cur, int s, int e) {
        if (s == e) return maxTree[cur] = arr[s];
        int next = cur << 1;
        int mid = (s + e) >> 1;
        return maxTree[cur] = Math.max(maxInit(next, s, mid), maxInit(next + 1, mid + 1, e));
    }

    public int min(int cur, int s, int e, int l, int r) {
        if (e < l || r < s) return ul;
        if (l <= s && e <= r) return minTree[cur];
        int next = cur << 1;
        int mid = (s + e) >> 1;
        return Math.min(min(next, s, mid, l, r), min(next + 1, mid + 1, e, l, r));
    }

    public int max(int cur, int s, int e, int l, int r) {
        if (e < l || r < s) return ll;
        if (l <= s && e <= r) return maxTree[cur];
        int next = cur << 1;
        int mid = (s + e) >> 1;
        return Math.max(max(next, s, mid, l, r), max(next + 1, mid + 1, e, l, r));
    }
}