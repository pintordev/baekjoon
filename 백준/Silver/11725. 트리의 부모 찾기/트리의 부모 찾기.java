import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static int n;
    public static List<Integer>[] tree;
    public static int[] parent;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        n = read();

        tree = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int a = read();
            int b = read();
            tree[a].add(b);
            tree[b].add(a);
        }

        parent = new int[n + 1];
        visited = new boolean[n + 1];
        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : tree[cur]) {
                if (visited[next]) continue;
                q.add(next);
                visited[next] = true;
                parent[next] = cur;
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