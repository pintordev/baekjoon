class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[][] memo = new int[2][n];

        memo[0][0] = money[0];
        memo[0][1] = Math.max(memo[0][0], money[1]);
        memo[1][1] = money[1];

        for (int i = 2; i < n; i++) {
            memo[0][i] = Math.max(memo[0][i - 1], memo[0][i - 2] + money[i]);
            memo[1][i] = Math.max(memo[1][i - 1], memo[1][i - 2] + money[i]);
        }

        return Math.max(memo[0][n - 2], memo[1][n - 1]);
    }
}