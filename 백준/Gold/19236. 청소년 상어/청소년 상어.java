import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[][] map = new int[4][4];
    public static Fish[] fishes = new Fish[16];
    public static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
    public static int maxSum = 0;

    public static void main(String[] args) throws IOException {
        init();
        dfs(0, 0, null, fishes, map);
        System.out.println(maxSum);
    }

    public static void dfs(int r, int c, Shark shark, Fish[] fishes, int[][] map) {
        shark = new Shark(shark, fishes[map[r][c]]);
        maxSum = Math.max(maxSum, shark.sum);

        moveFish(shark, fishes, map);
        moveShark(shark, fishes, map);
    }

    public static void moveFish(Shark shark, Fish[] fishes, int[][] map) {
        for (int i = 0; i < 16; i++) {
            if (!fishes[i].isAlive) {
                continue;
            }

            for (int j = 0; j < 8; j++) {
                int nr = fishes[i].r + dr[fishes[i].dir];
                int nc = fishes[i].c + dc[fishes[i].dir];

                if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || (shark.r == nr && shark.c == nc)) {
                    fishes[i].nextDir();
                    continue;
                }

                map[fishes[i].r][fishes[i].c] = map[nr][nc];
                fishes[map[nr][nc]].update(fishes[i].r, fishes[i].c);
                map[nr][nc] = i;
                fishes[i].update(nr, nc);
                break;
            }
        }
    }

    public static void moveShark(Shark shark, Fish[] fishes, int[][] map) {
        for (int i = 1; i <= 3; i++) {
            int nr = shark.r + dr[shark.dir] * i;
            int nc = shark.c + dc[shark.dir] * i;

            if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) {
                return;
            }
            if (!fishes[map[nr][nc]].isAlive) {
                continue;
            }

            int[][] newMap = new int[4][4];
            for (int j = 0; j < 4; j++) {
                newMap[j] = map[j].clone();
            }
            Fish[] newFishes = new Fish[16];
            for (int j = 0; j < 16; j++) {
                newFishes[j] = new Fish(fishes[j]);
            }

            dfs(nr, nc, shark, newFishes, newMap);
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 8; j += 2) {
                int id = Integer.parseInt(input[j]) - 1;
                int dir = Integer.parseInt(input[j + 1]) - 1;
                map[i][j / 2] = id;
                fishes[id] = new Fish(id, i, j / 2, dir, true);
            }
        }
    }
}

class Fish {
    int id;
    int r;
    int c;
    int dir;
    boolean isAlive;

    public Fish(int id, int r, int c, int dir, boolean isAlive) {
        this.id = id;
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.isAlive = isAlive;
    }

    public Fish(Fish fish) {
        this.id = fish.id;
        this.r = fish.r;
        this.c = fish.c;
        this.dir = fish.dir;
        this.isAlive = fish.isAlive;
    }

    public void nextDir() {
        this.dir = (this.dir + 1) % 8;
    }

    public void update(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public void die() {
        this.isAlive = false;
    }
}

class Shark {
    int r;
    int c;
    int dir;
    int sum;

    public Shark(Shark shark, Fish fish) {
        this.r = fish.r;
        this.c = fish.c;
        this.dir = fish.dir;
        fish.die();
        if (shark != null) {
            this.sum = shark.sum + fish.id + 1;
        } else {
            this.sum = fish.id + 1;
        }
    }
}