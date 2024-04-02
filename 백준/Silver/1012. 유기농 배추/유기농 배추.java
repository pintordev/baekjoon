import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {

        int[][] ds = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int m = read(), n = read();
            int[][] field = new int[m][n];

            int k = read();
            while (k-- > 0) field[read()][read()]++;

            boolean[][] checked = new boolean[m][n];
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (field[i][j] == 0 || checked[i][j]) continue;
                    count++;

                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        int x = now[0], y = now[1];
                        if (field[x][y] == 0 || checked[x][y]) continue;
                        checked[x][y] = true;

                        for (int l = 0; l < 4; l++) {
                            int nx = x + ds[l][0];
                            int ny = y + ds[l][1];
                            if (canMove(nx, ny, m, n)) queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    public static boolean canMove(int nx, int ny, int m, int n) {
        return nx >= 0 && nx < m && ny >= 0 && ny < n;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}