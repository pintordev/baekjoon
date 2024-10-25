import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        Node[] arr = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new Node(i, read());
        }
        Arrays.sort(arr, 1, n + 1);

        SegmentTree tree = new SegmentTree(n, arr);
        System.out.println(tree.swap(n));
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
    public Node[] arr;

    public SegmentTree(int n, Node[] arr) {
        this.arr = arr;
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        tree = new long[1 << (h + 1)];
    }

    public long swap(int n) {
        long cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt += query(1, 1, n, arr[i].idx, n);
            update(1, 1, n, arr[i].idx);
        }
        return cnt;
    }

    public long query(int cur, int s, int e, int l, int r) {
        if (l > e || r < s) return 0;
        if (l <= s && e <= r) return tree[cur];
        int next = cur << 1;
        int mid = (s + e) >> 1;
        return query(next, s, mid, l, r) + query(next + 1, mid + 1, e, l, r);
    }

    public void update(int cur, int s, int e, int idx) {
        if (s == e) {
            tree[cur] = 1;
            return;
        }
        int next = cur << 1;
        int mid = (s + e) >> 1;
        if (idx <= mid) update(next, s, mid, idx);
        else update(next + 1, mid + 1, e, idx);
        tree[cur] = tree[next] + tree[next + 1];
    }
}

class Node implements Comparable<Node> {
    public int idx;
    public int val;

    public Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }

    @Override
    public int compareTo(Node o) {
        return this.val - o.val;
    }
}