import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static int n;
    public static int k;
    public static Queue<FireBall> fireBalls = new ArrayDeque<>();
    public static List<FireBall>[][] map;
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
            map[fireBall.x][fireBall.y].add(fireBall);
        }
    }

    public static void split() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].size() < 2) {
                    for (FireBall fireBall : map[i][j]) {
                        fireBalls.add(fireBall);
                    }
                    map[i][j] = new ArrayList<>();
                    continue;
                }

                int m = 0, s = 0, odd = 0, even = 0;
                for (FireBall fireBall : map[i][j]) {
                    m += fireBall.m;
                    s += fireBall.s;
                    if (fireBall.d % 2 == 0) {
                        even++;
                    } else {
                        odd++;
                    }
                }

                m /= 5;
                s /= map[i][j].size();
                map[i][j] = new ArrayList<>();

                if (m == 0) {
                    continue;
                }

                int k;
                if (odd == 0 || even == 0) {
                    k = 0;
                } else {
                    k = 1;
                }

                for (; k < 8; k += 2) {
                    fireBalls.add(new FireBall(i, j, m, s, k));
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
        map = new List[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

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
    int m;
    int s;
    int d;

    public FireBall(int x, int y, int m, int s, int d) {
        this.x = x;
        this.y = y;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}