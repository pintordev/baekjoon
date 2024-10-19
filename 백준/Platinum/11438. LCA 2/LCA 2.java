import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int n;
    public static int logN;
    public static List<Integer>[] tree;
    public static int[][] parent;
    public static int[] depth;

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
            int a = read();
            int b = read();
            tree[a].add(b);
            tree[b].add(a);
        }

        parent = new int[n + 1][logN];
        depth = new int[n + 1];
        dfs(1, 1);
    }

    public static void dfs(int cur, int d) {
        depth[cur] = d;
        for (int next : tree[cur]) {
            if (depth[next] != 0) continue;
            parent[next][0] = cur;
            dfs(next, d + 1);
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
        while (m-- > 0) {
            sb.append(lca(read(), read())).append('\n');
        }
        System.out.print(sb);
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