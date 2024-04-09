import java.io.IOException;

class Main {
    public static final int INF = Integer.MAX_VALUE >>> 1;
    public static int n;
    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        readGraph();
        floydWarshall();
    }

    public static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int minI = 0;
        int minV = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++ ) {
                sum += graph[i][j];
            }
            if (minV > sum) {
                minV = sum;
                minI = i;
            }
        }
        System.out.println(minI);
    }

    public static void readGraph() throws IOException {
        n = read();
        int m = read();

        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                graph[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            int a = read();
            int b = read();
            graph[a][b] = 1;
            graph[b][a] = 1;
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