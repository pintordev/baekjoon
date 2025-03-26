class Solution {
    public int solution(int[] a) {
        int n = a.length;
        if (n < 3) return n;

        int[] left = new int[n - 2];
        int[] right = new int[n - 2];
        left[0] = a[0];
        right[n - 3] = a[n - 1];
        for (int i = 1; i < n - 2; i++) {
            left[i] = Math.min(left[i - 1], a[i]);
            right[n - 3 - i] = Math.min(right[n - 3 - i + 1], a[n - 1 - i]);
        }

        int result = 2;
        for (int i = 1; i < n - 1; i++) {
            if (a[i] < left[i - 1] || a[i] < right[i - 1]) result++;
        }
        return result;
    }
}