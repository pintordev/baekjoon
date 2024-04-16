import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static int n;
    public static int c;
    public static List<Node>[] graph;
    public static int[] dist;

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = read();
        while (t-- > 0) {
            init();
            dijkstra();
        }
        System.out.println(sb);
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(c, 0));
        dist[c] = 0;

        int cnt = 0;
        int time = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.time > dist[now.end]) {
                continue;
            }
            cnt++;
            time = Math.max(time, now.time);

            for (Node next : graph[now.end]) {
                if (dist[next.end] <= now.time + next.time) {
                    continue;
                }
                dist[next.end] = now.time + next.time;
                pq.add(new Node(next.end, dist[next.end]));
            }
        }

        sb.append(cnt).append(' ').append(time).append('\n');
    }

    public static void init() throws IOException {
        n = read();
        int d = read();
        c = read();

        graph = new List[n + 1];
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        while (d-- > 0) {
            int a = read();
            int b = read();
            int s = read();
            graph[b].add(new Node(a, s));
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