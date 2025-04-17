class Solution {
    public static int[][] memo;

    public int[] solution(int target) {
        memo = new int[target + 1][2];

        for (int i = 1; i <= target; i++) {
            memo[i][0] = Integer.MAX_VALUE;
            shoot(i, 50, 1);
            for (int j = 1; j <= 20; j++) {
                shoot(i, j, 1);
                shoot(i, 2 * j, 0);
                shoot(i, 3 * j, 0);
            }
        }

        return new int[]{memo[target][0], memo[target][1]};
    }

    public void shoot(int i, int j, int f) {
        if (i < j) return;
        if (memo[i][0] > memo[i - j][0] + 1) {
            memo[i][0] = memo[i - j][0] + 1;
            memo[i][1] = memo[i - j][1] + f;
        } else if (memo[i][0] == memo[i - j][0] + 1) {
            memo[i][1] = Math.max(memo[i][1], memo[i - j][1] + f);
        }
    }
}