import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static List<Node>[] graph;
    public static int[] dist;

    public static void main(String[] args) throws IOException {
        int v = read();
        int e = read();
        int k = read();

        graph = new List[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }
        while(e-- > 0) {
            graph[read()].add(new Node(read(), read()));
        }

        dist = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dijkstra(k);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void dijkstra(int k) {
        dist[k] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int cv = cur.v;
            int cw = cur.w;

            if (dist[cv] < cw) continue;

            for (Node next : graph[cv]) {
                int nw = cw + next.w;
                if (dist[next.v] <= nw) continue;
                dist[next.v] = nw;
                pq.add(new Node(next.v, nw));
            }
        }
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Node implements Comparable<Node> {
    int v;
    int w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}