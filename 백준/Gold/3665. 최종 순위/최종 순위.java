import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int t = read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(solve()).append('\n');
        }
        System.out.println(sb);
    }

    public static String solve() throws IOException {
        int n = read();

        int[] rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            rank[i] = read();
        }

        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] before = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                graph[rank[i]].add(rank[j]);
                before[rank[j]]++;
            }
        }

        int m = read();
        for (int i = 0; i < m; i++) {
            int a = read();
            int b = read();
            if (graph[a].contains(b)) {
                graph[a].remove((Integer) b);
                graph[b].add(a);
                before[a]++;
                before[b]--;
            } else {
                graph[b].remove((Integer) a);
                graph[a].add(b);
                before[b]++;
                before[a]--;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (before[i] == 0) q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (!q.isEmpty()) {
            if (q.size() > 1) return "?";

            int cur = q.poll();
            sb.append(cur).append(' ');
            cnt++;

            for (int next : graph[cur]) {
                before[next]--;
                if (before[next] == 0) q.add(next);
            }
        }

        if (cnt != n) return "IMPOSSIBLE";
        return sb.toString();
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}