import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        Queue<Node> queue = new LinkedList<>();
        int sr = 0;
        int sc = 0;
        char[][] map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'S') {
                    sr = i;
                    sc = j;
                } else if (map[i][j] == '*') {
                    queue.add(new Node(i, j, -1));
                }
            }
        }

        int[][] ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        queue.add(new Node(sr, sc, 0));
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node now = queue.poll();

                for (int[] d : ds) {
                    int nr = now.r + d[0];
                    int nc = now.c + d[1];

                    if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
                        continue;
                    }
                    if (map[nr][nc] == '*' || map[nr][nc] == 'X') {
                        continue;
                    }

                    if (now.t == -1) {
                        if (map[nr][nc] == 'D') {
                            continue;
                        }
                        map[nr][nc] = '*';
                        queue.add(new Node(nr, nc, -1));
                    } else {
                        if (map[nr][nc] == 'D') {
                            System.out.println(now.t + 1);
                            return;
                        }
                        if (map[nr][nc] == 'S') {
                            continue;
                        }
                        map[nr][nc] = 'S';
                        queue.add(new Node(nr, nc, now.t + 1));
                    }
                }
            }
        }

        System.out.println("KAKTUS");
    }
}

class Node {
    int r;
    int c;
    int t;

    public Node(int r, int c, int t) {
        this.r = r;
        this.c = c;
        this.t = t;
    }
}