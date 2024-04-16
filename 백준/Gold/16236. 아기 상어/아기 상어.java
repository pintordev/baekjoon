import java.io.IOException;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static int n;
    public static int[][] map;
    public static Shark shark;
    public static PriorityQueue<Fish> fishes;
    public static boolean[][] visited;
    public static int[] dr = {0, 1, 0, -1};
    public static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        init();
        simulate();
    }

    public static void simulate() {
        while (true) {
            findFish();
            if (fishes.isEmpty()) {
                break;
            }
            Fish toEat = fishes.poll();
            shark.eat(toEat);
            map[toEat.r][toEat.c] = 0;
        }
        System.out.println(shark.time);
    }

    public static void findFish() {
        fishes = new PriorityQueue<>();
        visited = new boolean[n][n];

        Queue<Fish> queue = new ArrayDeque<>();
        queue.add(new Fish(shark.r, shark.c, 0));
        visited[shark.r][shark.c] = true;
        while (!queue.isEmpty()) {
            Fish now = queue.poll();

            if (map[now.r][now.c] != 0 && map[now.r][now.c] < shark.size) {
                fishes.add(now);
            }

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (!canMove(nr, nc)) {
                    continue;
                }

                queue.add(new Fish(nr, nc, now.dist + 1));
                visited[nr][nc] = true;
            }
        }
    }

    public static boolean canMove(int nr, int nc) {
        return nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && map[nr][nc] <= shark.size;
    }

    public static void init() throws IOException {
        n = read();

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = read();
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    shark = new Shark(i, j);
                }
            }
        }
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Shark {
    int r;
    int c;
    int size = 2;
    int ate = 0;
    int time = 0;

    public Shark(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public void eat(Fish fish) {
        this.r = fish.r;
        this.c = fish.c;
        this.ate++;
        this.time += fish.dist;
        if (this.ate == this.size) {
            this.size++;
            this.ate = 0;
        }
    }
}

class Fish implements Comparable<Fish> {
    int r;
    int c;
    int dist;

    public Fish(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }

    @Override
    public int compareTo(Fish o) {
        if (this.dist == o.dist && this.r == o.r) {
            return this.c - o.c;
        } else if (this.dist == o.dist) {
            return this.r - o.r;
        } else {
            return this.dist - o.dist;
        }
    }
}