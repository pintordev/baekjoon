import java.util.*;

public class Solution {
    public long solution(int[][] land, int P, int Q) {
        int n = land.length;
        int[] block = new int[n * n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                block[i * n + j] = land[i][j];
                total += land[i][j];
            }
        }

        Arrays.sort(block);
        long cost = Long.MAX_VALUE;
        long cumSum = 0;
        for (int i = 0; i < n * n; i++) {
            cumSum += block[i];
            long add = (long) (i + 1) * block[i] - cumSum;
            long del = total - cumSum - (long) (n * n - i - 1) * block[i];
            long nCost = add * P + del * Q;
            if (cost >= nCost) cost = nCost;
            else return cost;
        }
        return cost;
    }
}