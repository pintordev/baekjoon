import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static int[][] map;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int[][] sx = {
            {0, -1, 1, -2, -1, 1, 2, -1, 1, 0},
            {2, 1, 1, 0, 0, 0, 0, -1, -1, 1},
            {0, -1, 1, -2, -1, 1, 2, -1, 1, 0},
            {-2, -1, -1, 0, 0, 0, 0, 1, 1, -1}
    };
    public static int[][] sy = {
            {-2, -1, -1, 0, 0, 0, 0, 1, 1, -1},
            {0, -1, 1, -2, -1, 1, 2, -1, 1, 0},
            {2, 1, 1, 0, 0, 0, 0, -1, -1, 1},
            {0, -1, 1, -2, -1, 1, 2, -1, 1, 0},
    };
    public static int[] rates = {5, 10, 10, 2, 7, 7, 2, 1, 1};
    public static int outSand = 0;

    public static void main(String[] args) throws IOException {
        init();
        simulate();
    }

    public static void simulate() {
        int x = n / 2, y = n / 2, d = 0, l = 1, moveCnt = 0, turnCnt = 0;
        while (x != 0 || y != 0) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            moveCnt++;
            move(nx, ny, d);

            x = nx;
            y = ny;
            if (moveCnt == l) {
                moveCnt = 0;
                d = (d + 1) % 4;
                turnCnt++;
            }
            if (turnCnt == 2) {
                turnCnt = 0;
                l++;
            }
        }
        System.out.println(outSand);
    }

    public static void move(int nx, int ny, int d) {
        int sand = map[nx][ny];
        for (int i = 0; i < 10; i++) {
            int mx = nx + sx[d][i];
            int my = ny + sy[d][i];

            int movedSand;
            if (i == 9) {
                movedSand = sand;
            } else {
                movedSand = map[nx][ny] * rates[i] / 100;
            }

            if (isOutOfRange(mx, my)) {
                outSand += movedSand;
            } else {
                map[mx][my] += movedSand;
            }
            sand -= movedSand;
        }
        map[nx][ny] = 0;
    }

    public static boolean isOutOfRange(int mx, int my) {
        return mx < 0 || mx >= n || my < 0 || my >= n;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
    }
}