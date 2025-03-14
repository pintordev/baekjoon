class Solution {
    public int solution(int sticker[]) {

        int n = sticker.length;
        if (n == 1) return sticker[0];
        
        int[] dp0 = new int[n];
        int[] dp1 = new int[n];

        dp0[0] = sticker[0];
        dp0[1] = Math.max(dp0[0], sticker[1]);
        dp1[1] = sticker[1];

        for (int i = 2; i < n; i++) {
            dp0[i] = Math.max(dp0[i - 1], dp0[i - 2] + sticker[i]);
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }

        return Math.max(dp0[n - 2], dp1[n - 1]);
    }
}