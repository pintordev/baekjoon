import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Main {
    public static char[][] board = new char[6][12];
    public static boolean[][] visited;
    public static int cnt = 0;
    public static Queue<Puyo> pop;
    public static int[] dr = {0, 0, 1, -1};
    public static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        readBoard();
        puyoPuyo();
    }

    public static void readBoard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 11; i >= 0; i--) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < 6; j++) {
                board[j][i] = line[j];
            }
        }
    }

    public static void puyoPuyo() {
        while (true) {
            visited = new boolean[6][12];
            boolean isPopped = false;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 12; j++) {
                    if (board[i][j] == '.' || visited[i][j]) {
                        continue;
                    }
                    pop = new ArrayDeque<>();
                    bfs(i, j);

                    if (pop.size() < 4) {
                        continue;
                    }
                    isPopped = true;
                    remove();
                }
            }

            if (!isPopped) {
                break;
            }
            moveDown();
            cnt++;
        }

        System.out.println(cnt);
    }

    public static void bfs(int i, int j) {
        char c = board[i][j];
        Queue<Puyo> queue = new ArrayDeque<>();
        Puyo puyo = new Puyo(i, j);
        queue.add(puyo);
        pop.add(puyo);
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Puyo now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nr = now.r + dr[k];
                int nc = now.c + dc[k];
                if (!canMove(nr, nc, c)) {
                    continue;
                }
                Puyo next = new Puyo(nr, nc);
                queue.add(next);
                pop.add(next);
                visited[nr][nc] = true;
            }
        }
    }

    public static boolean canMove(int nr, int nc, char c) {
        return nr >= 0 && nr < 6 && nc >= 0 && nc < 12 && !visited[nr][nc] && board[nr][nc] == c;
    }

    public static void remove() {
        while (!pop.isEmpty()) {
            Puyo puyo = pop.poll();
            board[puyo.r][puyo.c] = '.';
        }
    }

    public static void moveDown() {
        for (int i = 0; i < 6; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 12; j++) {
                if (board[i][j] != '.') {
                    sb.append(board[i][j]);
                }
            }
            sb.append(".".repeat(12 - sb.length()));
            board[i] = sb.toString().toCharArray();
        }
    }
}

class Puyo {
    int r;
    int c;

    public Puyo(int r, int c) {
        this.r = r;
        this.c = c;
    }
}