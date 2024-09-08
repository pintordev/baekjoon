import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Node>[] tree;
    public static int max;
    public static int maxNode;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int v = read();

        tree = new List[v + 1];
        int j;
        for (int i = 1; i <= v; i++) {
            tree[(j = read())] = new ArrayList<>();
            int k;
            while ((k = read()) != -1) {
                tree[j].add(new Node(k, read()));
            }
        }

        max = 0;
        maxNode = 0;
        visited = new boolean[v + 1];
        dfs(1, 0);

        visited = new boolean[v + 1];
        dfs(maxNode, 0);

        System.out.println(max);
    }

    public static void dfs(int i, int len) {
        visited[i] = true;

        if (len > max) {
            max = len;
            maxNode = i;
        }

        for (Node node : tree[i]) {
            if (visited[node.to]) continue;
            dfs(node.to, len + node.len);
        }
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }
}

class Node {
    int to;
    int len;

    public Node(int to, int len) {
        this.to = to;
        this.len = len;
    }
}