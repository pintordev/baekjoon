import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int n;
    public static int logN;
    public static List<Node>[] tree;
    public static int[][] parent;
    public static int[] depth;
    public static long[] cost;

    public static void main(String[] args) throws IOException {
        n = read();
        logN = (int) (Math.log(n) / Math.log(2)) + 1;

        setTree();
        dp();
        runQuery();
    }

    public static void setTree() throws IOException {
        tree = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int u = read();
            int v = read();
            int w = read();
            tree[u].add(new Node(v, w));
            tree[v].add(new Node(u, w));
        }

        parent = new int[n + 1][logN];
        depth = new int[n + 1];
        cost = new long[n + 1];
        dfs(1, 1);
    }

    public static void dfs(int cur, int d) {
        depth[cur] = d;
        for (Node next : tree[cur]) {
            if (depth[next.to] != 0) continue;
            parent[next.to][0] = cur;
            cost[next.to] = cost[cur] + next.cost;
            dfs(next.to, d + 1);
        }
    }

    public static void dp() {
        for (int j = 1; j < logN; j++) {
            for (int i = 1; i <= n; i++) {
                parent[i][j] = parent[parent[i][j - 1]][j - 1];
            }
        }
    }

    public static void runQuery() throws IOException {
        StringBuilder sb = new StringBuilder();
        int m = read();
        while(m-- > 0) {
            int cmd = read();
            if (cmd == 1) sb.append(getCost(read(), read())).append('\n');
            else sb.append(getKthNode(read(), read(), read())).append('\n');
        }
        System.out.println(sb);
    }

    public static long getCost(int u, int v) {
        int rt = lca(u, v);
        return cost[u] + cost[v] - cost[rt] * 2;
    }

    public static int getKthNode(int u, int v, int k) {
        int rt = lca(u, v);

        int rtNode = depth[u] - depth[rt] + 1;
        if (rtNode == k) return rt;

        int kthNode;
        if (rtNode > k) {
            kthNode = u;
            k--;
        } else {
            kthNode = v;
            k = rtNode + depth[v] - depth[rt] - k;
        }

        for (int i = logN - 1; i >= 0; i--) {
            if ((k & (1 << i)) != 0) kthNode = parent[kthNode][i];
        }
        return kthNode;
    }

    public static int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = logN - 1; i >= 0; i--) {
            if (depth[a] - depth[b] >= (1 << i)) a = parent[a][i];
        }

        if (a == b) return a;

        for (int i = logN - 1; i >= 0; i--) {
            if (parent[a][i] == parent[b][i]) continue;
            a = parent[a][i];
            b = parent[b][i];
        }

        return parent[a][0];
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Node {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}