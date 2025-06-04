import java.util.*;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        int n = rc.length;
        int m = rc[0].length;

        Deque<Integer> left = new ArrayDeque<>();
        Deque<Deque<Integer>> center = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            left.add(rc[i][0]);
            Deque<Integer> q = new ArrayDeque<>();
            for (int j = 1; j < m - 1; j++) {
                q.add(rc[i][j]);
            }
            center.add(q);
            right.add(rc[i][m - 1]);
        }

        for (String operation : operations) {
            if (operation.charAt(0) == 'S') shiftRow(left, center, right);
            else rotate(left, center, right);
        }

        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            result[i][0] = left.pollFirst();
            Deque<Integer> q = center.poll();
            for (int j = 1; j < m - 1; j++) {
                result[i][j] = q.pollFirst();
            }
            result[i][m - 1] = right.pollFirst();
        }
        return result;
    }

    public void shiftRow(Deque<Integer> left, Deque<Deque<Integer>> center, Deque<Integer> right) {
        left.addFirst(left.pollLast());
        center.addFirst(center.pollLast());
        right.addFirst(right.pollLast());
    }

    public void rotate(Deque<Integer> left, Deque<Deque<Integer>> center, Deque<Integer> right) {
        center.peekFirst().addFirst(left.pollFirst());
        right.addFirst(center.peekFirst().pollLast());
        center.peekLast().addLast(right.pollLast());
        left.addLast(center.peekLast().pollFirst());
    }
}