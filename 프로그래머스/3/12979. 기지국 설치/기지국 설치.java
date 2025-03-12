class Solution {
    public int solution(int n, int[] stations, int w) {

        int count = 0, len = 2 * w + 1;
        int left = 0, remain = 0;
        for (int i = 0; i < stations.length; i++) {
            remain = stations[i] - left - w - 1;
            if (remain > 0) count += (remain - 1) / len + 1;
            left = stations[i] + w;
        }

        remain = n - stations[stations.length - 1] - w;
        if (remain > 0) count += (remain - 1) / len + 1;

        return count;
    }
}