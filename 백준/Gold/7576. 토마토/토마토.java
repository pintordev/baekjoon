import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {

        int[][] ds = {{1, 0}, {0, 1} , {-1, 0}, {0, -1}};

        int m = read();
        int n = read();

        Queue<Point> queue = new LinkedList<>();
        int[][] box = new int[n][m];
        int blank = n * m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = read();
                if (box[i][j] == 1) {
                    queue.add(new Point(i, j));
                }
                if (box[i][j] == - 1) {
                    blank--;
                }
            }
        }

        int day = 0;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            day = Math.max(day, box[now.r][now.c] - 1);
            blank--;

            for (int k = 0; k < 4; k++) {
                int dr = now.r + ds[k][0];
                int dc = now.c + ds[k][1];

                if (dr < 0 || dr >= n || dc < 0 || dc >= m) continue;
                if (box[dr][dc] != 0) continue;

                box[dr][dc] = box[now.r][now.c] + 1;
                queue.add(new Point(dr, dc));
            }
        }

        if (blank > 0) {
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

class Point {
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}