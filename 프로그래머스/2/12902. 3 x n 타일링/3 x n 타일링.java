class Solution {
    public int solution(int n) {

        if (n % 2 == 1) return 0;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[2] = 3;

        // dp[4] = dp[2]*dp[2] + 2*dp[0]
        // dp[6] = dp[2]*dp[4] + 2*dp[2] + 2*dp[0]
        // dp[8] = dp[2]*dp[6] + 2*dp[4] + 2*dp[2] + 2*dp[0]
        long sum = dp[0];
        for (int i = 4; i <= n; i += 2) {
            dp[i] = (dp[2] * dp[i - 2] + 2 * sum) % 1000000007;
            sum += dp[i - 2];
        }

        return (int) dp[n];
    }
}