import java.util.*;

class Solution {
    public long solution(int n, int[] works) {

        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int work : works) queue.add((long) work);

        while (n-- > 0 && queue.peek() > 0) {
            queue.add(queue.poll() - 1);
        }

        long fatigue = 0;
        while (!queue.isEmpty()) fatigue += queue.peek() * queue.poll();
        return fatigue;
    }
}