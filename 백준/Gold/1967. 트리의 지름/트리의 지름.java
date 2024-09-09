import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Node>[] tree;
    public static int max;
    public static int maxNode;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int n = read();

        tree = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int a = read();
            int b = read();
            int c = read();
            tree[a].add(new Node(b, c));
            tree[b].add(new Node(a, c));
        }

        max = 0;
        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
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
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
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