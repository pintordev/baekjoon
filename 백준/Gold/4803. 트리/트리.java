import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static List<Integer>[] graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n, m, c = 0;
        while ((n = read()) != 0) {
            m = read();
            sb.append("Case ").append(++c).append(": ");

            int cnt = countTree(n, m);
            if (cnt == 0) sb.append("No trees.");
            else if (cnt == 1) sb.append("There is one tree.");
            else sb.append("A forest of ").append(cnt).append(" trees.");
            sb.append('\n');
        }
        read();
        System.out.println(sb);
    }

    public static int countTree(int n, int m) throws IOException {
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = read();
            int v = read();
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[n + 1];

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && bfs(i)) cnt++;
        }
        return cnt;
    }

    public static boolean bfs(int s) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        visited[s] = true;

        int node = 0;
        int edge = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            node++;
            visited[cur] = true;

            for (int next : graph[cur]) {
                edge++;
                if (!visited[next]) q.add(next);
            }
        }
        return edge >> 1 == node - 1;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}