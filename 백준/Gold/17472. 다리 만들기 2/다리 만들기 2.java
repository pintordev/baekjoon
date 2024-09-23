import java.io.IOException;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static int INF = Integer.MAX_VALUE;
    public static int n;
    public static int m;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dr = {0, 0, 1, -1};
    public static int[] dc = {1, -1, 0, 0};
    public static int cnt;
    public static int[][] bridgeSize;
    public static PriorityQueue<Edge> edges;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        n = read();
        m = read();

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = read();
            }
        }

        cnt = 2;
        visited = new boolean[n][m];
        index();

        bridgeSize = new int[cnt][cnt];
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt; j++) {
                bridgeSize[i][j] = INF;
            }
        }
        makeBridge();

        edges = new PriorityQueue<>();
        for (int i = 2; i < cnt; i++) {
            for (int j = i + 1; j < cnt; j++) {
                if (bridgeSize[i][j] == INF) continue;
                edges.add(new Edge(i, j, bridgeSize[i][j]));
            }
        }

        parent = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            parent[i] = i;
        }

        kruskal();
    }

    public static void index() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || map[i][j] != 1) continue;
                bfs(i, j, cnt++);
            }
        }
    }

    public static void bfs(int i, int j, int idx) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(i, j));
        visited[i][j] = true;
        map[i][j] = idx;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int nr = cur.r + dr[k];
                int nc = cur.c + dc[k];

                if (!canMove(nr, nc)) continue;
                if (visited[nr][nc] || map[nr][nc] != 1) continue;

                q.add(new Point(nr, nc));
                visited[nr][nc] = true;
                map[nr][nc] = idx;
            }
        }
    }

    public static boolean canMove(int nr, int nc) {
        if (nr < 0 || nr >= n || nc < 0 || nc >= m) return false;
        return true;
    }

    public static void makeBridge() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) continue;

                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    int len = 0;
                    while (canMove(nr, nc) && map[nr][nc] == 0) {
                        nr += dr[k];
                        nc += dc[k];
                        len++;
                    }

                    if (!canMove(nr, nc) || len < 2) continue;
                    if (map[nr][nc] == map[i][j]) continue;

                    bridgeSize[map[i][j]][map[nr][nc]] = Math.min(bridgeSize[map[i][j]][map[nr][nc]], len);
                    bridgeSize[map[nr][nc]][map[i][j]] = Math.min(bridgeSize[map[nr][nc]][map[i][j]], len);
                }
            }
        }
    }

    public static void kruskal() {
        int cost = 0;
        int linked = 0;
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            if (find(edge.x) != find(edge.y)) {
                union(edge.x, edge.y);
                cost += edge.z;
                linked++;
            }
        }
        System.out.println(linked == cnt - 3 ? cost : -1);
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x > y) parent[x] = y;
        else parent[y] = x;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Point {
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Edge implements Comparable<Edge> {
    int x;
    int y;
    int z;

    public Edge(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int compareTo(Edge o) {
        return this.z - o.z;
    }
}