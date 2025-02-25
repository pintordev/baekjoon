import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < enemy.length; i++) {
            if (k-- > 0) queue.add(enemy[i]);
            else if (enemy[i] <= queue.peek()) n -= enemy[i];
            else {
                n -= queue.poll();
                queue.add(enemy[i]);
            }
            if (n == 0) return i + 1;
            else if (n < 0) return i;
        }

        return enemy.length;
    }
}