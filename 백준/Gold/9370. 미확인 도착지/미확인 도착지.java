import java.io.IOException;
import java.util.*;

public class Main {
    public static StringBuilder sb;
    public static int INF = 50_000_000;
    public static List<Node>[] graph;
    public static int[] dist;

    public static void main(String[] args) throws IOException {
        int t = read();

        sb = new StringBuilder();
        while (t-- > 0) {
            simulate();
        }
        System.out.println(sb);
    }

    public static void simulate() throws IOException {
        int n = read();
        int m = read();
        int t = read();

        int s = read();
        int g = read();
        int h = read();

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            int a = read();
            int b = read();
            int d = read() << 1;
            if ((a == g && b == h) || (a == h && b == g)) d--;
            graph[a].add(new Node(b, d));
            graph[b].add(new Node(a, d));
        }

        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dijkstra(s);

        Set<Integer> dest = new TreeSet<>();
        while (t-- > 0) {
            int x = read();
            if (dist[x] % 2 == 1) dest.add(x);
        }
        for (int x : dest) {
            sb.append(x).append(' ');
        }
        sb.append('\n');
    }

    public static void dijkstra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dist[s] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x;
            int d = cur.d;

            if (dist[x] < d) continue;

            for (Node next : graph[x]) {
                int nx = next.x;
                int nd = d + next.d;

                if (dist[nx] <= nd) continue;

                dist[nx] = nd;
                pq.add(new Node(nx, nd));
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
    int x;
    int d;

    public Node(int x, int d) {
        this.x = x;
        this.d = d;
    }

    @Override
    public int compareTo(Node o) {
        return this.d - o.d;
    }
}