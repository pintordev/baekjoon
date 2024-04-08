import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static int n;
    public static int[][] ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        char[][] mapRGB = new char[n][n];
        char[][] mapRB = new char[n][n];
        for (int i = 0; i < n; i++) {
            mapRGB[i] = br.readLine().toCharArray();
            mapRB[i] = mapRGB[i].clone();
            for (int j = 0; j < n; j++) {
                if (mapRB[i][j] == 'G') {
                    mapRB[i][j] = 'R';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(split(mapRGB)).append(' ').append(split(mapRB));
        System.out.println(sb);
    }

    public static int split(char[][] map) {
        int cnt = 0;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    cnt++;
                    bfs(map, visited, i, j);
                }

            }
        }
        return cnt;
    }

    public static void bfs(char[][] map, boolean[][] visited, int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int[] d : ds) {
                int nr = now.r + d[0];
                int nc = now.c + d[1];

                if (isValid(nr, nc) && !visited[nr][nc] && map[now.r][now.c] == map[nr][nc]) {
                    queue.add(new Node(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}

class Node {
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}