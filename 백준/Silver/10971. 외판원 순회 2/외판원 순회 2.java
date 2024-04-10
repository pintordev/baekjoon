import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static int n;
    public static int[][] map;
    public static boolean[] visited;
    public static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        String[] input;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, i, 1, 0);
            visited[i] = false;
        }

        System.out.println(minCost);
    }

    public static void dfs(int i, int start, int depth, int cost) {
        if (cost > minCost) {
            return;
        }
        if (depth == n) {
            if (map[i][start] == 0) {
                return;
            }
            minCost = Math.min(minCost, cost + map[i][start]);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (i == j || visited[j] || map[i][j] == 0) {
                continue;
            }
            visited[j] = true;
            dfs(j, start, depth + 1, cost + map[i][j]);
            visited[j] = false;
        }
    }
}