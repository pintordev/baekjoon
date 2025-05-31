import java.util.*;

class Solution {
    public static int[] dr = {0, 0, 1, -1};
    public static int[] dc = {1, -1, 0, 0};

    public int solution(int[][] land, int height) {
        int n = land.length;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));

        boolean[][] visited = new boolean[n][n];
        int cost = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.r][cur.c]) continue;

            visited[cur.r][cur.c] = true;
            cost += cur.cost;

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;

                int diff = Math.abs(land[cur.r][cur.c] - land[nr][nc]);
                if (diff > height) pq.add(new Node(nr, nc, diff));
                else pq.add(new Node(nr, nc, 0));
            }
        }
        return cost;
    }
}

class Node implements Comparable<Node> {
    int r;
    int c;
    int cost;

    public Node(int r, int c, int cost) {
        this.r = r;
        this.c = c;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}