import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int INF = 1_000_000_000;
    public static int v;
    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        v = read();

        graph = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        int e = read();
        while (e-- > 0) {
            graph[read()][read()] = read();
        }

        floydWarshall();
        findMinCycle();
    }

    public static void floydWarshall() {
        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    public static void findMinCycle() {
        int min = INF;
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i == j) continue;
                if (graph[i][j] == INF || graph[j][i] == INF) continue;
                min = Math.min(min, graph[i][j] + graph[j][i]);
            }
        }
        System.out.println(min == INF ? -1 : min);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}