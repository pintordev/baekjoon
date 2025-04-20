import java.util.*;

class Solution {
    public static long cnt;
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static long[] a;

    public long solution(int[] a, int[][] edges) {
        cnt = 0;
        int n = a.length;
        graph = new List[n];
        visited = new boolean[n];
        this.a = new long[n];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            this.a[i] = a[i];
            sum += a[i];
        }

        if (sum != 0) return -1;

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        dfs(0);

        return cnt;
    }

    public void dfs(int node) {
        visited[node] = true;

        for (int i = 0, n = graph[node].size(); i < n; i++) {
            int next = graph[node].get(i);
            if (visited[next]) continue;
            dfs(next);
            a[node] += a[next];
        }

        cnt += Math.abs(a[node]);
    }
}