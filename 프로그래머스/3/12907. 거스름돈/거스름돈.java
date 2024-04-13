class Solution {
    public int solution(int n, int[] money) {
        
        int[] memo = new int[n + 1];
        memo[0] = 1;
        
        int len = money.length;
        for (int i = 0; i < len; i++) {
            for (int j = money[i]; j <= n; j++) {
                memo[j] += memo[j - money[i]];
            }
        }
        return memo[n];
    }
}