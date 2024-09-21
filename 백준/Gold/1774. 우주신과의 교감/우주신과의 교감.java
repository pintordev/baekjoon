import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static PriorityQueue<Edge> edges;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();

        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i, read(), read());
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            union(read(), read());
        }

        edges = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                edges.add(new Edge(i, j, calLength(nodes[i], nodes[j])));
            }
        }

        kruskal();
    }

    public static double calLength(Node a, Node b) {
        return Math.sqrt(Math.pow(a.r - b.r, 2) + Math.pow(a.c - b.c, 2));
    }

    public static void kruskal() {
        double sum = 0;
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            if (find(edge.f) == find(edge.t)) continue;
            union(edge.f, edge.t);
            sum += edge.w;
        }
        System.out.println(String.format("%.2f", sum));
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
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Node {
    int idx;
    int r;
    int c;

    public Node(int idx, int r, int c) {
        this.idx = idx;
        this.r = r;
        this.c = c;
    }
}

class Edge implements Comparable<Edge> {
    int f;
    int t;
    double w;

    public Edge(int f, int t, double w) {
        this.f = f;
        this.t = t;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w > o.w ? 1 : -1;
    }
}