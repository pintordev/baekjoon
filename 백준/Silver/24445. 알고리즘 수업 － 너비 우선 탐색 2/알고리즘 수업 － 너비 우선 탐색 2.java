import java.io.IOException;
import java.util.*;

public class Main {
    public static List<Integer>[] graph;
    public static int[] visited;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();
        int r = read();

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            int a = read();
            int b = read();
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        visited = new int[n + 1];
        cnt = 0;
        bfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(visited[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void bfs(int r) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(r);
        visited[r] = ++cnt;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (visited[next] != 0) continue;
                q.add(next);
                visited[next] = ++cnt;
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