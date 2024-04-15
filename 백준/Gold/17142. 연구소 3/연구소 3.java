import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static int n;
    public static int m;
    public static int[][] map;
    public static int blank;
    public static List<Virus> viruses = new ArrayList<>();
    public static int vSize;
    public static Virus[] activated;
    public static boolean[][] visited;
    public static int[] dr = {0, 0, 1, -1};
    public static int[] dc = {1, -1, 0, 0};
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        simulate();
    }

    public static void simulate() {
        activated = new Virus[m];
        comb(0, 0);
        if (min != Integer.MAX_VALUE) {
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }

    public static void comb(int start, int depth) {
        if (depth == m) {
            bfs();
            return;
        }

        for (int i = start; i < vSize; i++) {
            activated[depth] = viruses.get(i);
            comb(i + 1, depth + 1);
        }
    }

    public static void bfs() {
        visited = new boolean[n][n];
        int empty = blank;

        Queue<Virus> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            queue.add(activated[i]);
            visited[activated[i].r][activated[i].c] = true;
        }
        while (!queue.isEmpty()) {
            Virus now = queue.poll();
            if (map[now.r][now.c] == 0) {
                empty--;
            }
            if (empty == 0) {
                min = Math.min(min, now.t);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (!canMove(nr, nc)) {
                    continue;
                }

                queue.add(new Virus(nr, nc, now.t + 1));
                visited[nr][nc] = true;
            }
        }
    }

    public static boolean canMove(int nr, int nc) {
        return nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && map[nr][nc] != 1;
    }

    public static void init() throws IOException {
        n = read();
        m = read();

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = read();
                if (map[i][j] == 2) {
                    viruses.add(new Virus(i, j, 0));
                } else if (map[i][j] == 0) {
                    blank++;
                }
            }
        }
        vSize = viruses.size();
    }
    
    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Virus {
    int r;
    int c;
    int t;

    public Virus(int r, int c, int t) {
        this.r = r;
        this.c = c;
        this.t = t;
    }
}