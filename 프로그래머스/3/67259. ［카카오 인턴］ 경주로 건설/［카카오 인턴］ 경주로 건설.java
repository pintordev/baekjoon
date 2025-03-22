import java.util.*;

class Solution {
    public static int n;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static boolean[][][] visited;

    public int solution(int[][] board) {
        n = board.length;
        visited = new boolean[n][n][4];
        return bfs(board);
    }

    public int bfs(int[][] board) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, -1, 0));

        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            
            if (cur.x == n - 1 && cur.y == n - 1) {
                min = Math.min(min, cur.cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                int nCost = 0;
                if (cur.dir == -1 || cur.dir == i) nCost = cur.cost + 100;
                else nCost = cur.cost + 600;

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) continue;
                if (visited[nx][ny][i] && board[nx][ny] < nCost) continue;
                queue.add(new Node(nx, ny, i, nCost));
                visited[nx][ny][i] = true;
                board[nx][ny] = nCost;
            }
        }

        return min;
    }
}

class Node {
    int x;
    int y;
    int dir;
    int cost;

    public Node(int x, int y, int dir, int cost) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}