import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int[][] grade = {
            {10, 8, 7, 5, 0, 1},
            {8, 6, 4, 3, 0, 1},
            {7, 4, 3, 2, 0, 1},
            {5, 3, 2, 2, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0}
    };
    public static int n;
    public static int m;
    public static char[] board;
    public static int[][] memo;

    public static void main(String[] args) throws IOException {
        n = read();
        m = read();

        board = new char[n * m];
        String s;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            s = readString();
            for (int j = 0; j < m; j++) {
                board[idx++] = s.charAt(j);
            }
        }

        memo = new int[n * m][1 << m];
        for (int i = 0; i < n * m; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(fill(0, 0));
    }

    public static int fill(int depth, int status) {
        if (depth >= n * m) return 0;
        if (memo[depth][status] != -1) return memo[depth][status];
        if ((status & 1) == 1) return memo[depth][status] = fill(depth + 1, status >> 1);

        int score = 0;
        score = Math.max(score, fill(depth + 1, status >> 1));
        if (depth + m < n * m) score = Math.max(score, grade[board[depth] - 'A'][board[depth + m] - 'A'] + fill(depth + 1, (status >> 1) | (1 << m - 1)));
        if ((depth % m != m - 1) && (status & 1 << 1) == 0) score = Math.max(score, grade[board[depth] - 'A'][board[depth + 1] - 'A'] + fill(depth + 2, status >> 2));
        return memo[depth][status] = score;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static String readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) > 32) {
            sb.append((char) c);
        }
        return sb.toString();
    }
}