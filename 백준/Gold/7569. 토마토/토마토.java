import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int h = Integer.parseInt(input[2]);

        int[][][] box = new int[h][n][m];
        int toRipe = m * n * h;
        Queue<Tomato> queue = new LinkedList<>();
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    box[k][i][j] = Integer.parseInt(input[j]);
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