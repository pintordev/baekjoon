import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edge_list) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[][] memo = new int[k][n + 1];
        for (int[] me : memo) {
            Arrays.fill(me, Integer.MAX_VALUE);
        }
        memo[0][gps_log[0]] = 0;
        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                if (memo[i - 1][j] == Integer.MAX_VALUE) continue;
                for (int next : graph[j]) {
                    int cost = memo[i - 1][j] + (gps_log[i] == next ? 0 : 1);
                    memo[i][next] = Math.min(memo[i][next], cost);
                }
            }
        }
        return memo[k - 1][gps_log[k - 1]] == Integer.MAX_VALUE ? -1 : memo[k - 1][gps_log[k - 1]];
    }
}