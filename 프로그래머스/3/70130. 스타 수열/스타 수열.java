class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            cnt[a[i]]++;
        }

        int len = 0;
        for (int i = 0; i < n; i++) {
            if (cnt[i] <= len) continue;
            int localLen = 0;
            for (int j = 0; j < n - 1; j++) {
                if (a[j] != i && a[j + 1] != i) continue;
                if (a[j] == a[j + 1]) continue;
                localLen++;
                j++;
            }
            len = Math.max(len, localLen);
        }
        return len * 2;
    }
}