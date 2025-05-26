class Solution {
    public int solution(String[] strs, String t) {
        int tLen = t.length();
        int[] memo = new int[tLen + 1];

        for (int i = 1, mLen = memo.length; i < mLen; i++) {
            for (String str : strs) {
                int sLen = str.length();
                int pre = i - sLen;

                if (pre < 0) continue;
                if (!t.substring(pre, i).equals(str)) continue;

                if (pre == 0) memo[i] = 1;
                if (memo[pre] == 0) continue;

                if (memo[i] == 0) memo[i] = memo[pre] + 1;
                else memo[i] = Math.min(memo[i], memo[pre] + 1);
            }
        }

        return memo[tLen] == 0 ? -1 : memo[tLen];
    }
}