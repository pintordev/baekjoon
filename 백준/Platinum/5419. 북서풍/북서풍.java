import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int MIN = -1_000_000_000;
    public static int[] tree;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int t = read();
        while (t-- > 0) {
            int n = read();

            List<Node> nodes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nodes.add(new Node(read(), read()));
            }

            nodes.sort(Node::compareY);
            int idx = 1;
            int prev = nodes.get(0).y;
            for (Node node : nodes) {
                if (node.y == prev) {
                    node.y = idx;
                } else {
                    prev = node.y;
                    node.y = ++idx;
                }
            }

            nodes.sort(Node::compareX);

            int h = (int) Math.ceil(Math.log(idx) / Math.log(2));
            tree = new int[1 << (h + 1)];
            long cnt = 0;
            for (Node node : nodes) {
                cnt += query(1, 1, idx, 1, node.y);
                update(1, 1, idx, node.y);
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }

    public static int query(int cur, int s, int e, int l, int r) {
        if (l > e || r < s) return 0;
        if (l <= s && e <= r) return tree[cur];
        int next = cur << 1;
        int mid = (s + e) >> 1;
        return query(next, s, mid, l, r) + query(next + 1, mid + 1, e, l, r);
    }

    public static void update(int cur, int s, int e, int idx) {
        if (idx < s || idx > e) return;
        tree[cur]++;
        if (s == e) return;
        int next = cur << 1;
        int mid = (s + e) >> 1;
        update(next, s, mid, idx);
        update(next + 1, mid + 1, e, idx);
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

    public int compareY(Node o) {
        return o.y - this.y;
    }

    public int compareX(Node o) {
        if (this.x == o.x) return this.y - o.y;
        return this.x - o.x;
    }
}