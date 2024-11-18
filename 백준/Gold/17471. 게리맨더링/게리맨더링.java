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
    public static List<Integer> a;
    public static List<Integer> b;

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
        divide(1);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void divide(int idx) {
        if (idx > n) {
            a = new ArrayList<>();
            b = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                if (selected[i]) a.add(i);
                else b.add(i);
            }

            if (a.size() == 0 || b.size() == 0) return;
            if (!isConnected(a) || !isConnected(b)) return;

            min = Math.min(min, getDiff(a, b));
            return;
        }

        selected[idx] = true;
        divide(idx + 1);
        selected[idx] = false;
        divide(idx + 1);
    }

    public static boolean isConnected(List<Integer> list) {
        boolean[] visited = new boolean[n + 1];

        Queue<Integer> q = new ArrayDeque<>();
        int idx = list.get(0);
        q.add(idx);
        visited[idx] = true;

        int cnt = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (visited[next] || !list.contains(next)) continue;
                q.add(next);
                visited[next] = true;
                cnt++;
            }
        }
        return list.size() == cnt;
    }

    public static int getDiff(List<Integer> a, List<Integer> b) {
        int sum = 0;
        for (int i : a) {
            sum += population[i];
        }
        for (int i : b) {
            sum -= population[i];
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