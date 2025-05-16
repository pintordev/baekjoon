import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] timetable) {
        int max = calMax(timetable);
        if (max == 1) return 0;
        return calDist(n, max);
    }

    public int calMax(int[][] timetable) {
        int[] cumulative = new int[722];
        for (int[] time : timetable) {
            cumulative[time[0] - 600]++;
            cumulative[time[1] - 600 + 1]--;
        }

        int max = 1;
        for (int i = 1; i < 722; i++) {
            cumulative[i] += cumulative[i - 1];
            max = Math.max(max, cumulative[i]);
        }
        return max;
    }

    public int calDist(int n, int max) {
        for (int d = 2 * (n - 1); d > 0; d--) {
            for (int j = 0; j < n; j++) {
                if (calCnt(j, n, d) >= max) return d;
            }
        }
        return -1;
    }

    public int calCnt(int sc, int n, int d) {
        Set<Node> nodes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j < sc) continue;
                if (!canPut(nodes, i, j, d)) continue;
                nodes.add(new Node(i, j));
            }
        }
        return nodes.size();
    }

    public boolean canPut(Set<Node> nodes, int i, int j, int d) {
        for (Node node : nodes) {
            if (Math.abs(node.r - i) + Math.abs(node.c - j) < d) return false;
        }
        return true;
    }
}

class Node {
    int r;
    int c;

    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}