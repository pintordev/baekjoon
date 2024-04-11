import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int n;
    public static int m;
    public static int[][] map;
    public static List<Node> clouds;
    public static boolean[][] visited;
    public static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] rx = {-1, -1, 1, 1};
    public static int[] ry = {-1, 1, 1, -1};
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int d = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]);
            moveClouds(d, s);
            copyWater();
            makeClouds();
        }
        countWater();
    }

    public static void moveClouds(int d, int s) {
        visited = new boolean[n][n];
        for (Node node : clouds) {
            node.x += dx[d - 1] * s;
            while (node.x < 0) {
                node.x += n;
            }
            node.x %= n;
            node.y += dy[d - 1] * s;
            while (node.y < 0) {
                node.y += n;
            }
            node.y %= n;
            visited[node.x][node.y] = true;
            map[node.x][node.y]++;
        }
    }

    public static void copyWater() {
        for (Node node : clouds) {
            for (int i = 0; i < 4; i++) {
                int nx = node.x + rx[i];
                int ny = node.y + ry[i];
                if (canCount(nx, ny)) {
                    map[node.x][node.y]++;
                }
            }
        }
    }

    public static boolean canCount(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] > 0;
    }

    public static void makeClouds() {
        clouds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || map[i][j] < 2) {
                    continue;
                }
                clouds.add(new Node(i, j));
                map[i][j] -= 2;
            }
        }
    }

    public static void countWater() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt += map[i][j];
            }
        }
        System.out.println(cnt);
    }

    public static void init() throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        clouds = new ArrayList<>();
        clouds.add(new Node(n - 1, 0));
        clouds.add(new Node(n - 1, 1));
        clouds.add(new Node(n - 2, 0));
        clouds.add(new Node(n - 2, 1));
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}