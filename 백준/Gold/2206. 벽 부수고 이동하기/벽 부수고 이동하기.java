import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        boolean[][][] visited = new boolean[2][n][m];
        int[][] ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, false));
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.r == n - 1 && now.c == m - 1) {
                System.out.println(now.move);
                return;
            }

            for (int[] d : ds) {
                int nr = now.r + d[0];
                int nc = now.c + d[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                if (map[nr][nc] == '1') {
                    if (!now.broken) {
                        queue.add(new Node(nr, nc, now.move + 1, true));
                        visited[1][nr][nc] = true;
                    }
                } else {
                    if (now.broken && !visited[1][nr][nc]) {
                        queue.add(new Node(nr, nc, now.move + 1, true));
                        visited[1][nr][nc] = true;
                    } else if (!now.broken && !visited[0][nr][nc]) {
                        queue.add(new Node(nr, nc, now.move + 1, false));
                        visited[0][nr][nc] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}

class Node {
    int r;
    int c;
    int move;
    boolean broken;

    public Node(int r, int c, int move, boolean broken) {
        this.r = r;
        this.c = c;
        this.move = move;
        this.broken = broken;
    }
}