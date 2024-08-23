import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int k = read();

        System.out.println(dijkstra(n, k));
    }

    public static int dijkstra(int n, int k) {
        int[] time = new int[100_001];
        Arrays.fill(time, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(n, 0));
        time[n] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.x == k) return cur.t;

            int[] nx = {cur.x * 2, cur.x - 1, cur.x + 1};
            int[] nt = {cur.t, cur.t + 1, cur.t + 1};
            for (int i = 0; i < 3; i++) {
                if (!check(nx[i])) continue;
                if (time[nx[i]] <= nt[i]) continue;
                time[nx[i]] = nt[i];
                pq.add(new Node(nx[i], nt[i]));
            }
        }

        return -1;
    }

    public static boolean check(int nx) {
        return nx >= 0 && nx <= 100000;
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
    int t;

    public Node(int x, int t) {
        this.x = x;
        this.t = t;
    }

    @Override
    public int compareTo(Node o) {
        return this.t - o.t;
    }
}