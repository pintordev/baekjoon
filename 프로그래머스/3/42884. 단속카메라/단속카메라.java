import java.util.*;

class Solution {
    public int solution(int[][] routes) {

        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        int e = routes[0][1], result = 1;
        for (int[] route : routes) {
            if (e >= route[0] && e <= route[1]) continue;
            result++;
            e = route[1];
        }

        return result;
    }
}