import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        int m = read();
        int n = read();
        int h = read();

        int[][][] box = new int[h][n][m];
        int toRipe = m * n * h;
        Queue<Tomato> queue = new LinkedList<>();
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    box[k][i][j] = read();
                    if (box[k][i][j] == 1) {
                        queue.add(new Tomato(k, i, j));
                    } else if (box[k][i][j] == -1) {
                        toRipe--;
                    }
                }
            }
        }

        int[][] ds = {{0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}};

        int day = 0;
        while (!queue.isEmpty()) {
            Tomato now = queue.poll();
            day = Math.max(day, box[now.l][now.r][now.c] - 1);
            toRipe--;

            for (int[] d : ds) {
                int nl = now.l + d[0];
                int nr = now.r + d[1];
                int nc = now.c + d[2];

                if (nl < 0 || nl >= h || nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                if (box[nl][nr][nc] != 0) {
                    continue;
                }

                box[nl][nr][nc] = box[now.l][now.r][now.c] + 1;
                queue.add(new Tomato(nl, nr, nc));
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

    public Tomato(int l, int r, int c) {
        this.l = l;
        this.r = r;
        this.c = c;
    }
}