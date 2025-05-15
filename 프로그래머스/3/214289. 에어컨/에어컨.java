import java.util.*;

class Solution {
    public static int LIMIT = 100_000;

    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int n = onboard.length;
        int minTemp = Math.min(temperature, Math.min(t1, t2));
        int maxTemp = Math.max(temperature, Math.max(t1, t2)) - minTemp;
        temperature -= minTemp;
        t1 -= minTemp;
        t2 -= minTemp;

        int[][] memo = new int[n][maxTemp + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], LIMIT);
        }
        
        memo[0][temperature] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= maxTemp; j++) {
                if (onboard[i] == 1 && (j < t1 || j > t2)) continue;

                int nj = j < temperature && j < maxTemp ? j + 1
                        : j > temperature && j > 0 ? j - 1
                        : j;
                memo[i + 1][nj] = Math.min(memo[i + 1][nj], memo[i][j]);

                if (j < maxTemp) memo[i + 1][j + 1] = Math.min(memo[i + 1][j + 1], memo[i][j] + a);
                if (j > 0) memo[i + 1][j - 1] = Math.min(memo[i + 1][j - 1], memo[i][j] + a);

                memo[i + 1][j] = Math.min(memo[i + 1][j], memo[i][j] + b);
            }
        }

        int minCost = LIMIT;
        for (int i = 0; i <= maxTemp; i++) {
            if (onboard[n - 1] == 1 && (i < t1 || i > t2)) continue;
            minCost = Math.min(minCost, memo[n - 1][i]);
        }
        return minCost;
    }
}