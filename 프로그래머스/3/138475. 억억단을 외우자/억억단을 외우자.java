class Solution {
    public int[] solution(int e, int[] starts) {

        int[] div = new int[e + 1];
        for (int i = 1; i <= e; i++) {
            for (int j = 1; j <= e / i; j++) {
                div[i * j]++;
            }
        }

        int max = 0;
        int[] mdx = new int[e + 1];
        for (int i = e; i > 0; i--) {
            if (max <= div[i]) {
                max = div[i];
                mdx[i] = i;
            } else {
                mdx[i] = mdx[i + 1];
            }
        }

        for (int i = 0, t = starts.length; i < t; i++) {
            starts[i] = mdx[starts[i]];
        }
        return starts;
    }
}