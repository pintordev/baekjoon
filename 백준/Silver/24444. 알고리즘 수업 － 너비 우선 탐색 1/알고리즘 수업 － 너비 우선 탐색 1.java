import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int r = Integer.parseInt(input[2]);

        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        boolean[] visited = new boolean[n + 1];
        int[] order = new int[n + 1];
        int vdx = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        visited[r] = true;
        order[r] = ++vdx;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : graph[now]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    order[i] = ++vdx;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(order[i]).append('\n');
        }
        System.out.println(sb);
    }
}