import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        dfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(visited[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void dfs(int r) {
        visited[r] = ++cnt;
        for (int next : graph[r]) {
            if (visited[next] == 0) dfs(next);
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