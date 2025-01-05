import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n + 1];
        int[] times = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            times[i] = read();

            int m;
            while ((m = read()) != -1) {
                graph[m].add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        int[] memo = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (indegree[i] != 0) continue;
            q.add(i);
            memo[i] = times[i];
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                memo[next] = Math.max(memo[next], memo[cur] + times[next]);
                if (--indegree[next] == 0) q.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(memo[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }
}