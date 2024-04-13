import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        int tLen = times.length;
        
        long low = 0;
        long high = (long) n * times[tLen - 1];
        while (low + 1 < high) {
            long mid = (low + high) >> 1;
            
            long sum = 0;
            for (int i = 0; i < tLen && sum < n; i++) {
                sum += mid / times[i];
            }
            
            if (sum < n) {
                low = mid;
            } else {
                high = mid;
            }
        }
        
        return high;
    }
}