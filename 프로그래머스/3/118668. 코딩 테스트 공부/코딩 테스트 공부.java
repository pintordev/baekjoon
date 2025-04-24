import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int alg = 0;
        int cog = 0;
        for (int[] problem : problems) {
            alg = Math.max(alg, problem[0]);
            cog = Math.max(cog, problem[1]);
        }

        if (alp >= alg && cop >= cog) return 0;
        alp = Math.min(alp, alg);
        cop = Math.min(cop, cog);

        int[][] memo = new int[alg + 1][cog + 1];
        for (int[] m : memo) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }

        memo[alp][cop] = 0;
        for (int i = alp; i <= alg; i++) {
            for (int j = cop; j <= cog; j++) {
                if (i + 1 <= alg) memo[i + 1][j] = Math.min(memo[i + 1][j], memo[i][j] + 1);
                if (j + 1 <= cog) memo[i][j + 1] = Math.min(memo[i][j + 1], memo[i][j] + 1);
                for (int[] problem : problems) {
                    if (i < problem[0] || j < problem[1]) continue;
                    int alr = Math.min(alg, i + problem[2]);
                    int clr = Math.min(cog, j + problem[3]);
                    memo[alr][clr] = Math.min(memo[alr][clr], memo[i][j] + problem[4]);
                }
            }
        }
        return memo[alg][cog];
    }
}