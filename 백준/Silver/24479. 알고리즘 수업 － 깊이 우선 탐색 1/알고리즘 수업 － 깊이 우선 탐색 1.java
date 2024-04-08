import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {

    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static int[] order;
    public static int vdx = 0;

    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();
        int r = read();

        graph = new List[n + 1];
        visited = new boolean[n + 1];
        order = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = read();
            int b = read();
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(order[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void dfs(int r) {
        visited[r] = true;
        order[r] = ++vdx;
        for (int i : graph[r]) {
            if (!visited[i]) {
                dfs(i);
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