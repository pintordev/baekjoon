class Solution {
    public int solution(int n, int count) {
        int mod = 1_000_000_007;

        long[][] memo = new long[n + 1][count + 1];
        memo[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i && j <= count; j++) {
                memo[i][j] = (2 * (i - 1) * memo[i - 1][j] + memo[i - 1][j - 1]) % mod;
            }
        }
        return (int) memo[n][count];
    }
}