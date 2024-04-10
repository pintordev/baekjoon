import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Main {
    public static int n;
    public static int m;
    public static int[][] map;
    public static int[][] copiedMap;
    public static boolean[][] visited;
    public static int[] dr = { -1, 1, 0, 0 };
    public static int[] dc = { 0, 0, -1, 1 };
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        readMap();
        buildWall(0, 0, 0);
        System.out.println(max);
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

    public static void buildWall(int r, int c, int cnt) {
        if (cnt == 3) {
            cloneMap();
            spreadVirus();
            countSafeArea();
            return;
        }

        for (int i = r; i < n; i++) {
            for (int j = (i == r) ? c : 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(i, j, cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void cloneMap() {
        copiedMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copiedMap[i][j] = map[i][j];
            }
        }
    }

    public static void spreadVirus() {
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || copiedMap[i][j] != 2) {
                    continue;
                }
                bfs(i, j);
            }
        }
    }

    public static void bfs(int r, int c) {
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
                queue.add(new Node(nr, nc));
                visited[nr][nc] = true;
                copiedMap[nr][nc] = 2;
            }
        }
    }

    public static boolean canMove(int nr, int nc) {
        return nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && copiedMap[nr][nc] == 0;
    }

    public static void countSafeArea() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copiedMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        max = Math.max(max, cnt);
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