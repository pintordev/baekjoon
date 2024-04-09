import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Main {

    public static int n;
    public static List<Node>[] graph;
    public static boolean[] visited;
    public static int maxWeight = Integer.MIN_VALUE;
    public static boolean arrived;

    public static void main(String[] args) throws IOException {
        readGraph();
        binarySearch(read(), read());
    }

    public static void binarySearch(int dep, int arr) {
        int low = 0;
        int high = maxWeight;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            visited = new boolean[n + 1];
            arrived = false;
            dfs(dep, arr, mid);
            if (arrived) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(high);
    }

    public static void dfs(int dep, int arr, int shipWeight) {
        if (arrived) {
            return;
        }
        if (dep == arr) {
            arrived = true;
            return;
        }

        for (Node node : graph[dep]) {
            if (visited[node.to] || node.weight < shipWeight) {
                continue;
            }
            visited[node.to] = true;
            dfs(node.to, arr, shipWeight);
        }
    }

    public static void readGraph() throws IOException {
        n = read();
        int m = read();

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = read();
            int b = read();
            int weight = read();
            graph[a].add(new Node(b, weight));
            graph[b].add(new Node(a, weight));
            maxWeight = Math.max(maxWeight, weight);
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

class Node {
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}