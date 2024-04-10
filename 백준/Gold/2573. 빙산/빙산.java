import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Main {
    public static int n;
    public static int m;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static int area = 0;

    public static void main(String[] args) throws IOException {
        readMap();
        simulation();
    }

    public static void simulation() {
        int year = 0;
        while (area < 2) {
            melt();
            year++;
            findArea();
        }
        System.out.println(year);
    }

    public static void melt() {
        Queue<Node> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                int zero = 0;
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if (canMove(nr, nc, true)) {
                        zero++;
                    }
                }

                if (zero > 0) {
                    queue.add(new Node(i, j, zero));
                }
            }
        }

        if (queue.isEmpty()) {
            System.out.println(0);
            System.exit(0);
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            map[node.r][node.c] = Math.max(0, map[node.r][node.c] - node.zero);
        }
    }

    public static void findArea() {
        visited = new boolean[n][m];
        area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                area++;
                bfs(i, j);
            }
        }
    }

    public static void bfs(int i, int j) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(i, j, 0));
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nr = node.r + dr[k];
                int nc = node.c + dc[k];

                if (canMove(nr, nc, false)) {
                    queue.add(new Node(nr, nc, 0));
                    visited[nr][nc] = true;
                }
            }
        }

    }
    
    public static boolean canMove(int r, int c, boolean flag) {
        if (r < 0 || r >= n || c < 0 || c >= m) {
            return false;
        }
        if (flag) {
            if (map[r][c] == 0) {
                return true;
            }
        } else {
            if (map[r][c] != 0 && !visited[r][c]) {
                return true;
            }
        }
        return false;
    }

    public static void readMap() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
    }
}

class Node {
    int r;
    int c;
    int zero;

    public Node(int r, int c, int zero) {
        this.r = r;
        this.c = c;
        this.zero = zero;
    }
}