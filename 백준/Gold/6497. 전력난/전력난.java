import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static PriorityQueue<Edge> edges;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int m, n;
        while ((m = read()) != 0 && (n = read()) != 0) {
            sb.append(simulate(m, n)).append('\n');
        }
        System.out.println(sb);
    }

    public static int simulate(int m, int n) throws IOException {
        int cost = 0;

        edges = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = read();
            int y = read();
            int z = read();

            edges.add(new Edge(x, y, z));
            cost += z;
        }

        parent = new int[m];
        for (int i = 0; i < m; i++) {
            parent[i] = i;
        }

        return kruskal(cost);
    }

    public static int kruskal(int cost) {
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            if (find(edge.x) != find(edge.y)) {
                union(edge.x, edge.y);
                cost -= edge.z;
            }
        }
        return cost;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[x] = y;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Edge implements Comparable<Edge> {
    int x;
    int y;
    int z;

    public Edge(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int compareTo(Edge o) {
        return this.z - o.z;
    }
}