class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] memo = new int[n + 2][m + 2];

        for (int[] s : skill) {
            int damage = s[0] == 1 ? -s[5] : s[5];
            memo[s[1] + 1][s[2] + 1] += damage;
            memo[s[1] + 1][s[4] + 2] += -damage;
            memo[s[3] + 2][s[2] + 1] += -damage;
            memo[s[3] + 2][s[4] + 2] += damage;
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                memo[i][j] += memo[i - 1][j] + memo[i][j - 1] - memo[i - 1][j - 1];
                if (board[i - 1][j - 1] + memo[i][j] > 0) cnt++;
            }
        }
        return cnt;
    }
}