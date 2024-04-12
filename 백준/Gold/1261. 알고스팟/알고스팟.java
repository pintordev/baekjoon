import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static int n;
    public static int m;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        init();
        dijkstra();
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.x == n - 1 && now.y == m - 1) {
                System.out.println(now.cnt);
                return;
            }

            if (visited[now.x][now.y]) {
                continue;
            }
            visited[now.x][now.y] = true;

            for (int k = 0; k < 4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];

                if (!canMove(nx, ny)) {
                    continue;
                }

                if (map[nx][ny] == '0') {
                    pq.add(new Node(nx, ny, now.cnt));
                } else {
                    pq.add(new Node(nx, ny, now.cnt + 1));
                }
            }
        }
    }

    public static boolean canMove(int nx, int ny) {
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
            return false;
        }
        if (visited[nx][ny]) {
            return false;
        }
        return true;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int cnt;

    public Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Node o) {
        return this.cnt - o.cnt;
    }
}