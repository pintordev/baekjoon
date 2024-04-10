import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static int n;
    public static int l;
    public static int[][] map;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        readMap();

        for (int i = 0; i < n; i++) {
            findRoad(Arrays.copyOf(map[i], n), true);
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = map[j][i];
            }
            findRoad(col, false);
        }
        System.out.println(cnt);
    }

    public static void findRoad(int[] arr, boolean row) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                cnt++;
            } else if (arr[i] + 1 == arr[i + 1]) {
                int len = 0;
                while (len < l && i - len >= 0 && arr[i] == arr[i - len] && !visited[i - len]) {
                    len++;
                }
                if (len < l) {
                    break;
                }
                while (len > 0) {
                    visited[i - len-- + 1] = true;
                }
            } else if (arr[i] - 1 == arr[i + 1]) {
                int len = 1;
                while (len < l && i + len + 1 < n && arr[i + 1] == arr[i + len + 1]) {
                    len++;
                }
                if (len < l) {
                    break;
                }
                while (len > 0) {
                    visited[i + len--] = true;
                }
                i += l - 1;
            } else if (arr[i] != arr[i + 1]) {
                break;
            }
        }
    }

    public static void readMap() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        l = Integer.parseInt(input[1]);

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
    }
}