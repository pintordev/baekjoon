import java.io.IOException;

public class Main {
    public static int n;
    public static int w;
    public static int[][] files;
    public static int[][] memo;

    public static void main(String[] args) throws IOException {
        n = read();
        w = read();

        files = new int[w + 1][2];
        for (int i = 1; i <= w; i++) {
            files[i][0] = read();
            files[i][1] = read();
        }

        StringBuilder sb = new StringBuilder();

        memo = new int[w + 1][w + 1];
        sb.append(dfs(1, 0, 0)).append('\n');

        int car1 = 0, car2 = 0;
        for (int i = 1; i <= w; i++) {
            if (memo[car1][car2] == dist(car1, i, 1) + memo[i][car2]) {
                sb.append(1).append('\n');
                car1 = i;
            } else {
                sb.append(2).append('\n');
                car2 = i;
            }
        }

        System.out.println(sb);
    }

    public static int dfs(int now, int car1, int car2) {
        if (now > w) return 0;
        if (memo[car1][car2] != 0) return memo[car1][car2];

        int next = now + 1;
        int dist1 = dfs(next, now, car2) + dist(car1, now, 1);
        int dist2 = dfs(next, car1, now) + dist(car2, now, 2);
        return memo[car1][car2] = Math.min(dist1, dist2);
    }

    public static int dist(int f, int t, int c) {
        int[] from = files[f], to = files[t];
        if (f == 0) from = c == 1 ? new int[]{1, 1} : new int[]{n, n};

        return Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}