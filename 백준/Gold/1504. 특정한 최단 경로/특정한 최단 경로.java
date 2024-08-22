import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static int INF = Integer.MAX_VALUE;
    public static List<Node>[] graph;
    public static int[] dist;

    public static void main(String[] args) throws IOException {
        int n = read();
        int e = read();

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        while (e-- > 0) {
            int a = read();
            int b = read();
            int c = read();
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        int u = read();
        int v = read();
        dist = new int[n + 1];
        System.out.println(Math.min(simulate(u, v, n), simulate(v, u, n)));
    }

    public static int simulate(int i, int j, int k) {
        int min = 0;
        int[] nodes = {1, i, j, k};
        for (int l = 0; l < 3; l++) {
            dijkstra(nodes[l]);
            if (dist[nodes[l + 1]] == INF) return -1;
            min += dist[nodes[l + 1]];
        }
        return min;
    }

    public static void dijkstra(int from) {
        Arrays.fill(dist, INF);
        dist[from] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(from, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int ct = cur.to;
            int cd = cur.dist;

            if (dist[ct] < cd) continue;

            for (Node next : graph[ct]) {
                int nd = cd + next.dist;
                if (dist[next.to] <= nd) continue;
                dist[next.to] = nd;
                pq.add(new Node(next.to, nd));
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
    int to;
    int dist;

    public Node(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return this.dist - o.dist;
    }
}