import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static Edge[] edges;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        int v = read();
        int e = read();

        edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge(read(), read(), read());
        }
        Arrays.sort(edges);

        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        kruskal();
    }

    public static void kruskal() {
        int sum = 0;
        for (Edge edge : edges) {
            if (find(edge.f) == find(edge.t)) continue;
            union(edge.f, edge.t);
            sum += edge.w;
        }
        System.out.println(sum);
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x > y) parent[x] = y;
        else parent[y] = x;
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

class Edge implements Comparable<Edge> {
    int f;
    int t;
    int w;

    public Edge(int f, int t, int w) {
        this.f = f;
        this.t = t;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}