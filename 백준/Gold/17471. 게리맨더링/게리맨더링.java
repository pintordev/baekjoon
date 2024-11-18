import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static int n;
    public static int[] population;
    public static List<Integer>[] graph;
    public static int min = Integer.MAX_VALUE;
    public static boolean[] selected;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        n = read();

        population = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            population[i] = read();
        }

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();

            int m = read();
            while (m-- > 0) {
                graph[i].add(read());
            }
        }

        selected = new boolean[n + 1];
        for (int i = 1; i <= (n >> 1); i++) {
            divide(1, 0, i);
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void divide(int s, int depth, int limit) {
        if (depth == limit) {
            if (isConnected()) min = Math.min(min, getDiff());
            return;
        }

        for (int i = s; i <= n; i++) {
            selected[i] = true;
            divide(i + 1, depth + 1, limit);
            selected[i] = false;
        }
    }

    public static boolean isConnected() {
        visited = new boolean[n + 1];

        bfs(1, selected[1]);
        for (int i = 2; i <= n; i++) {
            if (visited[i]) continue;
            bfs(i, selected[i]);
            break;
        }

        for (int i = 2; i <= n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }

    public static void bfs(int idx, boolean flag) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(idx);
        visited[idx] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (visited[next] || (selected[next] ^ flag)) continue;
                q.add(next);
                visited[next] = true;
            }
        }
    }

    public static int getDiff() {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (selected[i]) sum += population[i];
            else sum -= population[i];
        }
        return Math.abs(sum);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}