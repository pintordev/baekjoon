import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();

        int[][] map = new int[n][m];
        int sr = 0;
        int sc = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = read();
                if (map[i][j] == 2) {
                    sr = i;
                    sc = j;
                }
            }
        }

        int[][] reach = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[][] ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sr, sc));
        visited[sr][sc] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int r = node.r;
            int c = node.c;

            for (int[] d : ds) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (map[nr][nc] == 0) continue;
                if (visited[nr][nc]) continue;

                reach[nr][nc] = reach[r][c] + 1;
                queue.add(new Node(nr, nc));
                visited[nr][nc] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    sb.append(-1).append(' ');
                } else {
                    sb.append(reach[i][j]).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
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