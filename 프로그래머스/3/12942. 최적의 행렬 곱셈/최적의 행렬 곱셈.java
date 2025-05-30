class Solution {
    public static int n;
    public static int[][] memo;
    public static int[][] matrix_sizes;

    public int solution(int[][] matrix_sizes) {
        n = matrix_sizes.length;
        memo = new int[n][n];
        this.matrix_sizes = matrix_sizes;

        return dp(0, n - 1);
    }

    public int dp(int s, int e) {
        if (s == e) return 0;
        if (memo[s][e] != 0) return memo[s][e];

        memo[s][e] = Integer.MAX_VALUE;
        for (int m = s; m < e; m++) {
            int cost = dp(s, m) + dp(m + 1, e) + matrix_sizes[s][0] * matrix_sizes[m][1] * matrix_sizes[e][1];
            memo[s][e] = Math.min(memo[s][e], cost);
        }
        return memo[s][e];
    }
}