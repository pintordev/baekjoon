import java.io.IOException;
import java.util.*;

public class Main {
    public static int v;
    public static int e;
    public static List<Integer>[] graph;
    public static int[] visited;

    public static void main(String[] args) throws IOException {
        int k = read();

        StringBuilder sb = new StringBuilder();
        while (k-- > 0) {
            v = read();
            e = read();
            sb.append(simulate()).append('\n');
        }
        System.out.println(sb);
    }

    public static String simulate() throws IOException {
        graph = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int a = read();
            int b = read();
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new int[v + 1];
        if (bfs(1)) return "YES";
        return "NO";
    }

    public static boolean bfs(int s) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= v; i++) {
            if (visited[i] == 0) {
                q.add(i);
                visited[i] = 1;
            }

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int next : graph[cur]) {
                    if (visited[next] == 0) {
                        visited[next] = visited[cur] * -1;
                        q.add(next);
                    } else if (visited[next] == visited[cur]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}