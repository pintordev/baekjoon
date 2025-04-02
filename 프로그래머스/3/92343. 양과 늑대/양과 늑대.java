import java.util.*;

class Solution {
    public static int n;
    public static int[] info;
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static int maxSheep;

    public int solution(int[] info, int[][] edges) {
        n = info.length;
        this.info = info;
        graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) graph[edge[0]].add(edge[1]);
        visited = new boolean[1 << n];

        dfs(1, 1, 0);
        return maxSheep;
    }

    public void dfs(int bitMask, int sheep, int wolf) {
        visited[bitMask] = true;
        maxSheep = Math.max(maxSheep, sheep);

        for (int i = 0; i < n; i++) {
            if ((bitMask & (1 << i)) == 0) continue;
            for (int next : graph[i]) {
                int nBitMask = bitMask | (1 << next);
                int nSheep = info[next] == 0 ? sheep + 1 : sheep;
                int nWolf = info[next] == 1 ? wolf + 1 : wolf;
                if (nSheep > nWolf && !visited[nBitMask]) {
                    dfs(nBitMask, nSheep, nWolf);
                }
            }
        }
    }
}