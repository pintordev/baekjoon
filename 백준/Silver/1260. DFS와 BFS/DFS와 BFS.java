import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);

        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < n + 1; i++) {
            Collections.sort(graph[i]);
        }

        dfs(v);
        sb.append('\n');
        Arrays.fill(visited, false);
        bfs(v);

        System.out.println(sb);
    }

    public static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");
        for (int i : graph[v]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");
            for (int i : graph[now]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}