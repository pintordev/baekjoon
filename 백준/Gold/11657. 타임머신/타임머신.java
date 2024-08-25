import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int INF = Integer.MAX_VALUE;
    public static int n;
    public static Edge[] edges;
    public static long[] dist;

    public static void main(String[] args) throws IOException {
        n = read();
        int m = read();

        edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(read(), read(), read());
        }

        dist = new long[n + 1];
        Arrays.fill(dist, INF);

        if (!bellmanFord()) System.out.println(-1);
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= n; i++) {
                sb.append(dist[i] == INF ? -1 : dist[i]).append('\n');
            }
            System.out.println(sb);
        }
    }

    public static boolean bellmanFord() {
        dist[1] = 0;

        for (int i = 1; i <= n; i++) {
            for (Edge edge : edges) {
                int s = edge.s;
                int e = edge.e;
                int w = edge.w;

                if (dist[s] == INF) continue;
                if (dist[e] <= dist[s] + w) continue;

                dist[e] = dist[s] + w;
                if (i == n) return false;
            }
        }

        return true;
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

class Edge {
    int s;
    int e;
    int w;

    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }
}