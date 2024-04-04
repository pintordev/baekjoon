import java.io.IOException;

class Main {

    public static int n;
    public static int[][] network;
    public static boolean[] visited;
    public static int cnt = -1;

    public static void main(String[] args) throws IOException {
        n = read();
        network = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        int m = read();
        for (int i = 0; i < m; i++) {
            int a = read();
            int b = read();
            network[a][b] = 1;
            network[b][a] = 1;
        }

        dfs(1);
        System.out.println(cnt);
    }

    public static void dfs(int node) {
        visited[node] = true;
        cnt++;
        for (int i = 1; i <= n; i++) {
            if (network[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}