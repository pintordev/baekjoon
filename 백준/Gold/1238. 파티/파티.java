import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static int n;
    public static int x;
    public static List<Node>[] fGraph;
    public static List<Node>[] rGraph;
    public static int[] fDist;
    public static int[] rDist;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();
        dijkstra(fGraph, fDist);
        dijkstra(rGraph, rDist);
        findMax();
    }

    public static void dijkstra(List<Node>[] graph, int[] dist) {
        visited = new boolean[n + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, 0));
        dist[x] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.end]) {
                continue;
            }
            visited[now.end] = true;

            for (Node next : graph[now.end]) {
                if (visited[next.end] || dist[next.end] <= dist[now.end] + next.time) {
                    continue;
                }
                dist[next.end] = dist[now.end] + next.time;
                pq.add(new Node(next.end, dist[next.end]));
            }
        }
    }

    public static void findMax() {
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, fDist[i] + rDist[i]);
        }
        System.out.println(max);
    }

    public static void init() throws IOException {
        n = read();
        int m = read();
        x = read();

        fGraph = new List[n + 1];
        rGraph = new List[n + 1];
        fDist = new int[n + 1];
        rDist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            fGraph[i] = new ArrayList<>();
            rGraph[i] = new ArrayList<>();
            fDist[i] = Integer.MAX_VALUE;
            rDist[i] = Integer.MAX_VALUE;
        }

        while (m-- > 0) {
            int start = read();
            int end = read();
            int time = read();
            fGraph[start].add(new Node(end, time));
            rGraph[end].add(new Node(start, time));
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
    int end;
    int time;

    public Node(int end, int time) {
        this.end = end;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return this.time - o.time;
    }
}