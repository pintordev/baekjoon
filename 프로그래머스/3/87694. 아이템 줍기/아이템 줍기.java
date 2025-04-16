import java.util.*;

class Solution {
    public static int[][] board;
    public static boolean[][] visited;
    public static int[] dr = {0, 0, 1, -1};
    public static int[] dc = {1, -1, 0, 0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        board = new int[101][101];
        for (int[] r : rectangle) {
            addRectangle(r);
        }

        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }

    public int bfs(int cr, int cc, int ir, int ic) {
        visited = new boolean[101][101];

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(cr, cc, 0));
        visited[cr][cc] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.r == ir && cur.c == ic) return cur.d / 2;

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (!canMove(nr, nc)) continue;
                visited[nr][nc] = true;
                queue.add(new Node(nr, nc, cur.d + 1));
            }
        }

        return -1;
    }

    public boolean canMove(int nr, int nc) {
        if (nr < 0 || nc < 0 || nr > 100 || nc > 100) return false;
        if (board[nr][nc] != 1) return false;
        if (visited[nr][nc]) return false;
        return true;
    }

    public void addRectangle(int[] r) {
        int r1 = r[0] * 2;
        int c1 = r[1] * 2;
        int r2 = r[2] * 2;
        int c2 = r[3] * 2;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (board[i][j] == 2) continue;
                board[i][j] = 2;
                if (i == r1 || i == r2 || j == c1 || j == c2) board[i][j] = 1;
            }
        }
    }
}

class Node {
    int r;
    int c;
    int d;

    public Node(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}