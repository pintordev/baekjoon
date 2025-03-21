class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;

        long max = 0, memoA = 0, memoB = 0;
        int factor = 1;
        for (int i = 0; i < n; i++) {
            int now = factor * sequence[i];
            memoA = Math.max(memoA + now, now);
            memoB = Math.max(memoB - now, -now);
            max = Math.max(max, Math.max(memoA, memoB));
            factor *= -1;
        }

        return max;
    }
}