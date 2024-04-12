import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static int problem = 1;
    public static int n;
    public static int[][] map;
    public static int[][] rupee;
    public static boolean[][] visited;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while(true) {
            init();
            dijkstra();
        }
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, map[0][0]));
        rupee[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.x][now.y]) {
                continue;
            }
            visited[now.x][now.y] = true;

            for (int k = 0; k < 4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];

                if (!canMove(nx, ny, now)) {
                    continue;
                }

                rupee[nx][ny] = now.rupee + map[nx][ny];
                pq.add(new Node(nx, ny, rupee[nx][ny]));
            }
        }
        
        sb.append("Problem ").append(problem++).append(": ").append(rupee[n - 1][n - 1]).append('\n');
    }

    public static boolean canMove(int nx, int ny, Node now) {
        if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
            return false;
        }
        if (visited[nx][ny]) {
            return false;
        }
        if (rupee[nx][ny] <= now.rupee + map[nx][ny]) {
            return false;
        }
        return true;
    }

    public static void init() throws IOException {
        n = read();
        if (n == 0) {
            System.out.println(sb);
            System.exit(0);
        }

        map = new int[n][n];
        rupee = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = read();
                rupee[i][j] = Integer.MAX_VALUE;
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

class Node implements Comparable<Node> {
    int x;
    int y;
    int rupee;

    public Node(int x, int y, int rupee) {
        this.x = x;
        this.y = y;
        this.rupee = rupee;
    }

    @Override
    public int compareTo(Node o) {
        return this.rupee - o.rupee;
    }
}