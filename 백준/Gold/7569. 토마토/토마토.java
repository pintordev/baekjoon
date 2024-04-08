import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        int m = read();
        int n = read();
        int h = read();

        boolean[][][] visited = new boolean[h][n][m];
        int toRipe = m * n * h;
        Queue<Tomato> queue = new LinkedList<>();
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int riped = read();
                    if (riped == 1) {
                        queue.add(new Tomato(k, i, j, 0));
                        visited[k][i][j] = true;
                    } else if (riped == -1) {
                        visited[k][i][j] = true;
                        toRipe--;
                    }
                }
            }
        }

        int[][] ds = {{0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}};

        int day = 0;
        while (!queue.isEmpty()) {
            Tomato now = queue.poll();
            day = now.day;
            toRipe--;

            for (int[] d : ds) {
                int nl = now.l + d[0];
                int nr = now.r + d[1];
                int nc = now.c + d[2];

                if (nl < 0 || nl >= h || nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                if (visited[nl][nr][nc]) {
                    continue;
                }

                queue.add(new Tomato(nl, nr, nc, now.day + 1));
                visited[nl][nr][nc] = true;
            }
        }

        if (toRipe > 0) {
            System.out.println(-1);
        } else {
            System.out.println(day);
        }
    }
    
    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }
}

class Tomato {
    int l;
    int r;
    int c;
    int day;

    public Tomato(int l, int r, int c, int day) {
        this.l = l;
        this.r = r;
        this.c = c;
        this.day = day;
    }
}