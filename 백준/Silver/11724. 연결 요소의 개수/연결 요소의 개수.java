import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static boolean[] visited;
    public static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();

        visited = new boolean[n + 1];
        graph = new List[n + 1];
        for (int i = 1; i <= n ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = read();
            int b = read();
            graph[a].add(b);
            graph[b].add(a);
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int i) {
        visited[i] = true;
        for (int next : graph[i]) {
            if (!visited[next]) {
                dfs(next);
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