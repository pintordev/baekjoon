import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static int n;
    public static int m;
    public static int[][] board;
    public static int cheese = 0;
    public static boolean[][] visited;
    public static int dr[] = {0, 0, 1, -1};
    public static int dc[] = {1, -1, 0, 0};
    public static int melted;

    public static void main(String[] args) throws IOException {
        init();
        simulate();
    }

    public static void simulate() {
        int time = 0;
        while (cheese > 0) {
            time++;
            bfs(0, 0);
            cheese -= melted;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(time).append('\n').append(melted);
        System.out.println(sb);
    }

    public static void bfs(int r, int c) {
        visited = new boolean[n][m];
        melted = 0;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(r, c));
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (!canMove(nr, nc)) {
                    continue;
                }
                visited[nr][nc] = true;

                if (board[nr][nc] == 0) {
                    queue.add(new Node(nr, nc));
                } else {
                    board[nr][nc] = 0;
                    melted++;
                }
            }
        }
    }

    public static boolean canMove(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m && !visited[r][c];
    }

    public static void init() throws IOException {
        n = read();
        m = read();

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = read();
                if (board[i][j] == 1) cheese++;
            }
        }
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