import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {
    public static int n;
    public static char[][] map;
    public static boolean[][] visited;
    public static int cnt = 0;
    public static PriorityQueue<Integer> cntPQ  = new PriorityQueue<>();
    public static int[] dr = {0, 0, 1, -1};
    public static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        readMap();
        findComplex();
        print();
    }

    public static void readMap() throws IOException{
        n = read();
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = readChars();
        }
    }

    public static void findComplex() {

        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || map[i][j] == '0') continue;
                cnt++;
                bfs(i, j);
            }
        }
    }

    public static void bfs(int i, int j) {

        int size = 0;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(i, j));
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            size++;

            for (int k = 0; k < 4; k++) {
                int nr = now.r + dr[k];
                int nc = now.c + dc[k];

                if (!canGo(nr, nc)) continue;
                queue.add(new Node(nr, nc));
                visited[nr][nc] = true;
            }
        }

        cntPQ.add(size);
    }

    public static boolean canGo(int nr, int nc) {
        return nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && map[nr][nc] == '1';
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append('\n');
        while (!cntPQ.isEmpty()) {
            sb.append(cntPQ.poll()).append('\n');
        }
        System.out.println(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static char[] readChars() throws IOException {
        char[] c = new char[25];
        int idx = 0, ch;
        while ((ch = System.in.read()) > 32) c[idx++] = (char) ch;
        return Arrays.copyOf(c, idx);
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