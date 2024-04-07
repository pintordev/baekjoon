import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();

        int[][] maze = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                maze[i][j] = System.in.read() & 15;
            }
            System.in.read();
        }

        int[][] ds = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[n + 2][m + 2];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 1));
        visited[1][1] = true;
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nr = now.r + ds[k][0];
                int nc = now.c + ds[k][1];

                if (maze[nr][nc] > 0 && !visited[nr][nc]) {
                    queue.add(new Node(nr, nc));
                    visited[nr][nc] = true;
                    maze[nr][nc] += maze[now.r][now.c];
                }
            }
        }

        System.out.println(maze[n][m]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Node {
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}