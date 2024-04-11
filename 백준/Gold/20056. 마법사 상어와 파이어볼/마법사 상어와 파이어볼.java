import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static int n;
    public static int k;
    public static Queue<FireBall> fireBalls = new ArrayDeque<>();
    public static FireBall[][] map;
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < k; i++) {
            move();
            split();
        }
        countMass();
    }

    public static void move() {
        while (!fireBalls.isEmpty()) {
            FireBall fireBall = fireBalls.poll();
            fireBall.x += dx[fireBall.d] * fireBall.s;
            while (fireBall.x < 0) {
                fireBall.x += n;
            }
            fireBall.x %= n;
            fireBall.y += dy[fireBall.d] * fireBall.s;
            while (fireBall.y < 0) {
                fireBall.y += n;
            }
            fireBall.y %= n;
            FireBall temp = map[fireBall.x][fireBall.y];
            if (temp != null) {
                temp.add(fireBall.m, fireBall.s, fireBall.d);
            } else {
                map[fireBall.x][fireBall.y] = fireBall;
            }
        }
    }

    public static void split() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == null) {
                    continue;
                }

                if (map[i][j].size == 1) {
                    fireBalls.add(map[i][j]);
                    map[i][j] = null;
                    continue;
                }

                FireBall fireBall = map[i][j];
                fireBall.m /= 5;
                fireBall.s /= fireBall.size;
                map[i][j] = null;
                if (fireBall.m == 0) {
                    continue;
                }
                int k;
                if (fireBall.odd == 0 || fireBall.even == 0) {
                    k = 0;
                } else {
                    k = 1;
                }
                for (; k < 8; k += 2) {
                    fireBalls.add(new FireBall(i, j, fireBall.m, fireBall.s, k));
                }
            }
        }
    }

    public static void countMass() {
        int sum = 0;
        while (!fireBalls.isEmpty()) {
            sum += fireBalls.poll().m;
        }
        System.out.println(sum);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        map = new FireBall[n][n];

        int m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int _m = Integer.parseInt(input[2]);
            int s = Integer.parseInt(input[3]);
            int d = Integer.parseInt(input[4]);
            fireBalls.add(new FireBall(x - 1, y - 1, _m, s, d));
        }
    }
}

class FireBall {
    int x;
    int y;
    int m = 0;
    int s = 0;
    int d;

    int size = 0;
    int odd = 0;
    int even = 0;

    public FireBall(int x, int y, int m, int s, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.add(m, s, d);
    }

    public void add(int m, int s, int d) {
        this.m += m;
        this.s += s;
        if (d % 2 == 0) {
            even++;
        } else {
            odd++;
        }
        size++;
    }
}