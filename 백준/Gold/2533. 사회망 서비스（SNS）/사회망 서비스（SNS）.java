import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static int[][] memo;

    public static void main(String[] args) throws IOException {
        int n = read();

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
        count(1);
        System.out.println(Math.min(memo[1][0], memo[1][1]));
    }

    public static void count(int node) {
        visited[node] = true;

        memo[node][0] = 1;

        for (int next : graph[node]) {
            if (visited[next]) continue;
            count(next);
            memo[node][0] += Math.min(memo[next][0], memo[next][1]);
            memo[node][1] += memo[next][0];
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