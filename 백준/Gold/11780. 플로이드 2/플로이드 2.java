import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static int INF = 1_000_000_000;
    public static int n;
    public static int[][] graph;
    public static int[][] prev;

    public static void main(String[] args) throws IOException {
        n = read();

        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        prev = new int[n + 1][n + 1];

        int m = read();
        while (m-- > 0) {
            int a = read();
            int b = read();
            int c = read();
            graph[a][b] = Math.min(graph[a][b], c);
            prev[a][b] = a;
        }

        floydWarshall();
        print();
    }

    public static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][j] <= graph[i][k] + graph[k][j]) continue;
                    graph[i][j] = graph[i][k] + graph[k][j];
                    prev[i][j] = prev[k][j];
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

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == INF || i == j) {
                    sb.append(0).append('\n');
                    continue;
                }

                Stack<Integer> stack = new Stack<>();
                int k = j;
                while (prev[i][k] != i) {
                    stack.push(k);
                    k = prev[i][k];
                }
                stack.push(k);

                sb.append(stack.size() + 1).append(' ');
                sb.append(i).append(' ');
                while (!stack.isEmpty()) {
                    sb.append(stack.pop()).append(' ');
                }
                sb.append('\n');
            }
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