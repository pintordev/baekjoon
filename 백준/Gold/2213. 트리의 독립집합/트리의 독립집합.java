import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static int[] weight;
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static int[][] memo;
    public static PriorityQueue<Integer> elements;

    public static void main(String[] args) throws IOException {
        int n = read();

        weight = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            weight[i] = read();
        }

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int u = read();
            int v = read();
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[n + 1];
        memo = new int[n + 1][2];
        measure(1);

        elements = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        if (memo[1][0] > memo[1][1]) {
            sb.append(memo[1][0]).append('\n');
            trace(1, 0);
        } else {
            sb.append(memo[1][1]).append('\n');
            trace(1, 1);
        }
        while (!elements.isEmpty()) {
            sb.append(elements.poll()).append(' ');
        }
        System.out.println(sb);
    }

    public static void measure(int node) {
        visited[node] = true;

        memo[node][0] = 0;
        memo[node][1] = weight[node];

        for (int next : graph[node]) {
            if (visited[next]) continue;
            measure(next);
            memo[node][0] += Math.max(memo[next][0], memo[next][1]);
            memo[node][1] += memo[next][0];
        }

        visited[node] = false;
    }

    public static void trace(int node, int state) {
        visited[node] = true;

        if (state == 1) {
            elements.add(node);
            for (int next : graph[node]) {
                if (visited[next]) continue;
                trace(next, 0);
            }
        } else {
            for (int next : graph[node]) {
                if (visited[next]) continue;
                if (memo[next][0] > memo[next][1]) trace(next, 0);
                else trace(next, 1);
            }
        }

        visited[node] = false;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}