import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer>[] tree;
    public static int[] parent;
    public static int[] depth;

    public static void main(String[] args) throws IOException {
        int t = read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            setTree(read());
            sb.append(lca(read(), read())).append('\n');
        }
        System.out.println(sb);
    }

    public static void setTree(int n) throws IOException {
        tree = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        boolean[] isChild = new boolean[n + 1];
        for (int i = 1; i < n; i++) {
            int a = read();
            int b = read();
            tree[a].add(b);
            isChild[b] = true;
        }

        parent = new int[n + 1];
        depth = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (isChild[i]) continue;
            dfs(i, 1);
            break;
        }
    }

    public static void dfs(int cur, int d) {
        depth[cur] = d;
        for (int next : tree[cur]) {
            if (depth[next] != 0) continue;
            parent[next] = cur;
            dfs(next, d + 1);
        }
    }

    public static int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (depth[a] != depth[b]) {
            a = parent[a];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}