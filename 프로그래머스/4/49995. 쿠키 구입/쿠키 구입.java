class Solution {
    public int solution(int[] cookie) {
        int n = cookie.length, sum = 0;
        for (int i = 0; i < n - 1; i++) {
            int ldx = i, rdx = i + 1;
            int lSum = cookie[ldx], rSum = cookie[rdx];

            while (true) {
                if (lSum == rSum && sum < lSum) sum = lSum;
                else if (lSum <= rSum && ldx > 0) lSum += cookie[--ldx];
                else if (lSum > rSum && rdx < n - 1) rSum += cookie[++rdx];
                else break;
            }
        }
        return sum;
    }
}