class Solution {
    public int solution(int n, int[] tops) {
        int mod = 10007;

        int[][] memo = new int[n][2];
        memo[0][0] = tops[0] + 2;
        memo[0][1] = 1;
        
        for (int i = 1; i < n; i++) {
            memo[i][0] = (memo[i - 1][0] * (tops[i] + 2) + memo[i - 1][1] * (tops[i] + 1)) % mod;
            memo[i][1] = (memo[i - 1][0] + memo[i - 1][1]) % mod;
        }
        
        return (memo[n - 1][0] + memo[n - 1][1]) % mod;
    }
}