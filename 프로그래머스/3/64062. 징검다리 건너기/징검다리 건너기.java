import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {

        Deque<Integer> deque = new LinkedList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < stones.length; i++) {
            while (!deque.isEmpty() && stones[deque.peekLast()] < stones[i]) deque.pollLast();
            deque.addLast(i);
            if (!deque.isEmpty() && i - deque.peekFirst() == k) deque.pollFirst();
            if (i >= k - 1) min = Math.min(min, stones[deque.peekFirst()]);
        }

        return min;
    }
}