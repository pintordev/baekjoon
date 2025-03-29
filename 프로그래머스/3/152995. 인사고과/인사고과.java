import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] me = scores[0];
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        int result = 1;
        int prev = scores[0][1];
        for (int i = 0, n = scores.length; i < n; i++) {
            if (prev > scores[i][1]) {
                if (scores[i][0] == me[0] && scores[i][1] == me[1]) return -1;
                continue;
            }
            prev = scores[i][1];
            if (scores[i][0] + scores[i][1] > me[0] + me[1]) result++;
        }
        return result;
    }
}