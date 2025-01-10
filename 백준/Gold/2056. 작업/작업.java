import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        List<Integer>[] list = new List[n + 1];
        int[] indegree = new int[n + 1];
        int[] times = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            times[i] = read();
            indegree[i] = read();
            for (int j = 0; j < indegree[i]; j++) {
                list[read()].add(i);
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        int[] memo = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            memo[i] = times[i];
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : list[cur]) {
                memo[next] = Math.max(memo[next], memo[cur] + times[next]);
                if (--indegree[next] == 0) q.add(next);
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, memo[i]);
        }
        System.out.println(max);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}