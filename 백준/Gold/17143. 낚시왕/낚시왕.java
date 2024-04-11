import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static int r;
    public static int c;
    public static Shark[][] map;
    public static Queue<Shark> queue = new ArrayDeque<>();
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, 1, -1};
    public static int sum = 0;
    public static int fisher = -1;

    public static void main(String[] args) throws IOException {
        init();
        simulate();
    }

    public static void simulate() {
        while (++fisher < c) {
            fish();
            addQueue();
            moveShark();
        }
        System.out.println(sum);
    }

    public static void fish() {
        for (int i = 0; i < r; i++) {
            if (map[i][fisher] != null) {
                sum += map[i][fisher].z;
                map[i][fisher] = null;
                return;
            }
        }
    }

    public static void addQueue() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != null) {
                    queue.add(map[i][j]);
                    map[i][j] = null;
                }
            }
        }
    }

    public static void moveShark() {
        while (!queue.isEmpty()) {
            Shark shark = queue.poll();
            int s;
            if (shark.d < 2) {
                s = shark.s % ((r - 1) * 2);
                while (s-- > 0) {
                    if (shark.r == 0 && shark.d == 0) {
                        shark.d = 1;
                    } else if (shark.r == r - 1 && shark.d == 1) {
                        shark.d = 0;
                    }
                    shark.r += dr[shark.d];
                }
            } else {
                s = shark.s % ((c - 1) * 2);
                while (s-- > 0) {
                    if (shark.c == 0 && shark.d == 3) {
                        shark.d = 2;
                    } else if (shark.c == c - 1 && shark.d == 2) {
                        shark.d = 3;
                    }
                    shark.c += dc[shark.d];
                }
            }

            if (map[shark.r][shark.c] == null) {
                map[shark.r][shark.c] = shark;
            } else if (map[shark.r][shark.c].z < shark.z) {
                map[shark.r][shark.c] = shark;
            }
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        map = new Shark[r][c];
        int m = Integer.parseInt(input[2]);
        while (m-- > 0) {
            input = br.readLine().split(" ");
            int i = Integer.parseInt(input[0]) - 1;
            int j = Integer.parseInt(input[1]) - 1;
            int s = Integer.parseInt(input[2]);
            int d = Integer.parseInt(input[3]) - 1;
            int z = Integer.parseInt(input[4]);
            map[i][j] = new Shark(i, j, s, d, z);
        }
    }
}

class Shark {
    int r;
    int c;
    int s;
    int d;
    int z;

    public Shark(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }
}