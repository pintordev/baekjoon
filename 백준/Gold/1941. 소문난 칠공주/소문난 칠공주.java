import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    public static char[][] map = new char[5][];
    public static int[] comb = new int[7];
    public static int[] cr = new int[25];
    public static int[] cc = new int[25];
    public static int[] dr = {0, 0, 1, -1};
    public static int[] dc = {1, -1, 0, 0};
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            map[i] = readChars();
        }

        for (int i = 0; i < 25; i++) {
            cr[i] = i / 5;
            cc[i] = i % 5;
        }

        comb(0, 0);
        System.out.println(cnt);
    }

    public static void comb(int depth, int idx) {
        if (depth == 7) {
            bfs();
            return;
        }

        if (idx == 25) return;

        comb[depth] = idx;
        comb(depth + 1, idx + 1);
        comb(depth, idx + 1);
    }

    public static void bfs() {
        boolean[] visited = new boolean[7];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(comb[0]);
        visited[0] = true;

        int cntS = 0, cntY = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();

            if (map[cr[cur]][cc[cur]] == 'S') cntS++;

            for (int i = 0; i < 4; i++) {
                int nr = cr[cur] + dr[i];
                int nc = cc[cur] + dc[i];

                for (int j = 1; j < 7; j++) {
                    if (visited[j]) continue;
                    if (nr != cr[comb[j]] || nc != cc[comb[j]]) continue;
                    q.add(comb[j]);
                    visited[j] = true;
                    cntY++;
                }
            }
        }

        if (cntS >= 4 && cntY == 7) cnt++;
    }

    public static char[] readChars() throws IOException {
        char[] c = new char[5];
        int idx = 0, ch;
        while ((ch = System.in.read()) > 32) c[idx++] = (char) ch;
        return Arrays.copyOf(c, idx);
    }
}