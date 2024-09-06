import java.io.IOException;
import java.util.*;

public class Main {
    public static int n;
    public static List<Node>[] graph;
    public static int[] dist;
    public static int[] prev;
    public static int cnt;
    public static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        n = read();
        int m = read();

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            graph[read()].add(new Node(read(), read()));
        }

        StringBuilder sb = new StringBuilder();

        int s = read();
        int e = read();
        sb.append(dijkstra(s, e)).append('\n');

        stack = new Stack<>();
        sb.append(count(e)).append('\n');
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }

        System.out.println(sb);
    }

    public static int dijkstra(int s, int e) {
        prev = new int[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost > dist[cur.to]) continue;
            if (cur.to == e) return cur.cost;

            for (Node next : graph[cur.to]) {
                int newCost = cur.cost + next.cost;
                if (newCost >= dist[next.to]) continue;
                dist[next.to] = newCost;
                prev[next.to] = cur.to;
                pq.offer(new Node(next.to, newCost));
            }
        }

        return -1;
    }

    public static int count(int e) {
        cnt = 1;
        while (prev[e] != 0) {
            stack.push(e);
            e = prev[e];
            cnt++;
        }
        stack.push(e);
        return cnt;
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
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}