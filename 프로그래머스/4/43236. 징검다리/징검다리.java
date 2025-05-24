import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int low = 0, high = distance + 1;
        while (low + 1 < high) {
            int mid = (low + high) >> 1;

            int cnt = 0, cur = 0;
            for (int i = 0, len = rocks.length; i < len; i++) {
                if (rocks[i] - cur < mid) cnt++;
                else cur = rocks[i];
            }
            if (distance - cur < mid) cnt++;

            if (cnt > n) high = mid;
            else low = mid;
        }
        return low;
    }
}