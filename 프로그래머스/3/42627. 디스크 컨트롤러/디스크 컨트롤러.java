import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        PriorityQueue<int[]> jq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        int n = jobs.length, sum = 0, due = 0, idx = 0;
        while (idx < n || !jq.isEmpty()) {
            while (idx < n && jobs[idx][0] <= due) jq.add(jobs[idx++]);
            if (jq.isEmpty()) due = jobs[idx][0];
            else {
                due += jq.peek()[1];
                sum += due - jq.poll()[0];
            }
        }

        return sum / n;
    }
}