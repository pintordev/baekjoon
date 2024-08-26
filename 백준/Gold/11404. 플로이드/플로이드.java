import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int INF = 1_000_000_000;
    public static int n;
    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        n = read();

        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        int m = read();
        while (m-- > 0) {
            int s = read();
            int e = read();
            int w = read();
            graph[s][e] = Math.min(graph[s][e], w);
        }

        floydWarshall();
        print();
    }

    public static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(graph[i][j] == INF ? 0 : graph[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}