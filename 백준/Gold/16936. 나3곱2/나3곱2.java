import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int n;
    public static long[] clue;

    public static long[] res;
    public static boolean[] visited;
    public static boolean solved;

    public static void main(String[] args) throws IOException {
        n = read();

        clue = new long[n];
        for (int i = 0; i < n; i++) {
            clue[i] = readL();
        }
        Arrays.sort(clue);

        res = new long[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            find(i, 0);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(res[i]).append(' ');
        }
        System.out.println(sb);
    }

    public static void find(int idx, int depth) {
        if (solved) return;
        res[depth] = clue[idx];
        visited[idx] = true;

        if (depth == n - 1) {
            solved = true;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (clue[idx] * 2 == clue[i] || clue[idx] % 3 == 0 && clue[idx] / 3 == clue[i]) {
                find(i, depth + 1);
            }
        }
        visited[idx] = false;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static long readL() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}