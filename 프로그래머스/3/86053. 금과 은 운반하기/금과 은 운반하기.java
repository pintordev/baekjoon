class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long low = 0;
        long high = (a + b) * 2L * 100_000;
        while (low + 1 < high) {
            long mid = (low + high) >> 1;

            long gold = 0;
            long silver = 0;
            long carried = 0;
            for (int i = 0, n = t.length; i < n; i++) {
                long subCarried = Math.round((double) mid / t[i] / 2) * w[i];
                gold += Math.min(g[i], subCarried);
                silver += Math.min(s[i], subCarried);
                carried += Math.min(g[i] + s[i], subCarried);
            }

            if (a <= gold && b <= silver && a + b <= carried) high = mid;
            else low = mid;
        }
        return high;
    }
}