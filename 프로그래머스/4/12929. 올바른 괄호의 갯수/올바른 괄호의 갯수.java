class Solution {
    public int solution(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                memo[i] += memo[i - j] * memo[j - 1];
            }
        }
        return memo[n];
    }
}