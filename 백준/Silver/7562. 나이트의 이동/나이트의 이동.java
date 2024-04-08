import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static int n;
    public static int sr;
    public static int sc;
    public static int er;
    public static int ec;
    public static int[][] board;
    public static int[][] ds = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        String[] input;
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");
            sr = Integer.parseInt(input[0]);
            sc = Integer.parseInt(input[1]);
            input = br.readLine().split(" ");
            er = Integer.parseInt(input[0]);
            ec = Integer.parseInt(input[1]);
            bfs();
        }

        System.out.println(sb);
    }
    
    public static void bfs() {
        board = new int[n][n];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sr, sc));
        board[sr][sc] = 1;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.r == er && now.c == ec) {
                sb.append(board[now.r][now.c] - 1).append('\n');
                return;
            }

            for (int[] d : ds) {
                int nr = now.r + d[0];
                int nc = now.c + d[1];

                if (isValid(nr, nc) && board[nr][nc] == 0) {
                    queue.add(new Node(nr, nc));
                    board[nr][nc] = board[now.r][now.c] + 1;
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