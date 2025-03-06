import java.util.*;

class Solution {
    public int[] solution(int n, int s) {

        if (s < n) return new int[]{-1};

        int[] set = new int[n];
        int q = s / n, r = s % n;
        for (int i = n - 1; i >= 0; i--) {
            set[i] += q + (r-- > 0 ? 1 : 0);
        }

        return set;
    }
}