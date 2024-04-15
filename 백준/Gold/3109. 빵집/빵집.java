import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int r;
    public static int c;
    public static char[][] map;
    public static boolean isArrived;
    public static boolean[][] visited;
    public static int[] dr = {-1, 0, 1};
    public static int[] dc = {1, 1, 1};
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        init();
        simulate();
    }

    public static void simulate() {
        for (int i = 0; i < r; i++) {
            isArrived = false;
            dfs(i, 0);
        }
        System.out.println(cnt);
    }

    public static void dfs(int i, int j) {
        if (isArrived) {
            return;
        }

        visited[i][j] = true;
        if (j == c - 1) {
            cnt++;
            isArrived = true;
            return;
        }

        for (int k = 0; k < 3; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];

            if (!canMove(nr, nc)) {
                continue;
            }
            dfs(nr, nc);
        }
    }

    public static boolean canMove(int nr, int nc) {
        return nr >= 0 && nr < r && nc >= 0 && nc < c && !visited[nr][nc] && map[nr][nc] == '.';
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[r][c];
    }
}