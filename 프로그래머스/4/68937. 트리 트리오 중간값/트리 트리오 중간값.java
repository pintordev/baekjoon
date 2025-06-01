import java.util.*;

class Solution {
    public static int n;
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static int max;
    public static int mdx;
    public static int cnt;

    public int solution(int n, int[][] edges) {
        this.n = n;

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        run(1);

        run(mdx);
        if (cnt > 1) return max;

        run(mdx);
        return cnt > 1 ? max : max - 1;
    }

    public void run(int s) {
        visited = new boolean[n + 1];
        max = -1;
        dfs(s, 0);
    }

    public void dfs(int idx, int depth) {
        visited[idx] = true;
        if (max == depth) cnt++;
        if (max < depth) {
            max = depth;
            mdx = idx;
            cnt = 1;
        }

        for (int next : graph[idx]) {
            if (visited[next]) continue;
            dfs(next, depth + 1);
        }
    }
}