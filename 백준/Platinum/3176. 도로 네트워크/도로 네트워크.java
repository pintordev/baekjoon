import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int n;
    public static int logN;
    public static List<City>[] tree;
    public static int[][] parent;
    public static int[][] maxParent;
    public static int[][] minParent;
    public static int[] depth;
    public static int min;
    public static int max;

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
            int c = read();
            tree[a].add(new City(b, c));
            tree[b].add(new City(a, c));
        }

        parent = new int[n + 1][logN];
        minParent = new int[n + 1][logN];
        maxParent = new int[n + 1][logN];
        depth = new int[n + 1];
        dfs(1, 1);
    }

    public static void dfs(int cur, int d) {
        depth[cur] = d;
        for (City next : tree[cur]) {
            if (depth[next.to] != 0) continue;
            parent[next.to][0] = cur;
            minParent[next.to][0] = next.dist;
            maxParent[next.to][0] = next.dist;
            dfs(next.to, d + 1);
        }
    }

    public static void dp() {
        for (int j = 1; j < logN; j++) {
            for (int i = 1; i <= n; i++) {
                parent[i][j] = parent[parent[i][j - 1]][j - 1];
                minParent[i][j] = Math.min(minParent[i][j - 1], minParent[parent[i][j - 1]][j - 1]);
                maxParent[i][j] = Math.max(maxParent[i][j - 1], maxParent[parent[i][j - 1]][j - 1]);
            }
        }
    }

    public static void runQuery() throws IOException {
        StringBuilder sb = new StringBuilder();
        int k = read();
        while (k-- > 0) {
            lca(read(), read());
            sb.append(min).append(' ').append(max).append('\n');
        }
        System.out.print(sb);
    }

    public static void lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for (int i = logN - 1; i >= 0; i--) {
            if (depth[a] - depth[b] >= (1 << i)) {
                min = Math.min(min, minParent[a][i]);
                max = Math.max(max, maxParent[a][i]);
                a = parent[a][i];
            }
        }

        if (a == b) return;

        for (int i = logN - 1; i >= 0; i--) {
            if (parent[a][i] == parent[b][i]) continue;
            min = Math.min(min, Math.min(minParent[a][i], minParent[b][i]));
            max = Math.max(max, Math.max(maxParent[a][i], maxParent[b][i]));
            a = parent[a][i];
            b = parent[b][i];
        }

        min = Math.min(min, Math.min(minParent[a][0], minParent[b][0]));
        max = Math.max(max, Math.max(maxParent[a][0], maxParent[b][0]));
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class City {
    int to;
    int dist;

    public City(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }
}