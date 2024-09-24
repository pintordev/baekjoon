import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer>[] graph;
    public static int[] sub;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int n = read();
        int r = read();
        int q = read();

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

        sub = new int[n + 1];
        visited = new boolean[n + 1];
        dfs(r);

        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            sb.append(sub[read()]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int cur) {
        visited[cur] = true;
        sub[cur] = 1;
        for (int next : graph[cur]) {
            if (visited[next]) continue;
            dfs(next);
            sub[cur] += sub[next];
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